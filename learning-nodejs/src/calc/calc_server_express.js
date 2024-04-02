import express from "express"
import url from "url"
import querystring from "querystring"

const app = express()

app.get('/', (req, res) => {
    res.send("Hello, world!")
})

const ADD = "/add"
const SUB = "/sub"
const MUL = "/mul"
const DIV = "/div"
const POW = "/pow"
const SQR = "/sqr"

const function_lookup = {
    ADD: (x, y) => {return {'x': x, 'y': y, 'op': ADD, 'answer': x+y} },
    SUB: (x, y) => {return {'x': x, 'y': y, 'op': SUB, 'answer': x-y} },
    MUL: (x, y) => {return {'x': x, 'y': y, 'op': MUL, 'answer': x*y} },
    DIV: (x, y) => {return {'x': x, 'y': y, 'op': DIV, 'answer': x/y} },
    POW: (x, y) => {return {'x': x, 'y': y, 'op': POW, 'answer': x**y} },
    SQR: (x, y) => {return {'x': x, 'op': SQR, 'answer': x*x} }
}

function getInputs(req, res) {
    var urlObj = url.parse(req.url)
    var query = urlObj.search
    if (query != null) {
        var inputs = querystring.parse(query.substring(1)) // remove the ?
        var x = Number(inputs.x)
        var y = Number(inputs.y)
    }
    return {x, y}
}

function template_handler(req, res, func) {
    var inputs = getInputs(req, res)
    var retval = func(inputs.x, inputs.y)
    console.log(retval)
    res.setHeader('Content-Type', 'application/json')
    res.send(retval)
}

app.use((req, res, next) => {
    // this is needed so it can be called from another site
    res.setHeader("Access-Control-Allow-Origin", "*");
    next();
  });

app.get(ADD, (req, res) => {
    template_handler(req, res, function_lookup.ADD)
})

app.get(SUB, (req, res) => {
    template_handler(req, res, function_lookup.SUB)
})

app.get(MUL, (req, res) => {
    template_handler(req, res, function_lookup.MUL)
})

app.get(DIV, (req, res) => {
    template_handler(req, res, function_lookup.DIV)
})

app.get(POW, (req, res) => {
    template_handler(req, res, function_lookup.POW)
})

app.get(SQR, (req, res) => {
    template_handler(req, res, function_lookup.SQR)
})

app.listen(8080, () => {
    console.log("Server is up on port 8080")
})
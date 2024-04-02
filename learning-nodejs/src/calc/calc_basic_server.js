import http from 'http'
import url from 'url'
import querystring from 'querystring'

var hw_handler = function(res, query) {
    res.write("\nHello, " + query.name + "!")
}

var add_handler = function(res, query) {
    res.write("\nx=" + query.x)
    res.write("\ny=" + query.y)
    res.write("\nSum=" + (Number(query.x) + Number(query.y)))
}

var sub_handler = function(res, query) {
    res.write("\nx=" + query.x)
    res.write("\ny=" + query.y)
    res.write("\nDifference=" + (Number(query.x) - Number(query.y)))
}

http.createServer(function(req, res) {

    //res.write("Hello, world!")
    var urlObj = url.parse(req.url, true)
    var queryString = urlObj.search
    if(queryString == null || queryString == "") {
        res.end()
        return
    }
    var query = querystring.parse(queryString.substring(1))
    
    console.log(query)
    
    if(urlObj.pathname == "/hw") {
        hw_handler(res, query)
    }

    if(urlObj.pathname == "/add") {
        add_handler(res, query)
    }

    if(urlObj.pathname == "/sub") {
        sub_handler(res, query)
    }
    res.end()
}).listen(8080)


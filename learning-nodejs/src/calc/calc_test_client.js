//Works when calc_server_express is running.

fetch('http://localhost:8080/add?x=3&y=8').then((response) => { 
    response.json().then((data) => {
         if (data.error) {
            console.log(data.error) 
        } else {
            console.log(data)
        } 
    })
})

fetch('http://localhost:8080/sub?x=3&y=8').then((response) => { 
    response.json().then((data) => {
         if (data.error) {
            console.log(data.error) 
        } else {
            console.log(data)
        } 
    })
})

fetch('http://localhost:8080/mul?x=3&y=8').then((response) => { 
    response.json().then((data) => {
         if (data.error) {
            console.log(data.error) 
        } else {
            console.log(data)
        } 
    })
})

fetch('http://localhost:8080/div?x=3&y=8').then((response) => { 
    response.json().then((data) => {
         if (data.error) {
            console.log(data.error) 
        } else {
            console.log(data)
        } 
    })
})

fetch('http://localhost:8080/pow?x=3&y=8').then((response) => { 
    response.json().then((data) => {
         if (data.error) {
            console.log(data.error) 
        } else {
            console.log(data)
        } 
    })
})

fetch('http://localhost:8080/sqr?x=3').then((response) => { 
    response.json().then((data) => {
         if (data.error) {
            console.log(data.error) 
        } else {
            console.log(data)
        } 
    })
})
import React from "react"
import ReactDOM from "react-dom/client"

const menu = (
    <ul>
        <li>Item 1</li>
        <li>Item 2</li>
    </ul>
)

const root = ReactDOM.createRoot(document.getElementById("root"))
root.render(menu)
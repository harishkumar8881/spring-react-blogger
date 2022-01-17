import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import "./index.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import BlogStore from "./store/BlogStore";

ReactDOM.render(
    <BrowserRouter>
        <App store={BlogStore}/>
    </BrowserRouter>,
    document.getElementById("root")
);

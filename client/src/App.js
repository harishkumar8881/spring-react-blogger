import React, { Component } from "react";
import BlogList from "./components/BlogList";
import BlogStore from "./store/BlogStore";

class App extends Component {
    render() {
        return(
          <div>
            <BlogList store={BlogStore}/>
          </div>
        );
    }
}

export default App;

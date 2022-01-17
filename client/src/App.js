import React, { Component } from "react";
import { Route, Routes} from "react-router-dom";
import Blog from "./components/Blog";
import BlogList from "./components/BlogList";
import Header from "./components/Header";
import AddBlog from "./screens/AddBlog";
import EditBlog from "./screens/EditBlog";

class App extends Component {
  BlogStore = this.props.store;
  render() {
        return (
            <div>
                <div className="container">
                    <Header />
                    <div className="col-8 mx-auto">
                        <Routes>
                            <Route path="/" exact element={<BlogList store={this.BlogStore} />} />
                            <Route path="/blog/:blogid" element={<Blog store={this.BlogStore} />} />
                            <Route path="/blog/add" element={<AddBlog/>} />
                            <Route path="/blog/edit/:blogid" element={<EditBlog/>} />
                        </Routes>
                    </div>
                </div>
            </div>
        );
    }
}

export default App;

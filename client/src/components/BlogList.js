import React, {Component} from "react";


const BlogList = ({store}) => {
    return (
        <div>
            <button onClick={() => store.getBlogs()}>Get Blogs</button>
            <button onClick={() => store.addBlog()}>Add Blogs</button>
            Get Bloggies
        </div>
    )
}

export default BlogList;

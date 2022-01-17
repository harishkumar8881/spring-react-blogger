import { observer } from "mobx-react-lite";
import React from "react";
import { useParams } from "react-router-dom";
import blogStore from "../store/BlogStore";

const Blog = () => {
    const params = useParams();
    const blogId = params.blogid;
    const blog = blogStore.blogs.find((blog) => blog.id == blogId) || {title: "", content: ""};
    console.log(blog);
    return (

        <div>
            <h3>{blog.title}</h3>
            <p>
                {blog.content}
            </p>
        </div>
    );
};

export default observer(Blog);

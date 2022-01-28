import { observer } from "mobx-react-lite";
import React from "react";
import { useParams } from "react-router-dom";
import blogStore from "../store/BlogStore";
import CommentsList from "./CommentsList";

const Blog = () => {
    const params = useParams();
    const blogId = params.blogid;
    const blog = blogStore.blogs.find((blog) => blog.id == blogId) || { title: "", content: "", comments:[] };
    console.log(blog);
    return (
        <React.Fragment>
            <div>
                <h3>{blog.title}</h3>
                <p>{blog.content}</p>
            </div>
            <hr/>
            <CommentsList comments={blog.comments} blogid={blog.id}/>
        </React.Fragment>
    );
};

export default observer(Blog);

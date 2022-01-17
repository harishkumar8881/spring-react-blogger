import { observer } from "mobx-react";
import React, { useState } from "react";
import { Navigate, useParams } from "react-router";
import blogStore from "../store/BlogStore";

const EditBlog = ({ history }) => {

    const [title, setTitle] = useState("");
    const [titleChanged, setTitleChanged] = useState(false);
    const [content, setContent] = useState("");
    const [contentChanged, setContentChanged] = useState(false);

    const [redirect, setRedirect] = useState(null);
    const params = useParams();
    const blogId = params.blogid;

    const blog = blogStore.blogs.find((blog) => blog.id == blogId) || { title: "", content: "" };



    const handleSubmit = (e) => {
        e.preventDefault();
        const blog = {
            title,
            content,
        };
        blogStore.updateBlog(blogId, blog, (data) => {
            if (typeof data.error !== "undefined") {
                alert(data.error);
            } else {
                alert("Successfully Edited Blog");
                setRedirect("/");
            }
        });
    };

    const handleTitleChange = (e) => {
        setTitleChanged(true);
        setTitle(e.target.value)
    }

    const handleContentChange = (e) => {
        setContentChanged(true);
        setContent(e.target.value)
    }




    return (
        <React.Fragment>
            {redirect ? <Navigate to={redirect} /> : <React.Fragment></React.Fragment>}
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="title-input">Title</label>
                    <input
                        id="title-input"
                        className="form-control"
                        type="text"
                        onChange={handleTitleChange}
                        value={!titleChanged ?  blog.title : title}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="content-textarea">Content</label>
                    <textarea
                        name="content"
                        className="form-control"
                        id="content-textarea"
                        cols="30"
                        rows="10"
                        onChange={handleContentChange}
                        value={!contentChanged ? blog.content : content}
                    ></textarea>
                </div>
                <div className="mb-3">
                    <input className="btn btn-success float-end" type="submit" value="Submit" />
                </div>
            </form>
        </React.Fragment>
    );
};

export default observer(EditBlog);

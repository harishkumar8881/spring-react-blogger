import React, { useState } from "react";
import { Navigate } from "react-router";
import blogStore from "../store/BlogStore";

const AddBlog = ({ history }) => {
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");
    const [redirect, setRedirect] = useState(null);

    const handleSubmit = (e) => {
        e.preventDefault();
        const blog = {
            title,
            content,
        };
        blogStore.addBlog(blog, (data) => {
            if (typeof data.error !== "undefined") {
                alert(data.error);
            } else {
                alert("Successfully Added Blog");
                setRedirect("/")
            }
        });
    };
    return (
        <React.Fragment>
            {
                redirect ? <Navigate to={redirect} />:<React.Fragment></React.Fragment>
            }
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="title-input">Title</label>
                    <input
                        id="title-input"
                        className="form-control"
                        type="text"
                        onChange={(e) => setTitle(e.target.value)}
                        value={title}
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
                        onChange={(e) => setContent(e.target.value)}
                        value={content}
                    >
                    </textarea>
                </div>
                <div className="mb-3">
                    <input className="btn btn-success float-end" type="submit" value="Submit" />
                </div>
            </form>
        </React.Fragment>
    );
};

export default AddBlog;

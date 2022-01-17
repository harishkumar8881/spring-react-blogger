import { observer } from "mobx-react";
import React, { Component } from "react";
import { Link } from "react-router-dom";

const BlogList = ({ store }) => {

    const handleDelete = (e, id) => {
        e.preventDefault();
        if(confirm("Are you sure want to delete this Blog ?")){
            store.deleteBlog(id, (data)=> {
                if (typeof data.error !== "undefined"){
                    alert(data.error);
                }else{
                    alert("Blog Deleted");
                }
            })
        }
    }

    return (
        <React.Fragment>
            <h3>List of Blogs</h3>
            <ul className="list mb-5">
                {store.blogs.map((blog, index) => {
                    return (
                        <li key={index}>
                            <Link to={"/blog/" + blog.id}>{blog.title}</Link>
                            <div className="float-end">
                                <Link className="mx-2" to={`/blog/edit/${blog.id}`}>
                                    Edit
                                </Link>
                                <Link className="mx-2" to={`/blog/delete/${blog.id}`} onClick={(e) => handleDelete(e, blog.id)}>
                                    Delete
                                </Link>
                            </div>
                        </li>
                    );
                })}
            </ul>
        </React.Fragment>
    );
};

export default observer(BlogList);

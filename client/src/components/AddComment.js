import React, { useState } from "react"
import blogStore from "../store/BlogStore";

const AddComment = ({blogid}) => {

    const [commentText, setCommentText] = useState('')

    const handleFormSubmit = (e) => {
        e.preventDefault();
        blogStore.addCommentToBlog(commentText, blogid, (data)=>{
            if (typeof data.error !== "undefined") {
                alert(data.error);
            } else {
                alert("Successfully Added Comment to blog");
            }
        })
    }

    return (
        <div>
            <h4>AddComment</h4>
            <form onSubmit={handleFormSubmit}>
                <div className="mb-3 form-group d-flex">
                    <input className="form-control" type="text" style={{paddingRight: '80px'}} value={commentText} onChange={(e)=> setCommentText(e.target.value)} placeholder="Add Comment"/>
                    <button type="text" value="submit" style={{marginLeft: '-80px', width: '80px'}} className="btn btn-small btn-primary">Add</button>
                </div>
                <div className="mb-3 form-group text-end">
                </div>
            </form>
        </div>
    )

}

export default AddComment;
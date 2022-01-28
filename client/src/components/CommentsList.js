import React from "react"; 
import AddComment from "./AddComment";
import Comment from "./Comment";

const Comments = ({comments, blogid}) => {
    return (
        <div>
            <h3>Comments</h3>
            {
                comments.map((comment, index) => {
                    return <Comment key={index} username={"Anonymous"} text={comment.text}/>
                })
            }
            {/* <Comment/>
            <Comment/>
            <Comment/> */}
            <hr/>
            <AddComment blogid={blogid}/>
        </div>
    )
}

export default Comments;
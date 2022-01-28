import React from "react";

const Comment = ({text, username}) => {
    return (
        <div className="row">
            <h5>{username}</h5>
            <p>&emsp;{text}</p>
        </div> 
    )
}

export default Comment;
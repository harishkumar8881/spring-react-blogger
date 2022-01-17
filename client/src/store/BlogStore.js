import { action, observable } from "mobx";
import axios from "../config/axios";

class BlogStore {

    _blogs = [];

    get blogs () {
        return this._blogs;
    }

    getBlogs = action(() => {
        axios.get("/blog").then((response) => {
            this._blogs = response.data;
        });
    });

    addBlog = action(()=> {
        axios.post("/blog", {
            "title" : "Dababy's Sherlock",
            "content" : "lorem 30"
        }).then((response) => {
            if (response.status === 201){
                this.getBlogs();
                alert("Successfully Added Blog");
            }else{
                alert("Something went wrong");
            }
        })
    });

    deleteBlog = action((blog)=> {
        axios.delete("/blog/" + blog.id).then(response => {
            if(response.status === 200){
                alert("Successfully Deleted Blog");
            }else{
                alert("Something went wrong.");
            }
        })
    })
}

export default new BlogStore();

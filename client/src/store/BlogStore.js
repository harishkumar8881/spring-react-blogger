import { action, observable, toJS } from "mobx";
import axios from "../config/axios";

class BlogStore {

    _blogs = observable([
        {
            "title": "Hello Title",
            "content": "Hello Content"
        }
    ]);

    constructor(){
        this.getBlogs();
    }

    get blogs () {
        return toJS (this._blogs);
    }

    getBlogs = action(() => {
        return axios.get("/blog").then((response) => {
            this._blogs.replace(response.data);
            console.log(this.blogs);
        });
    });

    addBlog = action((blog,callback)=> {
        axios.post("/blog", blog).then((response) => {
            if (response.status === 201){
                this.getBlogs();
                callback({});
            }else{
                callback({error: "Something went wrong"})
            }
        })
    });

    deleteBlog = action((id, callback)=> {
        axios.delete("/blog/" + id).then(response => {
            if(response.status === 200){
                this.getBlogs();
                callback({})
            }else{
                callback({
                    error: "Something went wrong" 
                })
            }
        })
    })

    updateBlog = action((id, blog, callback) => {
        axios.put("/blog/" + id, blog).then(response => {
            if(response.status === 200){
                this.getBlogs();
                callback({});
            }else{
                callback({
                    error: "Something went wrong"
                })
            }
        })
    })

}

const blogStore = new BlogStore(); 
window.blogStore = blogStore;
export default blogStore;

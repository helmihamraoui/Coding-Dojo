import {model , Schema} from "mongoose"
const BooksSchema = new Schema(
    {
        title : {
            type : String,
            required:[true,"Title is required!"],
            minlength: [2, "Title must be at least 2 characters long!"],
            maxlength: [255, "Title must be less than 255 characters long"]
        },
        author: {
            type:String,
            required:[true,"author is required!"],
            minlength: [5, "author must be at least 5 characters long!"],
            maxlength: [255, "author must be less than 255 characters long"]
        },
        pages:{
            type:Number,
            required:[true,"pages is required!"],
            min: [1, "pages must be at least 1 page !"],
        },
        isAvailable:{
            type : Boolean,
            default: false
        }
    },
    {timestamps:true}
)
const Books =model("Books",BooksSchema)
export default Books;
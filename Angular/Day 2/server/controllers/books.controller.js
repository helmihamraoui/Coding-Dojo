import Books from "../models/books.model.js";

const BooksController={
    create:async (req, res) => {
        try {
            const newBooks = await Books.create(req.body)
            res.json(newBooks)
        } catch (err) {
            console.log(err)
            res.status(400).json(err)
        }
    },
    ReadAll:async (req, res) => {
        try {
            const AllBooks = await Books.find()
            res.json(AllBooks)
        } catch (err) {
            console.log(err)
            res.status(400).json(err)
        }
    },
    ReadOne:async(req,res)=>{
        try {
            const book =await Books.findById(req.params.id)
            res.json(book)
        }catch(err){
            console.log(err)
            res.status(400).json(err)
        }
    },update: async (req, res) => {
        const options = {
            new: true,
            runValidators: true
        }
        try {
            const updatedBook = await Books.findByIdAndUpdate(req.params.id, req.body, options)
            res.json(updatedBook)
        } catch (err) {
            console.log(err)
            res.status(400).json(err)
        }
    },
    DeleteOne: async (req, res) => {
        try {
            const onebook = await Books.findByIdAndDelete(req.params.id)
            res.json({ response: " delete with Success " })
        } catch (err) {
            console.log(err)
            res.status(400).json(err)
        }
    }
}
export default BooksController
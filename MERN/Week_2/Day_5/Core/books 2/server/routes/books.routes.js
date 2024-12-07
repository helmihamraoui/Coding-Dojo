import BooksController from '../controllers/books.controller.js'
import { Router } from "express"


const router = Router()

router.route("/books")
    .post(BooksController.create)
    .get(BooksController.ReadAll)
router.route("/books/:id")
    .get(BooksController.ReadOne)
    .put(BooksController.update)
    .delete(BooksController.DeleteOne)





export default router
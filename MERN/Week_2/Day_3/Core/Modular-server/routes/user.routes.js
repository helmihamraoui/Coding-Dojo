import userController from "../controllers/user.controller";
import {Router} from 'express';
const router=Router()


router.route("/users/new")
    .get (userController.ReadAll)
router.route("/companies/new")
    .get ( userController.companies)
router.route("/user/company")
    .get (userController.usercompanies)

export default router
import tvController from '../controllers/Tv.controller.js';
import {Router} from 'express';
const router=Router()


router.route('/')
    .get(tvController.getAllShows)  
    .post(tvController.addShow);  
router.route('/:year')
    .get(tvController.getShowsByYear); 
router.route('/:title')
    .delete(tvController.deleteShowByTitle) 
    .patch(tvController.updateStarring);    


export default router;

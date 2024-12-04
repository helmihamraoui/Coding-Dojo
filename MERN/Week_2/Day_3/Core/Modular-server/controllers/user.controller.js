
import {createUser, createCompany} from '../modules/user.module.js'

const userController={
    ReadAll:(req, res) => {
        const user = createUser();
        res.json(user);
    },
    companies:(req, res) => {
        const company = createCompany();
        res.json(company);
    },
    usercompanies: (req, res) => {
        const user = createUser();
        const company = createCompany();
        res.json({ user, company });
    }
}








export default userController
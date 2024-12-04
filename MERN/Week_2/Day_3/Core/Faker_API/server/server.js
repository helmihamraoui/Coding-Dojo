import express from "express";
import { faker } from "@faker-js/faker";
const app = express();
const port = 5000;
const createUser = () => ({
    _id: faker.datatype.uuid(),
    firstName: faker.name.firstName(),
    lastName: faker.name.lastName(),
    email: faker.internet.email(),
    password: faker.internet.password(),
    phoneNumber: faker.phone.phoneNumber(),
});
const createCompany = () => ({
    _id: faker.datatype.uuid(),
    name: faker.company.companyName(),
    address: {
        street: faker.address.streetAddress(),
        city: faker.address.city(),
        state: faker.address.state(),
        zipCode: faker.address.zipCode(),
        country: faker.address.country(),
    },
});


app.get("/api/users/new", (req, res) => {
    const user = createUser();
    res.json(user);
});
app.get("/api/companies/new", (req, res) => {
    const company = createCompany();
    res.json(company);
});
app.get("/api/user/company", (req, res) => {
    const user = createUser();
    const company = createCompany();
    res.json({ user, company });
});


app.listen(port, () => console.log("Server is running on port " + port));


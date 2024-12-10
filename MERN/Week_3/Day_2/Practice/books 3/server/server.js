import express from 'express';
import cors from 'cors';
import dotenv from 'dotenv';
import dbConnect from './config/mongoose.config.js';
import router from './routes/books.routes.js';

const app = express();
app.use(express.json(), cors());
dotenv.config();
const PORT = process.env.PORT;
app.use("/api", router)
dbConnect();
app.listen(PORT, () =>
    console.log(`Listening on port: ${PORT}`)
);
import express from 'express';
import tvRoutes from './routes/Tv.routes.js';

const app = express();
const port = 5000;
app.use(express.json());
app.use('/', tvRoutes);





app.listen(port, () => {
    console.log(`Server is running on http://localhost:`+port);
});

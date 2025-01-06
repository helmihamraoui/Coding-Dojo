import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ViewBookComponent } from './view-book/view-book.component';

export const routes: Routes = [
    {path:'',component:HomeComponent},
    {path:'book/:id',component:ViewBookComponent}
];

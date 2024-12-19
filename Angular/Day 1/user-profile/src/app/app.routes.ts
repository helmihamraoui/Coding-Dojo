import { Routes } from '@angular/router';
import { FormComponent } from './form/form.component';
import { DisplayComponent } from './display/display.component';

export const routes: Routes = [
    {path:"form",component:FormComponent},
    {path:"display",component:DisplayComponent}
];

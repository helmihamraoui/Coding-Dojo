import { Component } from '@angular/core';
import { StudentListComponent } from './student-list/student-list.component';
import {log} from "console";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [StudentListComponent] 
})
export class AppComponent {
  title = 'Welcome to Student App!';
  course="full-stack Development"
  onNotify(msg:string){
    console.log(msg)
  }
}

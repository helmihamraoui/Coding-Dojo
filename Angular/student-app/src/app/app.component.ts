import { Component } from '@angular/core';
import { StudentListComponent } from './student-list/student-list.component'; // Import standalone component

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true, // Mark AppComponent as standalone
  imports: [StudentListComponent] // Import StudentListComponent here
})
export class AppComponent {
  title = 'Welcome to Student App!';
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; 

@Component({
  selector: 'app-student-list',
  standalone: true, 
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  imports: [CommonModule] 
})
export class StudentListComponent {
  students = [
    { id: 1, name: 'Alice', age: 22 },
    { id: 2, name: 'Bob', age: 24 },
    { id: 3, name: 'Charlie', age: 23 }
  ];
}

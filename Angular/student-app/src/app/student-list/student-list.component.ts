import { Component, Input,EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common'; 

@Component({
  selector: 'app-student-list', 
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  imports: [CommonModule] 
})
export class StudentListComponent {
  @Input() course:String=""
  msg="Student list has been updated !"
  @Output() notifyParent = new EventEmitter<string>();
  updateStudent(){
    this.notifyParent.emit(this.msg)
  }
  students = [
    { id: 1, name: 'Alice', age: 22 },
    { id: 2, name: 'Bob', age: 24 },
    { id: 3, name: 'Charlie', age: 23 }
  ];
}

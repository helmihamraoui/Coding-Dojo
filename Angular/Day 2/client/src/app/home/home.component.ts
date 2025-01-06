import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../navbar/navbar.component";
import { RouterModule } from '@angular/router';
import { Books } from '../books';

@Component({
  selector: 'app-home',
  imports: [CommonModule, NavbarComponent,RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  title:string="Book Catalog"
  books:Books[]=[]
  constructor(private apiService:ApiService){}
  ngOnInit(): void {
    this.apiService.getAll().subscribe({
      next:data=>{
        this.books=data
      }
    })
  }
}

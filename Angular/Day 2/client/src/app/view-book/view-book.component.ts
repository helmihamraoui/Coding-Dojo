import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute, RouterModule,Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-view-book',
  imports: [CommonModule, NavbarComponent,RouterModule],
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
  book: any = null; // This will store the book details
  title: string = '';
  
  constructor(private apiService: ApiService, private route: ActivatedRoute,private router: Router) {}
  ngOnInit(): void {
    const bookId = this.route.snapshot.paramMap.get('id');
    if (bookId) {
      this.apiService.getOne(bookId).subscribe({
        next: (data) => {
          this.book = data;
          this.title=this.book.title // Store the fetched book data
        },
        error: (error) => {
          console.error('Error fetching book:', error); // Handle error
        }
      });
    }
  }
  deleteOne(id:string):void{
    this.apiService.deleteBook(id).subscribe({
      next:()=> {
        this.router.navigate(['/']);
      }
    })
  }
}

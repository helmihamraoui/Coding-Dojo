import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl='http://localhost:5000/api'
  constructor(private http:HttpClient) {}
  getAll():Observable<any>{
    return this.http.get(`${this.baseUrl}/books`).pipe(
      catchError(this.handleError)
    )
  }
  createBook(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/books`, data).pipe(
      catchError(this.handleError)
    );
  }
  getOne(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/books/${id}`).pipe(
      catchError(this.handleError)
    );
  }
  updateBook(id: string, data: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/books/${id}`, data).pipe(
      catchError(this.handleError)
    );
  }
  deleteBook(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/books/${id}`).pipe(
      catchError(this.handleError)
    );
  }
  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    return throwError(()=>error.error.errors);
  }
}

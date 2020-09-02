import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';

import { IBook } from './book/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  
  constructor(private http:HttpClient) { }
  getBooks():Observable<IBook[]>{
    let url='http://localhost:8080/library/all';
    return this.http.get<IBook[]>(url);
  }
  getBook(id:number):Observable<IBook>{
    let url=`http://localhost:8080/library/all/${id}`
    return this.http.get<IBook>(url)
  }
  addBookToCart(id:number){
    let url=`http://localhost:8080/library/all/${id}`
    return this.http.post(url,null);
  }
  getCart():Observable<IBook[]>{
    let url='http://localhost:8080/library/cart/1';
    return this.http.get<IBook[]>(url);
  }
  DelteCart(id):Observable<any>{
    let url=`http://localhost:8080/library/delete/${id}`
    return this.http.delete(url);
  }
 
}

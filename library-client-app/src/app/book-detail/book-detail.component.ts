import { Component, OnInit } from '@angular/core';
import { IBook } from '../book/book';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  pageTitle:string="BookDetail";
  book:IBook;
  ID:number;
  constructor(private route:ActivatedRoute, private router :Router,private bookService:BookService) { }

  ngOnInit() {
    
    let id= +this.route.snapshot.paramMap.get('id');
    this.ID=id;
    this.bookService.getBook(id).subscribe(
      data=>{
        this.book=data;
      }
      );
      
  }
  onBack():void {
    this.router.navigate(['/library/all'])
  }
  addBook():void{
    let id= +this.route.snapshot.paramMap.get('id');
    this.bookService.addBookToCart(id).subscribe(
      (data)=>{return data}
    );
    alert(this.book.title+' was added to your cart')
  }
}

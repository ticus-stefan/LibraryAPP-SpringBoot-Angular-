import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { IBook } from '../book/book';
import { Observable, BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  totalPrice:number=0;
  load:boolean=false;

  books:IBook[];
  
  constructor(private bookService:BookService) { 
    
  }

  ngOnInit() {
    
    this.bookService.getCart().subscribe(
    data=>{this.books=data,
      this.books.forEach(
        (element)=>{
          this.totalPrice+=element.price;
        },
      );
    }
    )
    this.load=false;
  }
  deleteCart(book:IBook){
    this.bookService.DelteCart(book.id).subscribe(
      res=>{
        let index=this.books.indexOf(book);
        this.books.splice(index,1);
        this.totalPrice=0;
        this.books.forEach(
          (element)=>{  
            this.totalPrice+=element.price;
          })
      }
    )
  }
  loadOrder(){
    this.load=true;
  }
  updatePrice(){
    this.totalPrice=this.totalPrice
    console.log(this.totalPrice)
  }
  
}

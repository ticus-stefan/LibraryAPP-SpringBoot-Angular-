import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { IBook } from './book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
books:IBook[];
_listFilter:string;
get listFilter():string{
  return this._listFilter
}
set listFilter(value:string){
this._listFilter=value;
this.filteredProducts=this.listFilter? this.performFilter(this.listFilter): this.books;
}
filteredProducts:IBook[];
showImage:boolean=false;
  constructor(private bookService:BookService) { }

  ngOnInit() {
    this.bookService.getBooks().subscribe(
    data=>{this.books=data;
      this.filteredProducts=this.books}
    )
    this.filteredProducts=this.books;
  }
  toggleImage():void{
    this.showImage=!this.showImage;
       
     }
  performFilter(filterBy:string):IBook[] {
      filterBy=filterBy.toLocaleLowerCase();
      return this.books.filter((book:IBook)=>
        book.title.toLocaleLowerCase().indexOf(filterBy)!== -1)
    }


}

import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Input } from '@angular/core';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  @Input() totalPrice;
model:Order={
  name:"",
  adress:"",
  price:0
}

  constructor(private http:HttpClient) { }

  ngOnInit() {
  

  }
  sendOrder():void{
    this.model.price=this.totalPrice;
    console.log(this.totalPrice)
    let url="http://localhost:8080/library/order";
    if(this.model.name!="" && this.model.name!=""){
    this.http.post(url,this.model).subscribe(
      res=>{
        console.log(res);
      }
    )
    this.http.delete(url).subscribe(
      res=>{
        console.log(res)
      }
    )
    }
 }
}
export interface Order{
  name:string;
  adress:string;
  price:number
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { HttpClientModule } from '@angular/common/http';
import { WelcomeComponent } from './welcome/welcome.component';
import { RouterModule} from '@angular/router';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component'; 
import{FormsModule} from '@angular/forms';
import { ThanksComponent } from './thanks/thanks.component';  


@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    WelcomeComponent,
    BookDetailComponent,
    CartComponent,
    OrderComponent,
    ThanksComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'library/thanks',component:ThanksComponent},
      {path: 'library/cart',component:CartComponent},
      {path: 'library',component:WelcomeComponent},
      {path:'library/all',component:BookComponent},
      {path:'library/all/:id',component:BookDetailComponent},
      {path:'',redirectTo:'library',pathMatch:'full'},
      {path:'**',redirectTo:'library',pathMatch:'full'}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

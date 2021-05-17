import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CartProduct } from 'src/app/CartProduct';
import { CartService } from 'src/app/Services/Cart/cart.service';

@Component({
  selector: 'app-cart-content',
  templateUrl: './cart-content.component.html',
  styleUrls: ['./cart-content.component.css']
})
export class CartContentComponent implements OnInit {

  cartProducts : CartProduct[];
  loggedIn = Boolean(localStorage.getItem('status'));
  removeMsg: string = "";
  subTotal: number = 0;
  delivery: number = 0;
  total: number = 0;
  checkoutProducts: any;

  constructor(private cartService: CartService, private router: Router, private matSnackbar: MatSnackBar) {
    this.cartProducts = [];
    this.getCartProducts(String(localStorage.getItem('userName')));
  }

  ngOnInit(): void {
    
  }

  getCartProducts(userName: string){
    this.cartService.getCartProducts(userName).subscribe(
      (response: CartProduct[])=>{
        this.cartProducts = response;
        for(let product of this.cartProducts){
          this.subTotal = this.subTotal+(parseFloat(String(product.price))*parseInt(String(product.quantity)));
        }
        if(this.subTotal<500 && this.subTotal>0){
          this.delivery = 70;
        }
        this.total = this.subTotal + this.delivery;
        
      },
      (error: HttpErrorResponse)=>{
        alert('Failed to connect to backend. '+ error.message);
      }
    )
  }
  
  checkoutClick(){
    localStorage.setItem('checkoutProducts', JSON.stringify(this.cartProducts));
    localStorage.setItem('checkoutTotal', String(this.total));
    
    
    const userName = localStorage.getItem('userName')
    this.router.navigate(['/checkout', userName]);
  }

  onRemoveClick(cartId: string){
    // console.log(productCode);
    this.cartService.deleteProductFromCart(cartId).subscribe(
      (response)=>{
        this.matSnackbar.open("Removed Product from cart", 'Dismiss', {duration: 2000})
        setTimeout( function(){ 
          location.reload(); 
        }, 2000);
                  
      },
      (error: HttpErrorResponse)=>{
        alert('Could not remove the product from cart. Please try after some time.');
        
      }
    );
    
  }
  onQuantityChange( id: string, quantity: number){

    console.log(quantity);
    for(let product of this.cartProducts){
      if(product.id === id){
        product.quantity = quantity;
      }
    }
    this.subTotal = 0;
    for(let product of this.cartProducts){
      this.subTotal = this.subTotal+(parseFloat(String(product.price))*parseInt(String(product.quantity)));
    }
    if(this.subTotal>500){
      this.delivery = 0;
    }
    this.total = this.subTotal + this.delivery;
  }

  
}

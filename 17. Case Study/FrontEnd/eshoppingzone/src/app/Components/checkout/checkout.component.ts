import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AddressService } from 'src/app/Services/AddressService/address.service';
import { CartService } from 'src/app/Services/Cart/cart.service';
import { OrderService } from 'src/app/Services/OrderService/order.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
 
  isAddress = false;
  addresses : any[] = [];
  addressExist: boolean = false;
  username: string;
  shippingAddress: any;
  constructor(private addressService: AddressService, private router: Router, private orderService: OrderService, private cartService: CartService, private matSnackBar: MatSnackBar) {
    this.username = String(localStorage.getItem('userName'))
  }

  ngOnInit(): void {
    this.getAddressByUsername(String(localStorage.getItem('userName')));
  }
  getAddressByUsername(username: string){
    this.addressService.getAddressByUsername(username).subscribe(
      (response: any[])=>{
        this.addresses = response;
        if(this.addresses.length === 0){
          this.addressExist = false;
        }else{
          this.addressExist = true;
        }
      },
      (error: HttpErrorResponse)=>{
        alert('Failed to connect to backend. '+ error.message);
      }
    )
  }
  
  onAddAddress(data: NgForm) {
    this.addressService.addAddress(data.value).subscribe(
      (response: any) => {
        console.log(response);
        data.reset();
        location.reload();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
        data.reset();
      }
    );
  }
  onSelectAddress(address: any){
    this.shippingAddress = address;
    localStorage.setItem('shippingAddress', JSON.stringify(this.shippingAddress));
    
  }
  redirectToPayment(){
    let checkoutProducts =JSON.parse(String(localStorage.getItem('checkoutProducts')));
    for(let checkoutProduct of checkoutProducts){
      let orderProduct = checkoutProduct;
      console.log(orderProduct);
      this.matSnackBar.open("Your Order has been placed", "Dismiss", {duration: 2000})
      this.cartService.deleteProductFromCart(checkoutProduct.cartId).subscribe();
      orderProduct.username = String(localStorage.getItem('userName'))
      this.orderService.addToOrder(orderProduct).subscribe(
        (response: any)=>{
          console.log(response);
         
          localStorage.removeItem('shippingAddress');
          localStorage.removeItem('checkoutProducts');
          localStorage.removeItem('checkoutTotal');
          this.router.navigate(['/orders/'+String(localStorage.getItem('userName'))]);          
        },
        (error: HttpErrorResponse)=>{
          alert("FailedTo Connect To Cart Sevice. "+error.message );
        }
      );
        

    }
    
  }
}

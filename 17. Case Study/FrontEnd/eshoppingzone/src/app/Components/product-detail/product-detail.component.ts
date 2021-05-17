import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { CartProduct } from 'src/app/CartProduct';
import { Product } from 'src/app/product';
import { CartService } from 'src/app/Services/Cart/cart.service';
import { ProductService } from 'src/app/Services/Product/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  product: any;
  available: boolean= false;
  loggedIn = Boolean(localStorage.getItem('status'));
  constructor(private route: ActivatedRoute, private productService: ProductService, private cartService: CartService, private matSnackBar: MatSnackBar) {
    let productId = '' + this.route.snapshot.paramMap.get('id');
    this.getProductsById(productId);
  }

  ngOnInit(): void {
  }
  getProductsById(id: string){
    this.productService.getProductsByid(id).subscribe(
      (response: any)=>{
        this.product = response;
        this.available = Boolean(this.product.quantity);
        console.log(this.product);
      },
      (error: HttpErrorResponse)=>{
        alert(error.message)
      }
    );
  }
  onAddToCartClick(){
    // Actually Adding to the cart
    const cartProduct: CartProduct = this.product;
    cartProduct.username = String(localStorage.getItem('userName'));
    cartProduct.quantity = 1;

    this.cartService.addToCart(cartProduct).subscribe(
      (response: CartProduct)=>{
        this.matSnackBar.open("Added Product to cart", "Dismiss", {duration: 2000})
      },
      (error: HttpErrorResponse)=>{
        alert("FailedTo Connect To Cart Sevice. "+error.message );
      }
    );
  }
}

import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { ProductService } from 'src/app/Services/Product/product.service';
import { Product } from 'src/app/product';
import { CartProduct } from 'src/app/CartProduct';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CartService } from 'src/app/Services/Cart/cart.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-product-content',
  templateUrl: './product-content.component.html',
  styleUrls: ['./product-content.component.css'],
})
export class ProductContentComponent {
 
  currentUrl = window.location.href;
  loggedIn = Boolean(localStorage.getItem('status'));
  isWideScreen: Observable<boolean>;
  isSmallScreen: Observable<boolean>;
  public productDesktop: Product[];

  
  constructor( private breakpointObserver: BreakpointObserver, private productService: ProductService, private route: ActivatedRoute, private matSnackBar: MatSnackBar, private cartService: CartService, private router: Router) {
    
    this.isWideScreen = this.breakpointObserver.observe(['(min-width: 700px)']).pipe( map( ({matches})=> matches))
    this.isSmallScreen = this.breakpointObserver.observe(['(max-width: 700px)']).pipe( map( ({matches})=> matches))
    this.productDesktop = [];
    //Get the category from the URL
    //Appending to an empty string because otherwise it gives error :-(
    let category = '' + this.route.snapshot.paramMap.get('category');
    //Get products based on the category
    this.getProducts(category);
  }

  //The method that gets products based on the category (category is received from the url)
  public getProducts(cat: string): void {
    this.productService.getProductsByCategory(cat).subscribe(
      (response: Product[]) => {
        this.productDesktop = response;
      },
      (error: HttpErrorResponse) => {
        alert('Failed to connect to the backend. ' + error.message);
      }
    );
  }

  getImage(imageName: String): string {
    return 'url(' + imageName;
  }

  onAddToCartClick(product: any, message: any, action: any){
    // Actually Adding to the cart
    const cartProduct: CartProduct = product;
    cartProduct.username = String(localStorage.getItem('userName'));
    cartProduct.quantity = 1;

    this.cartService.addToCart(cartProduct).subscribe(
      (response: CartProduct)=>{
        this.matSnackBar.open("Added "+String(message)+" to cart", action, {duration: 2000})
      },
      (error: HttpErrorResponse)=>{
        alert("FailedTo Connect To Cart Sevice. "+error.message );
      }
    );
    
    
  }
  onLoginClick(){
    this.router.navigate(['/login']);
  }
  onViewClick(id: any){
    this.router.navigate(['/product', id]);
  }
}

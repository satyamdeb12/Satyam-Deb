import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CartProduct } from 'src/app/CartProduct';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartBaseUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {
  }

  public addToCart(cartProduct: CartProduct): Observable<CartProduct> {
    return this.http.post<CartProduct>(`${this.cartBaseUrl}/cart/add`, cartProduct);
  }

  // Get All Products in cart
  
  public getCartProducts(userName: string): Observable<CartProduct[]> {
    return this.http.get<CartProduct[]>(`${this.cartBaseUrl}/cart/get/${userName}`);
  }

  // Delete product from cart
  public deleteProductFromCart(cartId: string): Observable<any> {
    return this.http.delete<any>(`${this.cartBaseUrl}/cart/delete/${cartId}`);
  }

  // Update Cart Product Quantity
  public updateQuantity(cartProduct: CartProduct): Observable<CartProduct> {
    return this.http.put<CartProduct>(`${this.cartBaseUrl}/cart/update`,cartProduct);
  }


}

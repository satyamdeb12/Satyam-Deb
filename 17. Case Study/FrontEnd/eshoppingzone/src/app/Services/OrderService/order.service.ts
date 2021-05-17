import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  orderBaseUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}
  public addToOrder(product: any): Observable<any> {
    return this.http.post<any>(`${this.orderBaseUrl}/orders/add`, product);
  }

  // Get All Products in cart
  
  public getOrderProducts(userName: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.orderBaseUrl}/orders/get/${userName}`);
  }

  public getOrderProductsBySeller(seller: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.orderBaseUrl}/orders/get/seller/${seller}`);
  }

  public updateOrderStatus(orderProduct: any): Observable<any> {
    return this.http.put<any>(`${this.orderBaseUrl}/orders/update`,orderProduct);
  }
}

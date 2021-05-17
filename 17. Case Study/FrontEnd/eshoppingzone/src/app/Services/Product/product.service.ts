import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from 'src/app/product';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiServerUrl = environment.apiBaseUrl;
  token = "Bearer "+localStorage.getItem('token');
  

  constructor(private http: HttpClient) {

  }

  public getProductsByid(id: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/find/${id}`);
  }

  public getProductsByCategory(category: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/category/${category}`);
  }

  public getProductsBySeller(seller: string): Observable<Product[]> {
    const headers = new HttpHeaders().set("Authorization", this.token);
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/seller/${seller}`, {headers});
  }
  
  public addProduct(product: Product): Observable<Product> {
    const headers = new HttpHeaders().set("Authorization", this.token);
    return this.http.post<Product>(`${this.apiServerUrl}/product/add`, product, {headers});
  }

  public updateProduct(product: Product): Observable<Product> {
    const headers = new HttpHeaders().set("Authorization", this.token);
    return this.http.put<Product>(`${this.apiServerUrl}/product/update`, product, {headers});
  }

  public deleteProduct(productId: number): Observable<void> {
    const headers = new HttpHeaders().set("Authorization", this.token);
    return this.http.delete<void>(`${this.apiServerUrl}/product/delete/${productId}`, {headers});
  }
  
}

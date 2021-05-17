import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  addressBaseUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {

  }
  // Get All Products in cart
  public getAddressByUsername(username: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.addressBaseUrl}/address/get/${username}`);
  }

  public removeAddress(id: string): Observable<any> {
    return this.http.delete<any>(`${this.addressBaseUrl}/address/delete/${id}`);
  }

  public addAddress(address: any): Observable<any> {
    return this.http.post<any>(`${this.addressBaseUrl}/address/add`, address);
  }


}

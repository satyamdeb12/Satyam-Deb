import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {
  }

  login(data: any): Observable<any>{
    return this.http.post(`${this.apiServerUrl}/user/authenticate`, data)
  }
  signup(data: any): Observable<any>{
    return this.http.post(`${this.apiServerUrl}/user/register`, data)
  }

  getUser(username: string): Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/user/get/${username}`);
  }

  public updateUser(data: any): Observable<any> {
    return this.http.put<any>(`${this.apiServerUrl}/user/update`, data);
  }

  public loginMail(email: string){
    return this.http.get(`http://localhost:5050/email/login/${email}`);
  }
}

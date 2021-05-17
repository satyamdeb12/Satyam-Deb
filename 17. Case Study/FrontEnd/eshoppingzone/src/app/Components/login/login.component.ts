import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CartProduct } from 'src/app/CartProduct';
import { CartService } from 'src/app/Services/Cart/cart.service';
import { LoggedInDataService } from 'src/app/Services/LoggedInData/logged-in-data.service';
import { LoginService } from 'src/app/Services/LoginService/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isSeller: number = 0;
  email: string = '';
  public loggedIn: boolean = Boolean(localStorage.getItem('status'));
  cartProduct : any;

  constructor(private loginService: LoginService, private loggedInDataService: LoggedInDataService, private router: Router, private cartService: CartService) {
   
    
  }

  ngOnInit(): void {
    
  }


  login(loginForm: NgForm): void {
    this.loginService.login(loginForm.value).subscribe(
      (response: any)=>{
        if(parseInt(response.status)){
          localStorage.setItem('token', response.message);
          localStorage.setItem('status', response.status)
          localStorage.setItem('userName', response.userName);
          this.getEmail();
          localStorage.setItem('isSeller', response.isSeller)
          this.router.navigate(['/home']);
          

        }else{
          alert(response.message);
        }
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
    
  }
  
  getEmail(){
    this.loginService.getUser(String(localStorage.getItem('userName'))).subscribe(
      (response)=>{
        let emails = response.email;
        this.loginService.loginMail(emails).subscribe( );
      }
    );
  }
 


  signup(signupForm: NgForm): void{
    this.loginService.signup(signupForm.value).subscribe(
      (response: any) =>{
        console.log(response);
        alert("Signup Successful");
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )

    console.log(signupForm.value);
    
  }

}

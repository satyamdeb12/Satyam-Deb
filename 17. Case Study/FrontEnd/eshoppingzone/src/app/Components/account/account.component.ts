import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddressService } from 'src/app/Services/AddressService/address.service';
import { LoginService } from 'src/app/Services/LoginService/login.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  isAddress = false;
  addresses : any[] = [];
  addressExist: boolean = false;
  msg: string = "";
  user: any;
  constructor(private addressService: AddressService,  private matSnackbar: MatSnackBar, private loginService: LoginService) {
    this.getAddressByUsername(String(localStorage.getItem('userName')));
    this.getUserByUsername(String(localStorage.getItem('userName')));
  }

  ngOnInit(): void {
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

  onAddressRemove(id: string){
    this.addressService.removeAddress(id).subscribe(
      (response: any)=>{
        this.msg = response.msg;
        this.matSnackbar.open(this.msg, 'Dismiss', {duration: 2000})
        setTimeout( function(){ 
          location.reload(); 
        }, 2000);
      },
      (error: HttpErrorResponse)=>{
        alert('Failed to connect to backend. '+ error.message);
      }
    )
  }

  getUserByUsername(username: string){
    this.loginService.getUser(username).subscribe(
      (response: any)=>{
        this.user = response;
      },
      (error: HttpErrorResponse)=>{
        alert('Failed to connect to backend. '+ error.message);
      }
    )
  }
  
  public onProfileUpdate(data: any): void{
    this.loginService.updateUser(data).subscribe(
      (response: any) => {
        console.log(response);
        location.reload();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
  onPasswordUpdate(data: NgForm) {
    this.loginService.updateUser(data).subscribe(
      (response: any) => {
        console.log(response);
        location.reload();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
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

}

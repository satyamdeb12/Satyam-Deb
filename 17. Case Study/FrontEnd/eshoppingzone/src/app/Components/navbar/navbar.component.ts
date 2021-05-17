import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoggedInDataService } from 'src/app/Services/LoggedInData/logged-in-data.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  
  
  frontBaseUrl = environment.frontendBaseUrl;
  currentUrl : string= "" + window.location.href;
  loggedIn : boolean = Boolean(localStorage.getItem('status'));
  isSeller : boolean = Boolean(parseInt(String(localStorage.getItem('isSeller'))));

  
  constructor(private loggedInDataService: LoggedInDataService, private router: Router) { }
  ngOnInit(): void {  }

  onLogout(){
    localStorage.clear()
    if(location.href === "http://localhost:4200/home"){
      location.reload();
    }else{
      this.router.navigate(['/home']);
    }
       
  }
  onLogin(){
    this.router.navigate(['/login']);
  }
  onLogoClick(){
    this.router.navigate(['/home']);
  }
  onCartClick(){
    const userName = localStorage.getItem('userName')
    this.router.navigate(['/cart', userName]);
  }
  onOrdersClick(){
    const userName = localStorage.getItem('userName')
    this.router.navigate(['/orders', userName]);
  }
  onAccountClick(){
    const userName = localStorage.getItem('userName')
    this.router.navigate(['/account', userName]);
  }
  onSellerClick(){
    this.router.navigate(['/seller']);
  }
  onCategoryClick(category: string){
    this.router.navigate(['/products', category]);
  }
  
}

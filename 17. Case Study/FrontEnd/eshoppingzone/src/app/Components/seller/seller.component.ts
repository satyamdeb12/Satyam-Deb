import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from 'src/app/product';
import { ProductService } from 'src/app/Services/Product/product.service';


@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {

  isSeller : boolean = Boolean(parseInt(String(localStorage.getItem('isSeller'))));
  public seller: string;
  public product: Product[];
  public editProduct: any;
  public deleteProduct: any;
  loggedIn : boolean = Boolean(localStorage.getItem('status'));


  constructor(private productService: ProductService, private router: Router) { 
    this.seller = String(localStorage.getItem('userName'));
    this.product = [];
    this.editProduct = null;
    this.getProductsBySeller(this.seller);
  }

  ngOnInit(): void {
  }


  public getProductsBySeller(seller: string): void {
    this.productService.getProductsBySeller(seller).subscribe(
      (response: Product[]) => {
        
        this.product = response;
      },
      (error: HttpErrorResponse) => {
        console.log('Failed to connect to the backend. ' + error.message);
      }
    );
  }

  public onAddProduct(addForm: NgForm): void{
    // Close the form on submit
    document.getElementById('add-product-form')?.click();

    this.productService.addProduct(addForm.value).subscribe(
      (response: Product) => {
        this.getProductsBySeller(this.seller);
        addForm.reset();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    );
  }
  public onUpdateProduct(product: Product): void{
    this.productService.updateProduct(product).subscribe(
      (response: Product) => {
        this.getProductsBySeller(this.seller);
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
  public onDeleteProduct(productId: number): void{
    this.productService.deleteProduct(productId).subscribe(
      (response: void) => {
        this.getProductsBySeller(this.seller);
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
  
  public searchProduct(key: string): void{
    const results: Product[] = [];
    for (const product of this.product){
      if(product.productName.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || product.productCategory.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        results.push(product);
      }
    }

    this.product = results;

    if(results.length === 0 || !key){
      this.getProductsBySeller(this.seller);
    }
  }

  public onOpenModal(product: any, mode: String): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add'){
      button.setAttribute('data-target', '#addProductModal');
    }
    if (mode === 'edit'){
      this.editProduct = product;
      button.setAttribute('data-target', '#updateProductModal');
    }
    if (mode === 'delete'){
      this.deleteProduct = product;
      button.setAttribute('data-target', '#deleteProductModal');
    }
    container?.appendChild(button);
    button.click();
  }
  onLogoClick(){
    this.router.navigate(["/home"]);
  }
  onSellerOrdersClick(){
    this.router.navigate(["/seller-orders", this.seller]);
  }
  onSellerClick(){
    this.router.navigate(['/seller']);
  }
  onAccountClick(){
    const userName = localStorage.getItem('userName')
    this.router.navigate(['/account', userName]);
  }
  onOrdersClick(){
    const userName = localStorage.getItem('userName')
    this.router.navigate(['/orders', userName]);
  }
  onLogout(){
    localStorage.clear()
    if(location.href === "http://localhost:4200/home"){
      location.reload();
    }else{
      this.router.navigate(['/home']);
    }
       
  }

}

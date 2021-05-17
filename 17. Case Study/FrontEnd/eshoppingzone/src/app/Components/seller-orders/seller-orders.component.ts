import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/Services/OrderService/order.service';

@Component({
  selector: 'app-seller-orders',
  templateUrl: './seller-orders.component.html',
  styleUrls: ['./seller-orders.component.css']
})
export class SellerOrdersComponent implements OnInit {

  sellerOrders: any[] = []; 
  constructor(private orderService: OrderService, private router: Router) {
    this.getOrdersBySeller(String(localStorage.getItem('userName')));
  }

  ngOnInit(): void {
  }
  getOrdersBySeller(seller: string){
    this.orderService.getOrderProductsBySeller(seller).subscribe(
      (response: any[])=>{
        this.sellerOrders = response;        
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }

  updateStatus(orderProduct: any, status: string){
    orderProduct.orderStatus = status;
    this.orderService.updateOrderStatus(orderProduct).subscribe(
      (response: any)=>{
        location.reload();
      },
      (error: HttpErrorResponse)=>{
        console.log(error.message);  
      }
    );
  }
  backClick(){
    this.router.navigate(['/seller']);
  }
}

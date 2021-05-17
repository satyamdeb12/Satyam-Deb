import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/Services/OrderService/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orderProducts: any;
  constructor(private orderService: OrderService) {
    this.getOrderProducts(String(localStorage.getItem('userName')));
  }

  ngOnInit(): void {
  }
  getOrderProducts(userName: string){
    this.orderService.getOrderProducts(userName).subscribe(
      (response: any[])=>{
        this.orderProducts = response;
        console.log(this.orderProducts);
        
      },
      (error: HttpErrorResponse)=>{
        alert('Failed to connect to backend. '+ error.message);
      }
    )
  }

}

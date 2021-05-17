import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './Components/account/account.component';
import { CartContentComponent } from './Components/cart-content/cart-content.component';
import { CheckoutComponent } from './Components/checkout/checkout.component';
import { HomeContentComponent } from './Components/home-content/home-content.component';
import { LoginComponent } from './Components/login/login.component';
import { OrdersComponent } from './Components/orders/orders.component';
import { ProductContentComponent } from './Components/product-content/product-content.component';
import { ProductDetailComponent } from './Components/product-detail/product-detail.component';
import { SellerOrdersComponent } from './Components/seller-orders/seller-orders.component';
import { SellerComponent } from './Components/seller/seller.component';

const routes: Routes = [

  {path: '', component: HomeContentComponent},
  {path:"home", component: HomeContentComponent},
  {path:"products/:category", component: ProductContentComponent},
  {path: "product/:id", component: ProductDetailComponent},
  {path:"seller", component: SellerComponent},
  {path: "login", component: LoginComponent},
  {path:"cart/:userName", component: CartContentComponent},
  {path:"checkout/:userName", component: CheckoutComponent},
  {path:"orders/:userName", component: OrdersComponent},
  {path:"account/:userName", component: AccountComponent},
  {path:"seller-orders/:seller", component: SellerOrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

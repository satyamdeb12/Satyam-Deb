import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatInputModule} from '@angular/material/input';
import { HomeContentComponent } from './Components/home-content/home-content.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { ProductContentComponent } from './Components/product-content/product-content.component';
import { ProductService } from './Services/Product/product.service';
import { HttpClientModule } from '@angular/common/http';
import { LoggedInDataService } from './Services/LoggedInData/logged-in-data.service';
import { SellerComponent } from './Components/seller/seller.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './Components/login/login.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatTabsModule} from '@angular/material/tabs';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { CartService } from './Services/Cart/cart.service';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { CartContentComponent } from './Components/cart-content/cart-content.component';
import {MatBadgeModule} from '@angular/material/badge';
import { CheckoutComponent } from './Components/checkout/checkout.component';
import { OrdersComponent } from './Components/orders/orders.component';
import { AccountComponent } from './Components/account/account.component';
import { FooterComponent } from './Components/footer/footer.component';
import { WhyUsComponent } from './Components/why-us/why-us.component';
import { AddressService } from './Services/AddressService/address.service';
import {MatRadioModule} from '@angular/material/radio';
import { ProductDescriptionComponent } from './Components/product-description/product-description.component';
import { OrderService } from './Services/OrderService/order.service';
import { ProductDetailComponent } from './Components/product-detail/product-detail.component';
import { SellerOrdersComponent } from './Components/seller-orders/seller-orders.component';





@NgModule({
  declarations: [
    AppComponent,
    HomeContentComponent,
    ProductContentComponent,
    SellerComponent,
    LoginComponent,
    NavbarComponent,
    CartContentComponent,
    CheckoutComponent,
    OrdersComponent,
    AccountComponent,
    FooterComponent,
    WhyUsComponent,
    ProductDescriptionComponent,
    ProductDetailComponent,
    SellerOrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatExpansionModule,
    MatInputModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    HttpClientModule,
    MatFormFieldModule,
    FormsModule,
    FlexLayoutModule,
    MatTabsModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatSnackBarModule,
    MatBadgeModule,
    MatRadioModule
  ],
  providers: [ProductService, LoggedInDataService, CartService, AddressService, OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }

package com.eshoppingzone.cart.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details about the Cart Product")
public class Cart {

    @ApiModelProperty(notes = "The unique id of the Cart (auto generated).")
    @Id
    private String cartId;
    @ApiModelProperty(notes = "The username of the user to which the cart belongs.")
    private String username;
    @ApiModelProperty(notes = "Unique Id of the product (auto generated from the PRODUCT SERVICE)")
    private String id;
    @ApiModelProperty(notes = "Name of the product")
    private String productName;
    @ApiModelProperty(notes = "Category of the product")
    private String productCategory;
    @ApiModelProperty(notes = "Price of the product")
    private double price;
    @ApiModelProperty(notes = "Display Image of the product")
    private String productImage;
    @ApiModelProperty(notes = "Seller of the product")
    private String seller;
    @ApiModelProperty(notes = "Quantity of the product")
    private int quantity;
}

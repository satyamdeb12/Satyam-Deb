package com.eshoppingzone.orders.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the Order.")
public class Orders {
    @ApiModelProperty(notes = "The unique id of the order (auto generated).")
    @Id
    private String orderId;
    @ApiModelProperty(notes = "The order status.")
    private String orderStatus;
    @ApiModelProperty(notes = "Username of the user to whom the order belongs.")
    private String username;
    @ApiModelProperty(notes = "Date of purchase.")
    private String orderedOn;
    @ApiModelProperty(notes = "The unique id of the product (auto generated from the PRODUCT SERVICE.")
    private String id;
    @ApiModelProperty(notes = "Name of the product.")
    private String productName;
    @ApiModelProperty(notes = "Short description of the product.")
    private String shortDescription;
    @ApiModelProperty(notes = "Long description of the product.")
    private String longDescription;
    @ApiModelProperty(notes = "Category of the product.")
    private String productCategory;
    @ApiModelProperty(notes = "Price of the product.")
    private double price;
    @ApiModelProperty(notes = "Product Display image.")
    private String productImage;
    @ApiModelProperty(notes = "Username of the seller of the product.")
    private String seller;
    @ApiModelProperty(notes = "Quantity of the product.")
    private int quantity;
}

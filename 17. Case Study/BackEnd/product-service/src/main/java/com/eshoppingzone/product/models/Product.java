package com.eshoppingzone.product.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details about the product")
public class Product {
    @ApiModelProperty(notes = "The unique id of the product (auto generated).")
    @Id
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
    @ApiModelProperty(notes = "Product detail slider image 1.")
    private String productImage1;
    @ApiModelProperty(notes = "Product detail slider image 2.")
    private String productImage2;
    @ApiModelProperty(notes = "Product detail slider image 3.")
    private String productImage3;
    @ApiModelProperty(notes = "Username of the seller of the product.")
    private String seller;
    @ApiModelProperty(notes = "Quantity of the product.")
    private int quantity;
}

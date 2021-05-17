package com.eshoppingzone.cart.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Model for the response of a delete request.")
public class DeleteResponse {
    @ApiModelProperty(notes = "Name of the product that is deleted..")
    private String productName;
}

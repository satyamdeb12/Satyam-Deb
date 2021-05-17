package com.eshoppingzone.address.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the Address.")
public class Address {
    @ApiModelProperty(notes = "The unique id of the address (auto generated).")
    @Id
    private String id;
    @ApiModelProperty(notes = "Username of the user to whom the address belongs.")
    private String username;
    @ApiModelProperty(notes = "Full name of the user.")
    private String fullName;
    @ApiModelProperty(notes = "Building/ street/ society of the user.")
    private String building;
    @ApiModelProperty(notes = "City of the user.")
    private String city;
    @ApiModelProperty(notes = "State of the user.")
    private String state;
    @ApiModelProperty(notes = "PIN code of the user.")
    private String pin;
    @ApiModelProperty(notes = "Phone number of the user.")
    private String phone;
}

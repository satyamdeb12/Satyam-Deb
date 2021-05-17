package com.eshoppingzone.address.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Response of delete Address request.")
public class DeleteResponse {
    @ApiModelProperty(notes = "Successful deletion message.")
    private String msg;
}

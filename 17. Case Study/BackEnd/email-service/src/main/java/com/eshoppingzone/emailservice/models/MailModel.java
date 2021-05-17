package com.eshoppingzone.emailservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the email.")
public class MailModel {
    @ApiModelProperty(notes = "The recipient email id.")
    private String toMail;
    @ApiModelProperty(notes = "Subject of the email.")
    private String subject;
    @ApiModelProperty(notes = "Body of the email.")
    private String body;
}

package com.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description="mto_channel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MtoChannel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String key;

    @ApiModelProperty(value="")
    private String name;

    @ApiModelProperty(value="")
    private Integer status;

    @ApiModelProperty(value="")
    private String thumbnail;

    @ApiModelProperty(value="")
    private Integer weight;
}
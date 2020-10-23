package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goods {
    @NotEmpty
    private String goodsName;
    @NotEmpty
    private String jpgUrl;
    @NotEmpty
    private Integer price;
    @NotEmpty
    private String unit;
}

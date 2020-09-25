package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "goods")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsEntity {
    @Id
    @GeneratedValue
    @Column(name="goods_id")
    private Integer id;
    private String goodsName;
    private String jpgUrl;
    private int price;
    private String unit;
}

package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    Integer id;

    int count;

    @ManyToOne
    @JoinColumn(name = "goods_id" )
    GoodsEntity goodsEntity;

}

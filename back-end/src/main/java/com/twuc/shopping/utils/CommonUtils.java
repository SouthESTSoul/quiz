package com.twuc.shopping.utils;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {

    public static Goods convertGoodsEntityToDto(GoodsEntity goodsEntity){
        Goods goods =Goods.builder()
                .goodsName(goodsEntity.getGoodsName())
                .jpgUrl(goodsEntity.getJpgUrl())
                .price(goodsEntity.getPrice())
                .unit(goodsEntity.getUnit())
                .build();
                return goods;
    }

    public static List<Goods> convertGoodsEntityListToDto(List<GoodsEntity> goodsEntities){
        List<Goods> goodsList = goodsEntities.stream()
                .map(CommonUtils::convertGoodsEntityToDto)
                .collect(Collectors.toList());

        return goodsList;
    }

    public static GoodsEntity convertGoodsDtoToEntity(Goods goods){
        GoodsEntity goodsEntity = GoodsEntity.builder()
                .goodsName(goods.getGoodsName())
                .jpgUrl(goods.getJpgUrl())
                .price(goods.getPrice())
                .unit(goods.getUnit())
                .build();
        return goodsEntity;
    }

    public static OrderEntity convertOrderDtoToEntity (Order order){
        OrderEntity orderEntity =OrderEntity.builder()
                .goodsEntity(convertGoodsDtoToEntity(order.getGoods()))
                .count(order.getCount())
                .build();
        return orderEntity;
    }

    public static Order convertOrderEntityToDto(OrderEntity orderEntity){
        Order order=Order.builder()
                .goods(convertGoodsEntityToDto(orderEntity.getGoodsEntity()))
                .count(orderEntity.getCount())
                .build();
        return order;
    }

    public static List<Order> convertOrderEntityListToDto(List<OrderEntity> orderEntities){
        List<Order> orders = orderEntities.stream()
                .map(CommonUtils::convertOrderEntityToDto)
                .collect(Collectors.toList());

        return orders;
    }


}

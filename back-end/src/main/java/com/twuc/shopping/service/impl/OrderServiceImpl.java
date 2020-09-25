package com.twuc.shopping.service.impl;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public List<Order> getOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<Order> orders = CommonUtils.convertOrderEntityListToDto(orderEntities);
        return orders;
    }
}

package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity getOrders() {
        List<Order> orderList = orderService.getOrders();
//        if (orderList.size()==0){
//            return ResponseEntity.status(205).build();
//        }

        return ResponseEntity.ok().body(orderList);
    }

}

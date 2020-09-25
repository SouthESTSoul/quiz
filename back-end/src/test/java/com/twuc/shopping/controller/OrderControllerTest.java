package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.utils.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderControllerTest {
    @Autowired
    MockMvc mockMVC;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void initDataBase() {
        Goods goods1 = Goods.builder()
                .goodsName("可乐1")
                .unit("瓶")
                .price(3)
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .build();
        GoodsEntity goodsEntity1 = CommonUtils.convertGoodsDtoToEntity(goods1);
        Goods goods2 = Goods.builder()
                .goodsName("可乐2")
                .unit("瓶")
                .price(3)
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .build();
        GoodsEntity goodsEntity2 = CommonUtils.convertGoodsDtoToEntity(goods2);

        goodsRepository.save(goodsEntity1);
        goodsRepository.save(goodsEntity2);
        OrderEntity orderEntity =OrderEntity.builder()
                .count(2)
                .goodsEntity(goodsEntity1)
                .build();
        orderRepository.save(orderEntity);

        OrderEntity orderEntity2 =OrderEntity.builder()
                .count(4)
                .goodsEntity(goodsEntity2)
                .build();
        orderRepository.save(orderEntity2);


    }

    @Test
    void should_renturn_status_205_when_no_order_exist() throws Exception {
        orderRepository.deleteAll();
        mockMVC.perform(get("/orders"))
                .andExpect(status().is(205));
    }

    @Test
    void should_renturn_all_orders() throws Exception {

        mockMVC.perform(get("/orders"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$",hasSize(2)));
    }

    }




package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.utils.CommonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
public class GoodsControllerTest {
    @Autowired
    MockMvc mockMVC;
    @Autowired
    GoodsRepository goodsRepository;

    @BeforeEach
    void initDataBase() {
        goodsRepository.deleteAll();
        Goods goods1 = Goods.builder()
                .goodsName("可乐1")
                .unit("瓶")
                .price(3)
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .build();
        Goods goods2 = Goods.builder()
                .goodsName("可乐2")
                .unit("瓶")
                .price(3)
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .build();
        Goods goods3 = Goods.builder()
                .goodsName("可乐3")
                .unit("瓶")
                .price(3)
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .build();

        GoodsEntity goodsEntity1 = CommonUtils.convertGoodsDtoToEntity(goods1);
        GoodsEntity goodsEntity2 = CommonUtils.convertGoodsDtoToEntity(goods2);
        GoodsEntity goodsEntity3 = CommonUtils.convertGoodsDtoToEntity(goods3);
        goodsRepository.save(goodsEntity1);
        goodsRepository.save(goodsEntity2);
        goodsRepository.save(goodsEntity3);
    }

    @Test
    void should_renturn_all_goodsed() throws Exception {
        List<GoodsEntity> all = goodsRepository.findAll();
        mockMVC.perform(get("/goodses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void should_add_one_goods() throws Exception {
        goodsRepository.deleteAll();
        ObjectMapper objectMapper = new ObjectMapper();
        Goods goods = Goods.builder()
                .goodsName("可乐1234")
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .price(123)
                .unit("瓶")
                .build();
        String goodsString = objectMapper.writeValueAsString(goods);

        mockMVC.perform(post("/goods")
                .content(goodsString)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201));
        long goodsCount = goodsRepository.count();
        Assertions.assertEquals(1l,goodsCount);
    }

    @Test
    void should_not_add_one_goods_when_goodsName_has_been_exist() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Goods goods = Goods.builder()
                .goodsName("可乐1")
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .price(123)
                .unit("瓶")
                .build();

        String goodsString = objectMapper.writeValueAsString(goods);

        mockMVC.perform(post("/goods")
                .content(goodsString)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

}

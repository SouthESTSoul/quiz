package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.utils.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GoodsControllerTest {
    @Autowired
    MockMvc mockMVC;
    @Autowired
    GoodsRepository goodsRepository;

    @BeforeEach
    void initDataBase(){
        Goods goods1=Goods.builder()
                .goodsName("可乐1")
                .unit("瓶")
                .price(3)
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .build();
        Goods goods2=Goods.builder()
                .goodsName("可乐2")
                .unit("瓶")
                .price(3)
                .jpgUrl("https://i.loli.net/2020/09/25/FQBaZcUGNIOusV4.jpg")
                .build();
        Goods goods3=Goods.builder()
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
                .andExpect(jsonPath("$",hasSize(3)));
    }
    @Test
    void should_add_one_goods(){
        GoodsEntity byGoodsName = goodsRepository.findOneByGoodsName("123");
        System.out.println(123);
    }
}

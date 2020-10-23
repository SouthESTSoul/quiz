package com.twuc.shopping.service;

import com.twuc.shopping.dto.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodses();
    void addGoods( Goods goods);
}

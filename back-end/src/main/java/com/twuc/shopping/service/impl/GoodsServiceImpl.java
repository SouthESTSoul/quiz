package com.twuc.shopping.service.impl;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.service.GoodsService;
import com.twuc.shopping.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;

    @Override
    public List<Goods> getGoodses() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();
        List<Goods> goodsList = CommonUtils.convertGoodsEntityListToDto(goodsEntities);
        return goodsList;
    }

    @Override
    public void addGoods(Goods goods) {
        GoodsEntity goodsEntity = CommonUtils.convertGoodsDtoToEntity(goods);
        goodsRepository.save(goodsEntity);
    }
}

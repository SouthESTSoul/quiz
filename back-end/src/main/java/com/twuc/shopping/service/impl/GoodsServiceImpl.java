package com.twuc.shopping.service.impl;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.exception.RepeatGoodsNameException;
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
        GoodsEntity goodsByName = goodsRepository.findOneByGoodsName(goods.getGoodsName());
        if(goodsByName!=null){
            throw new RepeatGoodsNameException("商品名称已存在，请输入新的商品名称");
        }
        GoodsEntity goodsEntity = CommonUtils.convertGoodsDtoToEntity(goods);
        goodsRepository.save(goodsEntity);
    }

}

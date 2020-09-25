package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping("/goodses")
    public ResponseEntity getGoodses() {
        List<Goods> goodsList = goodsService.getGoodses();
        return ResponseEntity.ok().body(goodsList);
    }
}

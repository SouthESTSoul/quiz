package com.twuc.shopping.controller;

import com.twuc.shopping.exception.RepeatGoodsNameException;
import com.twuc.shopping.respons.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(RepeatGoodsNameException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage handleException(RepeatGoodsNameException exception) {

        return new ErrorMessage(exception.getMessage());
    }
}

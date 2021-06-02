package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result =paymentService.create(payment);
        log.info("the result of insert is :" + result);

        if(result>0){
            return new CommonResult(200,"insert database success,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"insert failure",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("get payment " );
        if(payment!=null){
            return new CommonResult(200,"get payment success,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"get failure id:"+id,null);
        }
    }

}


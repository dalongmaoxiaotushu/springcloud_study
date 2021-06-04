package org.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "thread pool:"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t";
    }

    public String paymentInfo_TimeOut(Integer id){
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "thread pool:"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t"+"delay 3 seconds";
    }

}

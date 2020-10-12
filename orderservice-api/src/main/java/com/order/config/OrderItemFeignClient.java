package com.order.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.entity.Item;



@FeignClient(value = "orderItem" , url="http://localhost:8080")
public interface OrderItemFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/orderitem/{id}", produces = "application/json")
    Item getOrderItem(@PathVariable("id") Integer id);

    @RequestMapping(method = RequestMethod.POST, value = "/orderitem", produces = "application/json")
    Integer saveOrderItems(@RequestBody Item orderItem);

}

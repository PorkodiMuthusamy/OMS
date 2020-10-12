package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Item;
import com.order.entity.Order;
import com.order.exception.OrderNotFoundException;
import com.order.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("/order")
	public List<Order> getAllOrderitem() {
		return orderService.getAllOrders();
	}

	@GetMapping("/order/{id}")
	private Optional<Order> getOrder(@PathVariable("id") int id) {
		if (!orderService.getOrderById(id).isPresent()) {
			throw new OrderNotFoundException("Order not found for orderId : " + id);
		}
		return orderService.getOrderById(id);
	}

	@DeleteMapping("/order/{id}")
	private void deleteOrder(@PathVariable("id") int id) {
		orderService.delete(id);	
	}

	@PostMapping("/order")
	private int saveOrder(@RequestBody Order order) {
		orderService.saveOrUpdate(order);
		List<Item> items = order.getOrderItems();
		orderService.saveOrderItem(items);
		return order.getOrderId();
	}
	
	
	@GetMapping("/orderitembyid/{id}")
	public Item getOrderItemById(@PathVariable("id") int id) {
		return orderService.getOrderItem(id);
	}

}

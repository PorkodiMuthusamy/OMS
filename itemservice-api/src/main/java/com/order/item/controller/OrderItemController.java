package com.order.item.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.item.entity.Item;
import com.order.item.exception.ItemNotFoundException;
import com.order.item.service.OrderItemService;

@RestController
public class OrderItemController {
	@Autowired
	OrderItemService orderItemService;

	@GetMapping("/orderitem")
	private List<Item> getAllOrderitem() {
		return orderItemService.getAllOrderItems();
	}

	@GetMapping("/orderitem/{id}")
	private Optional<Item> getOrderItem(@PathVariable("id") int id) {
		if (!orderItemService.getOrderItemById(id).isPresent()) {
			throw new ItemNotFoundException("Order not found for " + id);
		}
		return orderItemService.getOrderItemById(id);
	}

	@DeleteMapping("/orderitem/{id}")
	private void deleteOrderItem(@PathVariable("id") int id) {
		orderItemService.delete(id);
	}

	@PostMapping("/orderitem")
	private int saveOrderItem(@RequestBody Item orderItem) {
		orderItemService.saveOrUpdate(orderItem);
		return orderItem.getItemCode();
	}

}

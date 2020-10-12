package com.order.item.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.order.item.entity.Item;
import com.order.item.repository.OrderItemRepository;

@Service
@Component
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<Item> getAllOrderItems() {
		List<Item> orderItems = new ArrayList<Item>();
		orderItemRepository.findAll().forEach(item -> orderItems.add(item));
		return orderItems;
	}

	public Optional<Item> getOrderItemById(int id) {
		return orderItemRepository.findById(id);
	}

	public void saveOrUpdate(Item orderItem) {
		orderItemRepository.save(orderItem);
	}

	public void delete(int id) {
		orderItemRepository.deleteById(id);
	}

}

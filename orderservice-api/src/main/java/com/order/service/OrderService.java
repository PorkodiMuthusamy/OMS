package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.order.config.OrderItemFeignClient;
import com.order.entity.Item;
import com.order.entity.Order;
import com.order.repository.OrderRepository;


@Service
@Component
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemFeignClient orderItemFeignClient;

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		orderRepository.findAll().forEach(item -> orders.add(item));
		return orders;
	}

	public Optional<Order> getOrderById(Integer id) {
		return orderRepository.findById(id);
	}

	public void saveOrUpdate(Order order) {
		orderRepository.save(order);
	}

	public void delete(Integer id) {
		orderRepository.deleteById(id);
	}
	
	public Item getOrderItem(Integer id) {
		return orderItemFeignClient.getOrderItem(id);
	}
	
	public void saveOrderItem(List<Item> orderItems) {
		orderItems.forEach(item -> orderItemFeignClient.saveOrderItems(item));
	}
	
	
}

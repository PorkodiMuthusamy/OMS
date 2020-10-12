package com.order.test;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.order.config.OrderItemFeignClient;
import com.order.controller.OrderController;
import com.order.entity.Item;
import com.order.entity.Order;
import com.order.repository.OrderRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private OrderController orderController;

	@MockBean
	private OrderRepository orderRepo;

	@MockBean
	OrderItemFeignClient orderItemFeignClient;

	@Test
	public void getAllOrder() throws Exception {
		Order order = new Order();
		order.setOrderDate("01-OCT-2020");
		order.setCustomerName("TEST CUSTOMER NAME");
		order.setOrderId(1003);

		List<Order> allOrders = singletonList(order);
		when(orderController.getAllOrderitem()).thenReturn(allOrders);

	}

	@Test
	public void getOrder() throws Exception {
		Item item = new Item();
		item.setItemCode(1001);
		item.setItemName("ROUND BOX");
		item.setQuantity(20);

		
		when(orderController.getOrderItemById(any(Integer.class))).thenReturn(item);

	}

}

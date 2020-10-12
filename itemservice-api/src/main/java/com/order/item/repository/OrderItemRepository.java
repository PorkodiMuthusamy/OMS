package com.order.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.order.item.entity.Item;

@Repository
@Component
public interface OrderItemRepository extends JpaRepository <Item, Integer>{

}

package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{

}

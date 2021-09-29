package com.jpmc.day13txnapp.repo;

import com.jpmc.day13txnapp.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}

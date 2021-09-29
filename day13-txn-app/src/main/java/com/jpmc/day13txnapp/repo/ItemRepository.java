package com.jpmc.day13txnapp.repo;

import com.jpmc.day13txnapp.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    Optional<Item> findByName(String name);
}

package com.jpmc.day13txnapp.service;

import com.jpmc.day13txnapp.entity.Item;
import com.jpmc.day13txnapp.entity.Order;
import com.jpmc.day13txnapp.repo.ItemRepository;
import com.jpmc.day13txnapp.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import java.util.Optional;

@Service
//@Transactional
public class ShoppingService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void placeOrder(String itemName, int quantity, String address) {
        //Handle best case scenario; ie., Not going to check if item is available and quantity is available
        Optional<Item> optItem = itemRepository.findByName(itemName);
        if(optItem.isPresent()) {
            Item item = optItem.get();
            item.setQuantity(item.getQuantity() - quantity);
            itemRepository.save(item);

            Order order = new Order();
            order.setOrderedItem(itemName);
            order.setOrderedQuantity(quantity);
            order.setAddress(address);
            orderRepository.save(order);
        }
    }
}

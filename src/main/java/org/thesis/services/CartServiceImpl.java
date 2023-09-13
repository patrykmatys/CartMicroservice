package org.thesis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thesis.models.Cart;
import org.thesis.repositories.CartRepository;

import java.util.HashMap;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addToCart(String user, UUID itemId, Integer quantity) {
        Cart cart = getCartByUser(user);

        HashMap<UUID, Integer> items = cart.getItems();
        items.put(itemId, items.getOrDefault(itemId, 0) + quantity);

        return cartRepository.save(cart);
    }

    @Override
    public Cart removeFromCart(String user, UUID itemId, Integer quantity) {
        Cart cart = getCartByUser(user);

        HashMap<UUID, Integer> items = cart.getItems();
        Integer currentCount = items.getOrDefault(itemId, 0);
        if (currentCount < quantity) {
            items.put(itemId, 0);
        } else {
            items.put(itemId, currentCount - quantity);
        }

        return cartRepository.save(cart);
    }

    @Override
    public Cart updateItemInCart(String user, UUID itemId, Integer quantity) {
        Cart cart = getCartByUser(user);

        HashMap<UUID, Integer> items = cart.getItems();
        if (quantity <= 0) {
            items.remove(itemId);
        } else {
            items.replace(itemId, quantity);
        }

        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUser(String user) {
        Cart cart = cartRepository.findCartByUser(user);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setItems(new HashMap<>());
        }

        return cart;
    }

    @Override
    public Cart emptyCart(String user) {
        Cart cart = getCartByUser(user);
        cart.setItems(new HashMap<>());

        return cartRepository.save(cart);
    }
}

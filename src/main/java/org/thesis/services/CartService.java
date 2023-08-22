package org.thesis.services;

import org.thesis.models.Cart;

import java.util.UUID;

public interface CartService {
    Cart addToCart(String user, UUID itemId, Integer quantity);
    Cart getCartByUser(String user);
    Cart removeFromCart(String user, UUID itemId, Integer quantity);
    Cart emptyCart(String user);
}

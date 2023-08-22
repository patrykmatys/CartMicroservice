package org.thesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thesis.models.Cart;
import org.thesis.models.CartRequest;
import org.thesis.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok(cartService.addToCart(
                cartRequest.getUser(),
                cartRequest.getItemId(),
                cartRequest.getQuantity()
                )
        );
    }

    @PostMapping("/remove")
    public ResponseEntity<Cart> removeFromCart(@RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok(cartService.removeFromCart(
                        cartRequest.getUser(),
                        cartRequest.getItemId(),
                        cartRequest.getQuantity()
                )
        );
    }

    @GetMapping("/{user}")
    public ResponseEntity<Cart> addToCart(@PathVariable String user) {
        return ResponseEntity.ok(cartService.getCartByUser(user));
    }
}
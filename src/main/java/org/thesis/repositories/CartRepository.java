package org.thesis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.thesis.models.Cart;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findCartByUser(String user);
}
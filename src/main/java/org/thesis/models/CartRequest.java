package org.thesis.models;

import lombok.Data;

import java.util.UUID;

@Data
public class CartRequest {

    private String user;
    private UUID itemId;
    private Integer quantity;
}

package org.thesis.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.UUID;

@Data
public class Cart {
    @Id
    private String user;
    private HashMap<UUID, Integer> items;
}

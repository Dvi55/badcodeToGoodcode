package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product implements Informational {
    private long id;
    private boolean available;
    private String title;
    private double price;
    private String channel;

    public abstract String getBasicInfo();
}

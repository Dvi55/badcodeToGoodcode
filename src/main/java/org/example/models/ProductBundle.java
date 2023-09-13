package org.example.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ProductBundle extends Product implements Bundled {
    private int amount;

    public ProductBundle(long id, boolean available, String title, double price, String chanel) {
        super(id, available, title, price, chanel);
    }


    @Override
    public int getAmountInBundle() {
        return amount;
    }

    @Override
    public String getBasicInfo() {
        return "ProductBundle{" +
                "channel='" + getChannel() + '\'' +
                ", id=" + getId() +
                ", available=" + isAvailable() +
                ", title='" + getTitle() + '\'' +
                ", price=" + getPrice() +
                ", amountInBundle=" + amount +
                '}';
    }
}

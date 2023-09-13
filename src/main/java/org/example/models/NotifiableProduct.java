package org.example.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class NotifiableProduct extends Product implements Notifiable {

    public NotifiableProduct(long id, boolean available, String title, double price, String channel) {
        super(id, available, title, price, channel);
    }

    @Override
    public String generateAddressForNotification() {
        return "somerandommail@gmail.com";
    }

    @Override
    public String getBasicInfo() {
        return "NotifiableProduct{" +
                "channel='" + getChannel() + '\'' +
                ", id=" + getId() +
                ", available=" + isAvailable() +
                ", title='" + getTitle() + '\'' +
                ", price=" + getPrice() +
                '}';
    }

}

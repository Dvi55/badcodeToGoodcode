package ORG.EXAMPLE.moDEL;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotifiableProduct extends Product{
    protected String channel;

    @Override
    public String generateAddressForNotification() {
        return "somerandommail@gmail.com";
    }

    @Override
    public String getBasicInfo() {
        return "NotifiableProduct{" +
                "channel='" + channel + '\'' +
                ", id=" + id +
                ", available=" + available +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int getAmountInBundle() {
        throw new UnsupportedOperationException("Product is not a bundle");
    }
}

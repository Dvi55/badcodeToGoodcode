package ORG.EXAMPLE.moDEL;

import lombok.Setter;

@Setter
public class ProductBundle extends NotifiableProduct{
    protected int amount;
    @Override
    public String generateAddressForNotification() {
        throw new UnsupportedOperationException("Bundle can't be notified");
    }

    @Override
    public int getAmountInBundle() {
        return amount;
    }

    @Override
    public String getBasicInfo() {
        return "ProductBundle{" +
                "channel='" + channel + '\'' +
                ", id=" + id +
                ", available=" + available +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", amountInBundle=" + amount +
                '}';
    }
}

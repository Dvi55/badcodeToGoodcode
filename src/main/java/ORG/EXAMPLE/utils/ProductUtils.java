package ORG.EXAMPLE.utils;

import ORG.EXAMPLE.moDEL.IProduct;
import ORG.EXAMPLE.moDEL.NotifiableProduct;
import ORG.EXAMPLE.moDEL.Product;
import ORG.EXAMPLE.moDEL.ProductBundle;
import ORG.EXAMPLE.repository.ProductRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ProductUtils {
    private ProductRepository repository = new ProductRepository();

    public void saveNotifiableProduct(NotifiableProduct product) {
        repository.save(product);
    }

    public void saveProductBundle(ProductBundle product) {
        repository.save(product);
    }

    public int filterNotifiableProductsAndSendNotifications() {
        int notifications = 0;
        List<NotifiableProduct> products = repository.getAll().stream().filter(it -> it instanceof NotifiableProduct).map(it -> (NotifiableProduct) it).toList();
        for (NotifiableProduct product : products) {
            if (product instanceof ProductBundle) {
                continue;
            }
            //sending some notifications here
            notifications++;
        }
        return notifications;
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public Product generateRandomProduct() {
        Random random = new Random();
        if (random.nextBoolean()) {
            ProductBundle productBundle = new ProductBundle();
            productBundle.setAmount(random.nextInt(15));
            productBundle.setAvailable(random.nextBoolean());
            productBundle.setChannel(random.nextBoolean() + "" + random.nextDouble());
            productBundle.setPrice(random.nextDouble());
            productBundle.setId(random.nextLong());
            productBundle.setTitle(random.nextFloat() + "" + random.nextDouble());
            return productBundle;
        } else {
            NotifiableProduct product = new NotifiableProduct();
            product.setId(random.nextLong());
            product.setTitle(random.nextFloat() + "" + random.nextDouble());
            product.setAvailable(random.nextBoolean());
            product.setChannel(random.nextBoolean() + "" + random.nextDouble());
            product.setPrice(random.nextDouble());
            return product;
        }
    }
}

package org.example;

import org.example.models.NotifiableProduct;
import org.example.models.Product;
import org.example.models.ProductBundle;
import org.example.repository.ProductRepository;
import org.example.utils.ProductUtils;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductUtils utils = new ProductUtils(repository);
        List<Product> products = new ArrayList<>();
        products.add(utils.generateRandomProduct());
        products.add(utils.generateRandomProduct());
        products.add(utils.generateRandomProduct());
        products.add(utils.generateRandomProduct());
        products.add(utils.generateRandomProduct());
        products.add(utils.generateRandomProduct());
        products.add(utils.generateRandomProduct());
        products.forEach(it -> {
            if (it instanceof ProductBundle) {
                utils.saveProductBundle((ProductBundle) it);
            } else if (it instanceof NotifiableProduct) {
                utils.saveNotifiableProduct((NotifiableProduct) it);
            }
        });

        System.out.println(utils.getAll());
        System.out.println("notifications sent: " + utils.filterNotifiableProductsAndSendNotifications());
    }
}

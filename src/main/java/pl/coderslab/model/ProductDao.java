package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductDao {

    final List<Product> productList = Arrays.asList(
    new Product("product1", 10.0),
    new Product("product2", 20.0),
    new Product("product3", 30.0));

    public List<Product> getProductList() {
        return productList;
    }
}

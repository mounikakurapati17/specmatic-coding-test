package com.store.repository;

import com.store.models.Product;
import com.store.models.ProductDetails;
import com.store.models.ProductType;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private int currentId = 1;

    public ProductRepository() {
        ProductDetails product1 = new ProductDetails("Book 1",ProductType.book,  10,10);
        ProductDetails product2 = new ProductDetails( "Food 1", ProductType.food,20,10);
        ProductDetails product3 = new ProductDetails( "Gadget 1", ProductType.gadget,30,10);
        ProductDetails product4 = new ProductDetails( "Other 1", ProductType.other,40,10);

        add(product1);
        add(product2);
        add(product3);
        add(product4);
    }

    public int add(ProductDetails productDetails) {
        currentId++;
        Product newProduct = new Product(currentId, productDetails.getType(),
                productDetails.getName(),
                productDetails.getInventory(),
                productDetails.getCost());
        products.add(newProduct);
        return currentId;
    }

    public List<Product> getAll() {
        return products;
    }
}
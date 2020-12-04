package eteosf.hexagonal.infrastructure.persistence.inmemory.adapter;

import eteosf.hexagonal.domain.model.Product;
import eteosf.hexagonal.domain.spi.ProductPersistencePort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInMemoryAdapter implements ProductPersistencePort {

    private static final Map<Integer, Product> productMap = new HashMap<Integer, Product>(0);

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void removeProduct(Product product) {
        productMap.remove(product.getProductId());
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(productMap.values());
    }

    public Product getProductById(Integer productId) {
        return productMap.get(productId);
    }
}

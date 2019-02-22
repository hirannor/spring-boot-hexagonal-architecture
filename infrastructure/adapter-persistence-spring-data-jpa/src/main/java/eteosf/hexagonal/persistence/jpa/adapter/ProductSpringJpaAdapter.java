package eteosf.hexagonal.persistence.jpa.adapter;

import eteosf.hexagonal.domain.model.Product;
import eteosf.hexagonal.domain.spi.ProductPersistencePort;
import eteosf.hexagonal.persistence.jpa.entity.ProductEntity;
import eteosf.hexagonal.persistence.jpa.repository.ProductRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductSpringJpaAdapter implements ProductPersistencePort {

    private ProductRepository productRepository;

    public ProductSpringJpaAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        productRepository.save(productEntity);
    }

    @Override
    public void removeProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        productRepository.delete(productEntity);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<Product>();
        List<ProductEntity> productEntityList = productRepository.findAll();
        for(ProductEntity productEntity : productEntityList) {
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            productList.add(product);
        }
        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        ProductEntity productEntity = productRepository.findByProductId(productId);
        if (productEntity == null) {
            // throw new ProductNotFoundException
        }
        Product product = new Product();
        BeanUtils.copyProperties(productEntity, product);

        return product;
    }
}

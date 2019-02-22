package eteosf.hexagonal.application.service.config;

import eteosf.hexagonal.application.service.adapter.ProductServiceAdapter;
import eteosf.hexagonal.application.service.api.ProductService;
import eteosf.hexagonal.domain.spi.ProductPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ProductService getProductService(ProductPersistencePort productPersistencePort) {
        return new ProductServiceAdapter(productPersistencePort);
    }
}

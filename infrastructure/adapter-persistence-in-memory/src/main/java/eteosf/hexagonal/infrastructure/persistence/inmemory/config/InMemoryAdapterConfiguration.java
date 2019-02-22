package eteosf.hexagonal.infrastructure.persistence.inmemory.config;

import eteosf.hexagonal.domain.spi.ProductPersistencePort;
import eteosf.hexagonal.infrastructure.persistence.inmemory.adapter.ProductInMemoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryAdapterConfiguration {

    @Bean
    public ProductPersistencePort getProductPersistencePort() {
        return new ProductInMemoryAdapter();
    }
}

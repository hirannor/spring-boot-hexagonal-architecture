package eteosf.hexagonal.persistence.jpa.config;

import eteosf.hexagonal.domain.spi.ProductPersistencePort;
import eteosf.hexagonal.persistence.jpa.adapter.ProductSpringJpaAdapter;
import eteosf.hexagonal.persistence.jpa.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public ProductPersistencePort getProductPersistencPort(ProductRepository productRepository) {
        return new ProductSpringJpaAdapter(productRepository);
    }
}

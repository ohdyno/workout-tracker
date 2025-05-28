package me.xingzhou.workout.tracker.web.config;

import me.xingzhou.workout.tracker.tooling.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Configuration for domain-related beans. */
@Configuration
public class DomainConfig {

    /** Creates an IdGenerator bean. */
    @Bean
    public IdGenerator idGenerator() {
        return new IdGenerator();
    }
}

package com.kafka_learning.inventory_service.config;

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfig {

        @Bean
        public DefaultErrorHandler errorHandler(KafkaTemplate<Object, Object> kafkaTemplate) {

                DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate);

                FixedBackOff backOff = new FixedBackOff(2000L, 3);
                // Ví dụ sẽ dùng ở các bài sau
                // errorHandler.addNotRetryableExceptions(IllegalArgumentException.class);
                return new DefaultErrorHandler(recoverer, backOff);
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<Object, Object> batchFactory(
                        ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
                        ConsumerFactory<Object, Object> consumerFactory) {

                ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();

                configurer.configure(factory, consumerFactory);

                factory.setBatchListener(true);

                return factory;
        }

}
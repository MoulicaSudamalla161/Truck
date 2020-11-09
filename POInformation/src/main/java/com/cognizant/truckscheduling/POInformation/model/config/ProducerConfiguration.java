package com.cognizant.truckscheduling.POInformation.model.config;

import com.cognizant.truckscheduling.POInformation.model.PODownload;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import springfox.documentation.spring.web.json.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {
    @Value("${kafka.bootstrap-server}")
    public String bootStrapServerUrl;
    @Bean
    public Map<String,Object> map(){
        Map<String,Object> map = new HashMap<>();

        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServerUrl);
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        return map;
    }

    @Bean
    public ProducerFactory<String,PODownload> producerFactory(){
        return new DefaultKafkaProducerFactory<>(map());
    }

    @Bean
    public KafkaTemplate<String, PODownload> kafkaTemplate(){
        return  new KafkaTemplate<>(producerFactory());

    }
}

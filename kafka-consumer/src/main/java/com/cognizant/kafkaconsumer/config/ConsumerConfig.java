package com.cognizant.kafkaconsumer.config;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

public class ConsumerConfig {

    public Map<String, Object> configMap(){
        Map<String,Object> amap = new HashMap<>();
        amap.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        amap.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        amap.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        amap.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,"my-app");
//        amap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return amap;
    }




    @Bean
    public ConsumerFactory<? super String, ? super Object> consumerFactory() {
        return  new DefaultKafkaConsumerFactory<>(configMap());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;

    }
}

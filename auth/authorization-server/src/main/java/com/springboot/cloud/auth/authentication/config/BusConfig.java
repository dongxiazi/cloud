package com.springboot.cloud.auth.authentication.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;


/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/25 14:53
 */
@Configuration
@Slf4j
public class BusConfig {
    private static final String EXCHANGE_NAME = "spring-boot-exchange";
    private static final String ROUTING_KEY = "organization-resource";

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    Queue queue() {
        String queueName = new Base64UrlNamingStrategy(appName + ".").generateName();
        log.info("queue name:{}", queueName);
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        log.info("exchange:{}", EXCHANGE_NAME);
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        log.info("binding {} to {} with {}", queue, exchange, ROUTING_KEY);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory,
                                                                  MessageListenerAdapter messageListenerAdapter, Queue queue) {
        log.info("init simpleMessageListenerContainer {}", queue.getName());
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(queue.getName());
        container.setMessageListener(messageListenerAdapter);
        return container;
    }

}

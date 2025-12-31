package com.example.deploy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoConfig {
    @Bean
    public DynamoDbClient getDynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_2)
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient getEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }
}

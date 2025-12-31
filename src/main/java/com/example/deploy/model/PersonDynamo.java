package com.example.deploy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
public class PersonDynamo {
    private String id;
    private String name;
    private String email;

    @DynamoDbPartitionKey
    public String getId() { return id; }
}

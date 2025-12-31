package com.example.deploy.service;

import com.example.deploy.model.PersonDynamo;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Service
public class PersonServiceDynamo {
    private final DynamoDbTable<PersonDynamo> personTable;

    public PersonServiceDynamo(DynamoDbEnhancedClient enhancedClient) {
        this.personTable = enhancedClient.table("UsersTable", TableSchema.fromBean(PersonDynamo.class));
    }

    public PersonDynamo update(PersonDynamo person) {
        personTable.putItem(person);
        return person;
    }

    public void delete(String id) {
        Key key = Key.builder().partitionValue(id).build();
        personTable.deleteItem(key);
    }
}

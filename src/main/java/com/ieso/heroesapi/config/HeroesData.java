/**
 * 
 */
package com.ieso.heroesapi.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.ieso.heroesapi.constants.HeroesConstants.ENDPOINT_DYNAMO;
import static com.ieso.heroesapi.constants.HeroesConstants.REGION_DYNAMO;
/**
 * @author Anderson dos Reis Santos
 *
 */
@Configuration
@EnableDynamoDBRepositories
public class HeroesData {
	
	public static void main(String[] args) throws Exception{
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
				.build();
		
		DynamoDB dynamoDB = new DynamoDB(client);
		
		Table table = dynamoDB.getTable("Heroes_Table");
		Item hero1 = new Item()
				.withPrimaryKey("id", "1")
				.withString("name", "Mulher Maravilha")
				.withString("universe", "dc comics")
				.withNumber("films", 3);
		
		Item hero2 = new Item()
			      .withPrimaryKey("id", "2")
			      .withString("name", "Homem Aranha")
			      .withString("universe", "marvel")
			      .withNumber("films", 5);

		Item hero3 = new Item()
			      .withPrimaryKey("id", "3")
			      .withString("name", "Wolverine")
			      .withString("universe", "marvel")
			      .withNumber("films", 1);
		
		PutItemOutcome outcome1 = table.putItem(hero1);
		PutItemOutcome outcome2 = table.putItem(hero2);
		PutItemOutcome outcome3 = table.putItem(hero3);
	}

}

/**
 * 
 */
package com.ieso.heroesapi.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.util.StringUtils;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {
	
	@Value("$(amazon.dynamodb.endpoint)")
	private String amazonDynamoDBEndpoint;
	
	@Value("$(aws_acess_key_id)")
	private String amazonAWSAcesskey;
	
	@Value("$(aws_secret_acess_key)")
	private String AmazonAWSSecretkey;
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
		if(!StringUtils.isNullOrEmpty(amazonDynamoDBEndpoint)) {
			amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
		}
		return amazonDynamoDB;
	}
	
	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(amazonAWSAcesskey, AmazonAWSSecretkey);
	}

}

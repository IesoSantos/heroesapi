/**
 * 
 */
package com.ieso.heroesapi.model;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Heroes_Table")
public class Heroes {

	@Id
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	@DynamoDBAttribute(attributeName = "name")
	private String name;
	@DynamoDBAttribute(attributeName = "universe")
	private String universe;
	@DynamoDBAttribute(attributeName = "films")
	private int fims;
}

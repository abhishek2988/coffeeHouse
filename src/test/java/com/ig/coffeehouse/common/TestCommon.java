package com.ig.coffeehouse.common;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ig.coffeehouse.dto.CoffeeHouseReportDTO;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.dto.Order;
import com.ig.coffeehouse.dto.Receipt;

/**
 * @author abhisagrawal
 *
 */
public class TestCommon {
	
	
	private static final String COFFEE_VARIETY_JSON = "CoffeeVariety.json";
	private static final String DAILY_REPORT_RESP_JSON = "DailyReportResponse.json";
	private static final String CUSTOMER_REQ_JSON = "Customer.json";
	private static final String ORDER_REQ_JSON = "Order.json";
	private static final String ORDER_RECEIPT_JSON = "Receipt.json";
	private static final String COFFEE_VARIETY_MAP_JSON = "CoffeeVarietyMap.json";
	
	/**Method to get json from file
	 * @return
	 * @throws Exception
	 */
	protected List<CoffeeVariety> getCoffeeVarietyJson() throws Exception{
		return buildObjectMapper().readValue(readJsonFileForList(COFFEE_VARIETY_JSON).toString(), new TypeReference<List<CoffeeVariety>>(){});
	}
	
	
	/**Method to get daily report response json from file
	 * @return
	 * @throws Exception
	 */
	protected CoffeeHouseReportDTO getDailyReportResponseJson() throws Exception{
		return buildObjectMapper().readValue(readJsonFile(DAILY_REPORT_RESP_JSON).toString(), CoffeeHouseReportDTO.class);
	}
	
	/**Method to get customer request json from file
	 * @return
	 * @throws Exception
	 */
	protected Customer getCustomerJson() throws Exception{
		return buildObjectMapper().readValue(readJsonFile(CUSTOMER_REQ_JSON).toString(), Customer.class);
	}
	
	/**Method to get process order request json from file
	 * @return
	 * @throws Exception
	 */
	protected Order getOrderJson() throws Exception{
		return buildObjectMapper().readValue(readJsonFile(ORDER_REQ_JSON).toString(), Order.class);
	}
	
	/**Method to get process order response receipt json from file
	 * @return
	 * @throws Exception
	 */
	protected Receipt getReceiptJson() throws Exception{
		return buildObjectMapper().readValue(readJsonFile(ORDER_RECEIPT_JSON).toString(), Receipt.class);
	}
	
	
	/**Method to get json from file
	 * @return
	 * @throws Exception
	 */
	protected Map<String, CoffeeVariety>getCoffeeVarietyMapJson() throws Exception{
		return buildObjectMapper().readValue(readJsonFile(COFFEE_VARIETY_MAP_JSON).toString(), new TypeReference<Map<String,CoffeeVariety>>(){});
	}
	
	
	/**
	 * Reads json file from the resources folder.
	 * 
	 * @return
	 * @throws Exception
	 */
	protected JsonObject readJsonFile(String fileName) throws Exception{
		final JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(new FileReader(
        		TestCommon.class.getClassLoader().getResource(fileName).getFile()));
		return jsonElement.getAsJsonObject();
	}
	
	/**
	 * Reads json file from the resources folder.
	 * 
	 * @return
	 * @throws Exception
	 */
	protected JsonArray readJsonFileForList(String fileName) throws Exception{
		final JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(new FileReader(
        		TestCommon.class.getClassLoader().getResource(fileName).getFile()));
		return jsonElement.getAsJsonArray();
	}
	
	
	
	/**Returns object mapper object
	 * @return
	 */
	private ObjectMapper buildObjectMapper(){
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	
	
}


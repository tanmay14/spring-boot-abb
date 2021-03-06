package com.tanmaynpatel.springboot;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.tanmaynpatel.springboot.abb.MeasurementList;
import com.tanmaynpatel.springboot.abb.Measurements;
import com.tanmaynpatel.springboot.model.GroupTotalDetails;

@SpringBootApplication

public class SpringBootAbbApplication {

	public static void main(String[] args) {

		MeasurementList extractMeasurementsFromFile = extractMeasurementsFromFile();
		
		/*2. Write a method that prints the totals for both groups for in and outgoing power.*/
		OpMeasurementsServiceImplementation opMeasurementsServiceImplementation = new OpMeasurementsServiceImplementation();

		List<GroupTotalDetails> totalsCalculationForGroups = opMeasurementsServiceImplementation
				.getTotalsCalculationForGroups(extractMeasurementsFromFile.getMeasurements());

		System.out.println(totalsCalculationForGroups);
		
		/* 3. Write a method that outputs a list of all devices, and their max power */

		Measurements allGroupedDevicesWithMaxPower = opMeasurementsServiceImplementation
				.getAllGroupedDevicesWithMaxPower(extractMeasurementsFromFile.getMeasurements());
		
		System.out.println(allGroupedDevicesWithMaxPower);

	}
	
	/*
	 * 1. Read the measurements.json file and store the values in the Measurements
	 * object.
	 */
	@SuppressWarnings("finally")
	private static MeasurementList extractMeasurementsFromFile() {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		ClassLoader classLoader = SpringBootAbbApplication.class.getClassLoader();
		// List<Measurement> measurementList = null;
		MeasurementList measurements = new MeasurementList();

		try (InputStream inputStream = classLoader.getResourceAsStream("measurements.json")) {

			String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

			// measurementList = (List<Measurement>) parser.parse(result);
			Gson gson = new Gson();
			measurements = gson.fromJson(result, MeasurementList.class);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return measurements;
		}
	}

}

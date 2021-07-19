package com.tanmaynpatel.springboot;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.tanmaynpatel.springboot.abb.Direction;
import com.tanmaynpatel.springboot.abb.Key;
import com.tanmaynpatel.springboot.abb.Measurement;
import com.tanmaynpatel.springboot.abb.Measurements;
import com.tanmaynpatel.springboot.abb.Power;
import com.tanmaynpatel.springboot.totalclasses.GroupTotalDetails;

class OpMeasurementsServiceImplementationTest {

	OpMeasurementsServiceImplementation opImpl = new OpMeasurementsServiceImplementation();

	private List<Measurement> setMeasurement() {
		List<Measurement> measurementList = new ArrayList<>();
		List<Power> powerList = new ArrayList<>();

		Measurement measure1 = new Measurement();

		Power power = new Power();

		power.setAvg(123);
		power.setMax(167);
		power.setMin(100);
		powerList.add(power);

		measure1.setDeviceGroup("group_a");
		measure1.setDeviceName("device_1");
		measure1.setDirection(Direction.IN);
		measure1.setPower(powerList);
		measure1.setResourceId("943d3685-9874-4082-9362-fd4e9771c3c6");

		measurementList.add(measure1);
		Measurement measure2 = new Measurement();

		Power power2 = new Power();

		power2.setAvg(1.644587151165991);
		power2.setMax(65.44320674787848);
		power2.setMin(33.543896949522235);
		powerList.add(power2);

		measure2.setDeviceGroup("group_b");
		measure2.setDeviceName("device_18");
		measure2.setDirection(Direction.OUT);
		measure2.setPower(powerList);
		measure2.setResourceId("943d3685-8054-4082-9362-fd4e9771c3c6");

		measurementList.add(measure2);

		return measurementList;

	}

	@Test
	void testGetTotalsCalculationForGroups() {
		List<Measurement> setMeasurement = setMeasurement();
		List<GroupTotalDetails> totalsCalculationForGroups = opImpl.getTotalsCalculationForGroups(setMeasurement);
		// System.out.println(totalsCalculationForGroups);
		assertNotNull(totalsCalculationForGroups);
		assertEquals(2, totalsCalculationForGroups.size());
	}

	@Test
	void testGetAllGroupedDevicesWithMaxPower() {
		List<Measurement> setMeasurement = setMeasurement();
		Measurements allGroupedDevicesWithMaxPower = opImpl.getAllGroupedDevicesWithMaxPower(setMeasurement);
		// System.out.println(allGroupedDevicesWithMaxPower);
		assertEquals(2, allGroupedDevicesWithMaxPower.size());
		// Set<Key> keySet = allGroupedDevicesWithMaxPower.keySet();
		assertEquals(2, allGroupedDevicesWithMaxPower.keySet().size());
	}

}

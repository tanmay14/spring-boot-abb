package com.tanmaynpatel.springboot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.tanmaynpatel.springboot.abb.Direction;
import com.tanmaynpatel.springboot.abb.Key;
import com.tanmaynpatel.springboot.abb.Measurement;
import com.tanmaynpatel.springboot.abb.Measurements;
import com.tanmaynpatel.springboot.abb.Power;
import com.tanmaynpatel.springboot.model.DirectionTotalDetail;
import com.tanmaynpatel.springboot.model.GroupTotalDetails;
import com.tanmaynpatel.springboot.model.TotalDetail;

public class OpMeasurementsServiceImplementation {
//2) Write a method that prints the totals for both groups for in and outgoing power.
	public List<GroupTotalDetails> getTotalsCalculationForGroups(List<Measurement> measurements) {
		// group the stream by device group

		List<GroupTotalDetails> groupDetailsList = new ArrayList<>();

		Map<String, List<Measurement>> collect = measurements.stream()
				.collect(Collectors.groupingBy(Measurement::getDeviceGroup));

		// get group_a details

		Set<String> groupNameSet = collect.keySet();

		// loop through all the keys then gets direction details

		for (String groupName : groupNameSet) {

			// create group details
			GroupTotalDetails groupDetails = new GroupTotalDetails();

			groupDetails.setGroupName(groupName);

			List<Measurement> measurementsPerGroupName = collect.get(groupName);

			// make goup according to direction
			Map<Direction, List<Measurement>> MeasurementsGropedByDirection = measurementsPerGroupName.stream()
					.collect(Collectors.groupingBy(Measurement::getDirection));

			Set<Direction> directionSet = MeasurementsGropedByDirection.keySet();

			List<DirectionTotalDetail> directionTotalDetails = new ArrayList<>();

			// fill the directionTotalDetails
			for (Direction direction : directionSet) {

				DirectionTotalDetail directionTotaldetail = getDirectionTotaldetail(direction,
						MeasurementsGropedByDirection.get(direction));
				directionTotalDetails.add(directionTotaldetail);
			}
			groupDetails.setDirectionTotalDetails(directionTotalDetails);

			// System.out.println(MeasurementsGropedByDirection);
			groupDetailsList.add(groupDetails);

		}
		return groupDetailsList;
	}


	private DirectionTotalDetail getDirectionTotaldetail(Direction direction, List<Measurement> measurementList) {
		DirectionTotalDetail directionTotalDetail = new DirectionTotalDetail();
		TotalDetail totaldetail = new TotalDetail();
		double minTotal = 0;
		double maxTotal = 0;
		double avgTotal = 0;
		directionTotalDetail.setDirection(direction.name());
		directionTotalDetail.setCount(measurementList.size());

		// collect powerList for total
		List<Power> powerlist = new ArrayList<>();
		measurementList.stream().forEach((m) -> {
			powerlist.addAll(m.getPower());
		});

		for (Power power : powerlist) {
			minTotal = minTotal + power.getMin();
			maxTotal = maxTotal + power.getMax();
			avgTotal = avgTotal + power.getAvg();
		}
		BigDecimal.valueOf(minTotal).setScale(2, RoundingMode.UP);
		totaldetail.setAvgTotal(BigDecimal.valueOf(avgTotal).setScale(4, RoundingMode.UP));
		totaldetail.setMaxTotal(BigDecimal.valueOf(maxTotal).setScale(4, RoundingMode.UP));
		totaldetail.setMinTotal(BigDecimal.valueOf(minTotal).setScale(4, RoundingMode.UP));

		directionTotalDetail.setTotaldetail(totaldetail);

		return directionTotalDetail;

	}

	// 3) Write a method that outputs a list of all devices, and their max power,
	// ordered by group, direction and power(ascending):
	public Measurements getAllGroupedDevicesWithMaxPower(List<Measurement> measurements) {
		Measurements returnMeasurement = new Measurements();

		for (Measurement measurement : measurements) {

			Optional<Power> max = measurement.getPower().stream().max(compareByMaxPower());
			if (max.isPresent()) {
				List<Power> powerMap = new ArrayList<>();
				Power power = max.get();
				power.setAvg(BigDecimal.valueOf(power.getAvg()).setScale(4, RoundingMode.UP).doubleValue());
				power.setMax(BigDecimal.valueOf(power.getMax()).setScale(4, RoundingMode.UP).doubleValue());
				power.setMin(BigDecimal.valueOf(power.getMin()).setScale(4, RoundingMode.UP).doubleValue());
				
				powerMap.add(power);
				
				Key key1 = new Key(measurement.getResourceId().replace("-", ""), measurement.getDeviceName(),
						measurement.getDeviceGroup());
				Measurement measureMap = new Measurement();
				measureMap.setPower(powerMap);
				returnMeasurement.put(key1, measureMap);
			}
		}
		return returnMeasurement;

	}

	private Comparator<Power> compareByMaxPower() {

		Comparator<Power> compareByReviewsMaxPower = Comparator.comparing(Power::getMax);
		return compareByReviewsMaxPower;

	}

}

package com.techelevator.farm.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HarvestDateUtil {

    private static final DateTimeFormatter harvestDateFormatter = DateTimeFormatter.ofPattern("(QQQQ) EEEE MMMM dd yyyy");

    private HarvestDateUtil() {

    }

    public static String getHarvestDate(int plantingMonth, int plantingDay, int growthInDays) {
        LocalDate harvestDate = LocalDate.of(LocalDate.now().getYear(), plantingMonth, plantingDay).plusDays(growthInDays);
        return harvestDate.format(harvestDateFormatter);
    }

    public static long getDaysToHarvest(int harvestMonth, int harvestDay) {
        LocalDate harvestDate = LocalDate.of(LocalDate.now().getYear(), harvestMonth, harvestDay);
        return LocalDate.now().until(harvestDate, ChronoUnit.DAYS);
    }
}

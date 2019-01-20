package com.sample.algo.solutions.year.parser;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author manyce400
 */
public class YearRangeRangeParser implements IYearRangeParser {



    @Override
    public List<Integer> parseYearsInRange(String yearRanges) {
        Assert.notNull(yearRanges, "yearRanges cannot be null");
        Assert.isTrue(yearRanges.length() > 0, "yearRanges cannot be empty");

        List<Integer> finalYearRange = new ArrayList<>();

        String[] yearRangesArray = yearRanges.split(",");

        for(int i = 0; i< yearRangesArray.length; i ++) {
            String token = yearRangesArray[i].trim();

            if(containsYearRange(token)) {
                Optional<Map.Entry<Integer, Integer>> actualRange = getActualYearRange(token);
                if(actualRange.isPresent()) {
                    Integer yearStart = actualRange.get().getKey();
                    Integer yearEnd   = actualRange.get().getValue();

                    int currentYear = yearStart;
                    while (currentYear <= yearEnd) {
                        finalYearRange.add(currentYear);
                        currentYear++;
                    }
                }
            } else {
                if (NumberUtils.isCreatable(token)) {
                    System.out.println("Adding individual token "+ token);
                    int actualYear = NumberUtils.toInt(token);
                    finalYearRange.add(actualYear);
                }
            }
        }

        Collections.sort(finalYearRange);
        return finalYearRange;
    }

    protected Optional<Map.Entry<Integer, Integer>> getActualYearRange(String yearRange) {
        // Remove all white spaces in the string
        yearRange = yearRange.trim().replaceAll("\\s","");
        String[] entryArray = yearRange.split("-");

        Integer yearStart = NumberUtils.toInt(entryArray[0]);
        Integer yearEnd   = NumberUtils.toInt(entryArray[1]);

        // Execute validation, yeaStart < yearEnd
        if(yearStart <= yearEnd) {
            return Optional.of(new AbstractMap.SimpleEntry<>(yearStart, yearEnd));
        }

        return Optional.empty();
    }

    protected boolean containsYearRange(String yearRange) {
        return yearRange.contains("-");
    }

}

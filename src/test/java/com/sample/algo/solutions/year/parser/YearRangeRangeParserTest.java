package com.sample.algo.solutions.year.parser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author manyce400
 */
@RunWith(MockitoJUnitRunner.class)
public class YearRangeRangeParserTest {


    @Spy
    private YearRangeRangeParser yearRangeRangeParser;
    
    
    
    @Test
    public void testGetActualYearRange() {
        // Scenario where startYear > endYear
        Optional<Map.Entry<Integer, Integer>> range = yearRangeRangeParser.getActualYearRange("2002-2005");
        Assert.assertEquals(Integer.valueOf(2002), range.get().getKey());
        Assert.assertEquals(Integer.valueOf(2005), range.get().getValue());
        System.out.println("Key:=> " + range.get().getKey() + " Value:=> " + range.get().getValue());

        // Test scenario where startYear > endYear but we have white spaces in input String
        System.out.println("Testing Input String with white spaces....");
        range = yearRangeRangeParser.getActualYearRange("2002 - 2005");
        Assert.assertEquals(Integer.valueOf(2002), range.get().getKey());
        Assert.assertEquals(Integer.valueOf(2005), range.get().getValue());
        System.out.println("Key:=> " + range.get().getKey() + " Value:=> " + range.get().getValue());

        // Test scenario where startYear = endYear
        range = yearRangeRangeParser.getActualYearRange("2002-2002");
        Assert.assertEquals(Integer.valueOf(2002), range.get().getKey());
        Assert.assertEquals(Integer.valueOf(2002), range.get().getValue());
        System.out.println("Key:=> " + range.get().getKey() + " Value:=> " + range.get().getValue());

        // Test scenario where startYear > endYear
        range = yearRangeRangeParser.getActualYearRange("2005-2002");
        Assert.assertFalse(range.isPresent());
    }

    @Test
    public void testParseYearsInRange() {
        List<Integer> yearRange = yearRangeRangeParser.parseYearsInRange("2000-2005");
        Assert.assertEquals(yearRange, Arrays.asList(new Integer[]{2000, 2001, 2002, 2003, 2004, 2005}));
        System.out.println("yearRange = " + yearRange);

        yearRange = yearRangeRangeParser.parseYearsInRange("2000-2004");
        Assert.assertEquals(yearRange, Arrays.asList(new Integer[]{2000, 2001, 2002, 2003, 2004}));
        System.out.println("yearRange = " + yearRange);
    }

    @Test
    public void testParseYearsInMultiRange() {
        List<Integer> yearRange = yearRangeRangeParser.parseYearsInRange("1999, 2002-2005, 2007");
        Assert.assertEquals(yearRange, Arrays.asList(new Integer[]{1999, 2002, 2003, 2004, 2005, 2007}));
        System.out.println("yearRange = " + yearRange);

        yearRange = yearRangeRangeParser.parseYearsInRange("2015, 2014, 2010");
        Assert.assertEquals(yearRange, Arrays.asList(new Integer[]{2010, 2014, 2015}));
        System.out.println("yearRange = " + yearRange);

        yearRange = yearRangeRangeParser.parseYearsInRange("1999 , 2000,    , 2008");
        Assert.assertEquals(yearRange, Arrays.asList(new Integer[]{1999, 2000, 2008}));
        System.out.println("yearRange = " + yearRange);
    }

}

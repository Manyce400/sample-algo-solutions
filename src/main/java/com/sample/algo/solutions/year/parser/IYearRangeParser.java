package com.sample.algo.solutions.year.parser;

import java.util.List;

/**
 * @author manyce400
 */
public interface IYearRangeParser {

    /**
     * Takes year range arguments and builds out all the years in the range.
     * Final ranges should all be sorted
     *
     * Sample arguments
     * 1999, 2002-2005, 2007
     * 2002-2005, 2002-2005, 2002 - 2005 => 2002, 2003, 2004, 2005
     * 2017 - 2015 =>
     * 2015 - 2015 => 2015
     * 1999 , 2000,    , 2008 => 1999, 2000, 2008
     *
     * @param yearRanges
     * @return
     */
    public List<Integer> parseYearsInRange(String yearRanges);

}

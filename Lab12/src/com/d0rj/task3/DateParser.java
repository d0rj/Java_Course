package com.d0rj.task3;

import java.util.regex.Pattern;


public class DateParser {

    // 22/03/2001 format
    private final static Pattern DATE_PATTERN = Pattern.compile(
            "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$");

    private final static Pattern DATE_EXTRACT = Pattern.compile("\\d+");


    public boolean isDate(String str) {
        return DATE_PATTERN.matcher(str).matches();
    }


    public MyDate parse(String str) {
        if (!isDate(str))
            return null;

        var nums = new int[3];

        var matcher = DATE_EXTRACT.matcher(str);
        int index = 0;
        while (matcher.find()) {
            nums[index] = Integer.parseInt(matcher.group());
            ++index;
        }

        if (index == 0)
            return null;

        return new MyDate(nums[2], nums[1], nums[0]);
    }
}

package com.d0rj;

import java.util.regex.Pattern;


public class UsaDateParser implements IDateParser {

    // M/D/YY, M/D/YYY, MM/DD/YY, MM/DD/YYYY
    private final static Pattern DATE_PATTERN = Pattern.compile(
            "^((0?[13578]|10|12)(-|\\/)(([1-9])|(0[1-9])|([12])([0-9]?)|(3[01]?))(-|\\/)((19)([2-9])(\\d{1})|(20)([01])(\\d{1})|([8901])(\\d{1}))|(0?[2469]|11)(-|\\/)(([1-9])|(0[1-9])|([12])([0-9]?)|(3[0]?))(-|\\/)((19)([2-9])(\\d{1})|(20)([01])(\\d{1})|([8901])(\\d{1})))$"
    );

    private final static Pattern DATE_EXTRACT = Pattern.compile("\\d+");


    @Override
    public boolean isDate(String str) {
        return DATE_PATTERN.matcher(str).matches();
    }

    @Override
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

        return new MyDate(nums[2], nums[0], nums[1]);
    }
}

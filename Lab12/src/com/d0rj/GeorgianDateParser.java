package com.d0rj;

import java.util.regex.Pattern;


public class GeorgianDateParser implements IDateParser {

    // 2001-03-22
    private final static Pattern DATE_PATTERN = Pattern.compile(
            "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                    + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

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

        return new MyDate(nums[0], nums[1], nums[2]);
    }
}

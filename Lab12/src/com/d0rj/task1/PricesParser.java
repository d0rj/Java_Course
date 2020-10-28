package com.d0rj.task1;

import java.util.regex.Pattern;


public class PricesParser {

    private static final String PricePattern = "^\\d{0,8}(\\.\\d{1,2})";
    private static final String AnyPricePattern = PricePattern + "? (RUB|USD|EU)$";
    private static final String RubPricePattern = PricePattern + "? RUB$";
    private static final String DollarPricePattern = PricePattern + "? USD$";
    private static final String EuroPricePattern = PricePattern + "? EU$";

    private static final Pattern AnyPricePatternComp = Pattern.compile(AnyPricePattern);
    private static final Pattern RubPattern = Pattern.compile(RubPricePattern);
    private static final Pattern DollarPattern = Pattern.compile(DollarPricePattern);
    private static final Pattern EuroPattern = Pattern.compile(EuroPricePattern);


    public static Money Parse(String input) throws IllegalArgumentException {

        if (AnyPricePatternComp.matcher(input).matches()) {

            double price = Double.parseDouble(input.split(" ")[0]);

            if (RubPattern.matcher(input).matches())
                return Money.fromRoubles(price);
            if (DollarPattern.matcher(input).matches())
                return Money.fromDollar(price);
            if (EuroPattern.matcher(input).matches())
                return Money.fromEuro(price);
        }

        throw new IllegalArgumentException();
    }
}

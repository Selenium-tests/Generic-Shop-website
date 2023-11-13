package qa.utils;

import java.math.BigInteger;

public class Price {

    public static BigInteger toInt(String price) {

        return new BigInteger(price.replaceAll("zł", "").trim());
    }

    public static String toString(BigInteger price) {

        return String.valueOf(price) + " zł";
    }
}

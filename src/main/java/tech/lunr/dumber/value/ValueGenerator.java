package tech.lunr.dumber.value;

import com.mifmif.common.regex.Generex;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class ValueGenerator {

    public static String generateString(long min, long max, String regexp) {
        String retVal = null;
        int    size   = ThreadLocalRandom.current().nextInt((int) min, (int) max + 1);
        if (regexp != null) {
            Generex generex = new Generex(regexp);
            retVal = generex.random();
        } else {
            retVal = StringUtils.rightPad("A", size, 'B');
        }
        return retVal;
    }

    public static int generateInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    public static int generateInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static boolean generateBool() {
        return ThreadLocalRandom.current().nextBoolean();
    }

}

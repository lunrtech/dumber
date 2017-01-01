package tech.lunr.dumber.value;

import com.mifmif.common.regex.Generex;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by IB on 2017. 01. 01..
 */
public class StringGenerator {

    public static String generate(long min, long max, String regexp) {
        String retVal = null;
        int size = ThreadLocalRandom.current().nextInt((int)min, (int)max + 1);
        if (regexp != null) {
            Generex generex = new Generex(regexp);
            retVal = generex.random();
        } else {
            retVal = StringUtils.rightPad("A", size, 'B');
        }
        return retVal;
    }

}

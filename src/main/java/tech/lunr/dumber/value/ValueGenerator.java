package tech.lunr.dumber.value;

import com.mifmif.common.regex.Generex;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ValueGenerator {

    public static String generateString(long min, long max, String regexp) {
        String retVal = null;
        int size = min < max ?
                ThreadLocalRandom.current().nextInt((int) min, (int) max + 1) : 10;
        if (regexp != null) {
            Generex generex = new Generex(regexp);
            retVal = generex.random();
        } else {
            Random r = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = (int)min; i < size; i++) {
                char c = (char)(r.nextInt(26) + 'a');
                sb.append(c);
            }

            retVal = sb.toString();
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

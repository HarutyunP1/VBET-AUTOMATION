package utilities;

import org.apache.commons.lang.RandomStringUtils;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
/**
 * @author amalyahayrapetova
 */

public class RandomUtils {
    /**
     * Generate random numbers which length is given count
     */

    public static int generateRandomNumbers(int count) {
        return Integer.parseInt(RandomStringUtils.random(count, false, true));
    }

    /**
     * Generate random letters with current count
     *
     * @param count
     * @return
     */
    public static String generateRandomLetters(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }


    /**
     * Generate random letters and numbers with current count
     *
     * @param count
     * @return
     */
    public static String generateRandomLettersAndNumbers(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }


}

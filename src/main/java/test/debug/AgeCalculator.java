package test.debug;

import java.time.LocalDate;

public class AgeCalculator {

/**
 * Simple method to get age from birthdate with format YYY-MM-DD
 * @param birthdate date of birth
 *  @return age if the year is correct and -1 if exception occurred while casting
 */

    public int getAge(String birthdate) {
        String[] parts = birthdate.split("-");
        if (parts.length > 0) {
            try {
                int year = Integer.valueOf(parts[0]);
                int now = LocalDate.now().getYear();

                return now - year;
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return -1;
    }
}

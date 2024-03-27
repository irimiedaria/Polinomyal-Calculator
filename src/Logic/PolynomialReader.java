package Logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.*;
public class PolynomialReader {
    private static final String REGEX = "([+-]?\\d*)?x\\^(\\d+)";
    private Pattern pattern = Pattern.compile(REGEX);

    public Polynomial Read(String input) throws InvalidInputException {
        try {
            int count = 0;
            Matcher matcher = pattern.matcher(input);
            Polynomial p = new Polynomial();

            while (matcher.find()) {
                int coefficient = 1;
                if (matcher.group(1) != null && !matcher.group(1).isEmpty()) {
                    coefficient = Integer.parseInt(matcher.group(1));
                }
                int power = Integer.parseInt(matcher.group(2));
                p.addTerm(power, coefficient);
                count++;
            }
            if(count == 0) {
                throw new InvalidInputException("Invalid input pattern!");
            }
            return p;
        } catch (Exception e) {
            throw new InvalidInputException("Invalid input pattern!");
        }
    }
}

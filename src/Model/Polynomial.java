package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Polynomial {
    private HashMap<Integer, Double> terms;

    public Polynomial() {
        terms = new HashMap<>();
    }

    public HashMap<Integer, Double> getTerms() {
        return terms;
    }

    public void setTerms(HashMap<Integer, Double> terms) {
        this.terms = terms;
    }

    public void addTerm(int exponent, double coefficient) {
        terms.put(exponent, coefficient);
    }

    @Override
    public String toString() {
       String str = "";
       ArrayList<Integer> exponents = new ArrayList<>(getTerms().keySet());
       Collections.sort(exponents, Collections.reverseOrder());
       for(Integer exponent : exponents) {
           double coefficient = getTerms().get(exponent);

           if(coefficient == 0) {
               continue;
           }
           if(coefficient > 0 && !str.isEmpty()) {
               str += "+";
           }
           str += coefficient;

           if(exponent == 1) {
               str += "x";
           } else if (exponent > 1) {
               str += "x^" + exponent;
           }
       }

       if(str.isEmpty()) {
           str = "0";
       }
       return str;
    }
}


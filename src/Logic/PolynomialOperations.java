package Logic;

import Model.*;

import java.util.HashMap;

public class PolynomialOperations {
    public Polynomial AddPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        HashMap<Integer, Double> resultTerms = new HashMap<>();

        for(Integer exponent : p1.getTerms().keySet()) {
            double coefficient = p1.getTerms().get(exponent);
            resultTerms.put(exponent, coefficient);
        }

        for(Integer exponent : p2.getTerms().keySet()) {
            double coefficient = p2.getTerms().get(exponent);
            Double coefCurrent = resultTerms.get(exponent);
            if(coefCurrent == null) {
                coefCurrent = 0.0;
            }
            resultTerms.put(exponent, coefficient + coefCurrent);
        }
        result.setTerms(resultTerms);

        return result;
    }

    public Polynomial SubPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        HashMap<Integer, Double> resultTerms = new HashMap<>();

        for(Integer exponent : p1.getTerms().keySet()) {
            double coefficient = p1.getTerms().get(exponent);
            resultTerms.put(exponent, coefficient);
        }

        for(Integer exponent : p2.getTerms().keySet()) {
            double coefficient = p2.getTerms().get(exponent);
            Double coefCurrent = resultTerms.get(exponent);
            if(coefCurrent == null) {
                coefCurrent = 0.0;
            }
            resultTerms.put(exponent, coefCurrent - coefficient);
        }
        result.setTerms(resultTerms);

        return result;
    }

    public Polynomial DerivePolynomial(Polynomial p) {
        Polynomial result = new Polynomial();
        HashMap<Integer, Double> resultTerms = new HashMap<>();

        for(Integer exponent : p.getTerms().keySet()) {
            double coefficient = p.getTerms().get(exponent);
            if(exponent != 0) {
                resultTerms.put(exponent - 1, coefficient * exponent);
            }
        }
        result.setTerms(resultTerms);
        return result;
    }

    public Polynomial IntegratePolynomial(Polynomial p) {
        Polynomial result = new Polynomial();
        HashMap<Integer, Double> resultTerms = new HashMap<>();

        for(Integer exponent : p.getTerms().keySet()) {
            double coefficient = p.getTerms().get(exponent);
            resultTerms.put(exponent + 1, coefficient/(exponent + 1));
        }
        result.setTerms(resultTerms);
        return result;
    }

    public Polynomial MultiplyPolynomial(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        HashMap<Integer, Double> resultTerms = new HashMap<>();

        for(Integer exponent1 : p1.getTerms().keySet()) {
            double coefficient1 = p1.getTerms().get(exponent1);

            for(Integer exponent2 : p2.getTerms().keySet()) {
                double coefficient2 = p2.getTerms().get(exponent2);
                double newCoefficient = coefficient1 * coefficient2;
                int newExponent = exponent1 + exponent2;
                if(resultTerms.containsKey(newExponent)) {
                    newCoefficient += resultTerms.get(newExponent);
                }
                resultTerms.put(newExponent, newCoefficient);
            }
        }
        result.setTerms(resultTerms);
        return result;
    }


}

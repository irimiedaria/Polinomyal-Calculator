import static org.junit.Assert.*;

import GUI.CalculatorInterface;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import Model.InvalidInputException;

public class CalculatorInterfaceTestUnit {
    private CalculatorInterface calculatorInterface;
    private JTextField firstPolynomialTextField;
    private JTextField secondPolynomialTextField;
    private JTextField resultPolynomialTextField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    //private JButton divideButton;
    private JButton deriveButton;
    private JButton integrateButton;

    @Before
    public void setUp() throws Exception {
        calculatorInterface = new CalculatorInterface();
        firstPolynomialTextField = calculatorInterface.getFieldFirstPol();
        secondPolynomialTextField = calculatorInterface.getFieldSecondPol();
        resultPolynomialTextField = calculatorInterface.getFieldResult();
        addButton = (JButton) calculatorInterface.getContentPane().getComponent(6);
        subtractButton = (JButton) calculatorInterface.getContentPane().getComponent(7);
        multiplyButton = (JButton) calculatorInterface.getContentPane().getComponent(8);
        deriveButton = (JButton) calculatorInterface.getContentPane().getComponent(10);
        integrateButton = (JButton) calculatorInterface.getContentPane().getComponent(11);
        //divideButton = (JButton) calculatorInterface.getContentPane().getComponent(9);
    }

    @Test
    public void testAddition() throws InvalidInputException {
        firstPolynomialTextField.setText("2x^2+5x^1+6x^0");
        secondPolynomialTextField.setText("1x^2+3x^1+6x^0");
        addButton.doClick();
        assertEquals("3.0x^2+8.0x+12.0", resultPolynomialTextField.getText());
    }

    @Test
    public void testSubtraction() throws InvalidInputException {
        firstPolynomialTextField.setText("3x^2+5x^1+7x^0");
        secondPolynomialTextField.setText("1x^2+4x^1+6x^0");
        subtractButton.doClick();
        assertEquals("2.0x^2+1.0x+1.0", resultPolynomialTextField.getText());
    }

    @Test
    public void testMultiplication() throws InvalidInputException {
        firstPolynomialTextField.setText("3x^2+5x^1+7x^0");
        secondPolynomialTextField.setText("2x^1+4x^0");
        multiplyButton.doClick();
        assertEquals("6.0x^3+22.0x^2+34.0x+28.0", resultPolynomialTextField.getText());
    }

    @Test
    public void testDerivation() throws InvalidInputException {
        firstPolynomialTextField.setText("3x^2+5x^1+7x^0");
        deriveButton.doClick();
        assertEquals("6.0x+5.0", resultPolynomialTextField.getText());
    }

    @Test
    public void testIntegration() throws InvalidInputException {
        firstPolynomialTextField.setText("3x^2+5x^1+7x^0");
        integrateButton.doClick();
        assertEquals("1.0x^3+2.5x^2+7.0x", resultPolynomialTextField.getText());
    }
}

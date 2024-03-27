package GUI;

import Logic.PolynomialOperations;
import Logic.PolynomialReader;
import Model.InvalidInputException;
import Model.Polynomial;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
public class CalculatorInterface extends JFrame {
    private JPanel contentPane;
    private JTextField fieldFirstPol;
    private JTextField fieldSecondPol;
    private JTextField fieldResult;

    public JTextField getFieldFirstPol() {
        return fieldFirstPol;
    }
    public JTextField getFieldSecondPol() {
        return fieldSecondPol;
    }

    public JTextField getFieldResult() {
        return fieldResult;
    }

    private PolynomialReader polynomialReader;
    private PolynomialOperations polynomialOperations;
    public CalculatorInterface() {

        polynomialReader = new PolynomialReader();
        polynomialOperations = new PolynomialOperations();

        setFont(new Font("Dialog", Font.BOLD, 12));
        setTitle("polynomial calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 561, 490);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel textFirstPol = new JLabel("Enter the first polynomial");
        textFirstPol.setFont(new Font("Serif", Font.BOLD, 13));
        textFirstPol.setBounds(10, 73, 176, 20);
        contentPane.add(textFirstPol);

        fieldFirstPol = new JTextField();
        fieldFirstPol.setBounds(10, 104, 221, 29);
        contentPane.add(fieldFirstPol);
        fieldFirstPol.setColumns(10);

        JLabel textSecondPol = new JLabel("Enter the second polynomial");
        textSecondPol.setFont(new Font("Serif", Font.BOLD, 13));
        textSecondPol.setBounds(311, 73, 176, 20);
        contentPane.add(textSecondPol);

        JLabel textTitle = new JLabel("Polynomial calculator");
        textTitle.setFont(new Font("Papyrus", Font.BOLD, 22));
        textTitle.setBounds(149, 20, 256, 29);
        contentPane.add(textTitle);

        fieldSecondPol = new JTextField();
        fieldSecondPol.setBounds(311, 104, 217, 29);
        contentPane.add(fieldSecondPol);
        fieldSecondPol.setColumns(10);

        JLabel textOperation = new JLabel("Operation");
        textOperation.setFont(new Font("Serif", Font.BOLD, 13));
        textOperation.setBounds(248, 229, 176, 20);
        contentPane.add(textOperation);

        JButton btnAdd = new JButton("add");
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(90, 124, 105));
        btnAdd.setBorderPainted(false);
        btnAdd.setFont(new Font("Serif", Font.BOLD, 10));
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial p1;
                Polynomial p2;
                try{
                    p1 = polynomialReader.Read(getFieldFirstPol().getText());
                    p2 = polynomialReader.Read(getFieldSecondPol().getText());
                } catch(InvalidInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
                Polynomial result = polynomialOperations.AddPolynomials(p1, p2);
                fieldResult.setText(result.toString());
            }
        });
        btnAdd.setBounds(134, 163, 79, 38);
        contentPane.add(btnAdd);

        JButton btnSub = new JButton("subtract");
        btnSub.setForeground(new Color(255, 255, 255));
        btnSub.setBackground(new Color(90, 124, 105));
        btnSub.setBorderPainted(false);
        btnSub.setFont(new Font("Serif", Font.BOLD, 10));
        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial p1;
                Polynomial p2;
                try{
                    p1 = polynomialReader.Read(getFieldFirstPol().getText());
                    p2 = polynomialReader.Read(getFieldSecondPol().getText());
                } catch(InvalidInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }

                Polynomial result = polynomialOperations.SubPolynomials(p1, p2);
                fieldResult.setText(result.toString());
            }
        });
        btnSub.setBounds(134, 221, 79, 38);
        contentPane.add(btnSub);

        JButton btnMultiply = new JButton("multiply");
        btnMultiply.setForeground(new Color(255, 255, 255));
        btnMultiply.setBackground(new Color(90, 124, 105));
        btnMultiply.setBorderPainted(false);
        btnMultiply.setFont(new Font("Serif", Font.BOLD, 10));
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial p1;
                Polynomial p2;
                try {
                    p1 = polynomialReader.Read(getFieldFirstPol().getText());
                    p2 = polynomialReader.Read(getFieldSecondPol().getText());
                } catch(InvalidInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }

                Polynomial result = polynomialOperations.MultiplyPolynomial(p1, p2);
                fieldResult.setText(result.toString());
            }
        });
        btnMultiply.setBounds(134, 280, 79, 38);
        contentPane.add(btnMultiply);

        JButton btnDivide = new JButton("divide");
        btnDivide.setForeground(new Color(255, 255, 255));
        btnDivide.setBackground(new Color(90, 124, 105));
        btnDivide.setBorderPainted(false);
        btnDivide.setFont(new Font("Serif", Font.BOLD, 10));
        btnDivide.setBounds(331, 163, 74, 38);
        contentPane.add(btnDivide);

        JButton btnDerive = new JButton("derive");
        btnDerive.setForeground(new Color(255, 255, 255));
        btnDerive.setBackground(new Color(90, 124, 105));
        btnDerive.setBorderPainted(false);
        btnDerive.setFont(new Font("Serif", Font.BOLD, 10));
        btnDerive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial p;
                try {
                    p = polynomialReader.Read(getFieldFirstPol().getText());
                } catch(InvalidInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
                Polynomial result = polynomialOperations.DerivePolynomial(p);
                fieldResult.setText(result.toString());
            }
        });
        btnDerive.setBounds(331, 221, 74, 38);
        contentPane.add(btnDerive);

        JButton btnIntegrate = new JButton("integrate");
        btnIntegrate.setForeground(new Color(255, 255, 255));
        btnIntegrate.setBackground(new Color(90, 124, 105));
        btnIntegrate.setBorderPainted(false);
        btnIntegrate.setFont(new Font("Serif", Font.BOLD, 10));
        btnIntegrate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial p;
                try {
                    p = polynomialReader.Read(getFieldFirstPol().getText());
                } catch(InvalidInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
                Polynomial result = polynomialOperations.IntegratePolynomial(p);
                fieldResult.setText(result.toString());
            }
        });
        btnIntegrate.setBounds(331, 280, 74, 38);
        contentPane.add(btnIntegrate);

        JLabel textResult = new JLabel("Result");
        textResult.setFont(new Font("Serif", Font.BOLD, 13));
        textResult.setBounds(261, 355, 75, 20);
        contentPane.add(textResult);

        fieldResult = new JTextField();
        fieldResult.setBounds(172, 395, 221, 29);
        contentPane.add(fieldResult);
        fieldResult.setColumns(10);

    }
}


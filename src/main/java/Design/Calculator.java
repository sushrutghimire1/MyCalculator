package Design;

import javax.swing.*;



public class Calculator {

    private JPanel jPanel;
    private JTextField TextField;
    private JButton buttonTwo;
    private JButton buttonSeven;
    private JButton buttonMR;
    private JButton buttonFour;
    private JButton buttonFive;
    private JButton buttonOne;
    private JButton buttonEight;
    private JButton buttonMC;
    private JButton buttonSquare;
    private JButton buttonSQRT;
    private JButton buttonThree;
    private JButton buttonSix;
    private JButton buttonNine;
    private JButton buttonMPlus;
    private JButton buttonDot;
    private JButton buttonZero;
    private JButton buttonClear;
    private JButton buttonPI;
    private JButton buttonLN;
    private JButton buttonCos;
    private JButton buttonSin;
    private JButton buttonTan;
    private JButton buttonLog;
    private JButton buttonCBRT;
    private JButton buttonEquals;
    private JButton buttonMultiply;
    private JButton buttonAdd;
    private JButton buttonSubtract;
    private JButton buttonDivide;

    //final value after operation
    private double total=0.0;
    //previous calculated value
    private double total2=0.0;
    //current operator specification
    private char math_operator;


    public Calculator()
    {
        //Action Listeners for all ten buttons
        buttonOneAction(buttonOne);
        buttonOneAction(buttonTwo);
        buttonOneAction(buttonThree);
        buttonOneAction(buttonFour);
        buttonOneAction(buttonFive);
        buttonOneAction(buttonSix);
        buttonOneAction(buttonSeven);
        buttonOneAction(buttonEight);
        buttonOneAction(buttonNine);
        buttonOneAction(buttonZero);

        //Action Listeners for 4 basic operators
        buttonAddAction();
        buttonSubtractAction();
        buttonMultiplyAction(buttonMultiply, '*');
        buttonMultiplyAction(buttonDivide, '/');

        //Equals(=) Action Listener
        buttonEqualsAction();
        //Dot Action Listener
        buttonOneAction(buttonDot);
        //Clear Action Listener
        buttonClearAction(buttonClear, "");

        //Scientific Mathematical Operation Listener
        buttonSqrtAction(buttonSQRT);
        buttonClearAction(buttonPI, Double.toString(3.141592));
        buttonSquareAction();
        buttonSinAction();
        buttonCosAction(buttonCos);
        buttonTanAction();
        buttonLogAction();
        buttonLnAction();
        buttonCbrtAction();
        //Memory listener
        buttonMcAction();
        buttonMrAction();
        buttonMplusAction();
    }

    //Initialising the Frame
    public void initiate(){
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void buttonMplusAction() {
        buttonMPlus.addActionListener(e -> total=Double.parseDouble(TextField.getText()));
    }

    private void buttonMrAction() {
        buttonMR.addActionListener(e -> TextField.setText(Double.toString(total2)));
    }

    private void buttonMcAction() {
        buttonMC.addActionListener(e -> total2=0);
    }

    private void buttonCbrtAction() {
        buttonCBRT.addActionListener(e -> {
            double cbrt=Double.parseDouble(TextField.getText());
            cbrt=Math.cbrt(cbrt);
            TextField.setText(Double.toString(cbrt));
        });
    }

    private void buttonLnAction() {
        buttonLN.addActionListener(e -> {
            double log=Double.parseDouble(TextField.getText());
            log=Math.log(log);
            TextField.setText(Double.toString(log));
        });
    }

    private void buttonLogAction() {
        buttonLog.addActionListener(e -> {
            double log10=Double.parseDouble(TextField.getText());
            log10=Math.log10(log10);
            TextField.setText(Double.toString(log10));
        });
    }

    private void buttonTanAction() {
        buttonTan.addActionListener(e -> {
            double tan=Double.parseDouble(TextField.getText());
            tan=Math.tan(tan);
            TextField.setText(Double.toString(tan));
        });
    }

    private void buttonCosAction(JButton buttonCos) {
        buttonCos.addActionListener(e -> {
            double cos = Double.parseDouble(TextField.getText());
            cos = Math.cos(cos);
            TextField.setText(Double.toString(cos));
        });
    }

    private void buttonSinAction() {
        buttonSin.addActionListener(e -> {
            double sin=Double.parseDouble(TextField.getText());
            sin=Math.sin(sin);
            TextField.setText(Double.toString(sin));
        });
    }

    private void buttonSquareAction() {
        buttonSquare.addActionListener(e -> {
            double sqr=Double.parseDouble(TextField.getText());
            sqr*=sqr;
            TextField.setText(Double.toString(sqr));
        });
    }

    private void buttonSqrtAction(JButton buttonSQRT) {
        buttonSQRT.addActionListener(e -> {
            double sqrt = Double.parseDouble(TextField.getText());
            sqrt = Math.sqrt(sqrt);
            TextField.setText(Double.toString(sqrt));
        });
    }

    private void buttonClearAction(JButton buttonClear, String s) {
        buttonClear.addActionListener(e -> TextField.setText(s));
    }

    private void buttonEqualsAction() {
        buttonEquals.addActionListener(e -> {
            switch (math_operator) {
                case '+':
                total = total + Double.parseDouble(TextField.getText());
                TextField.setText(Double.toString(total));
                total2=total;
                total = 0;
                break;
                case '-':
                    total = total - Double.parseDouble(TextField.getText());
                    TextField.setText(Double.toString(total));
                    total2=total;
                    total = 0;
                    break;
                case '*':
                    total = total * Double.parseDouble(TextField.getText());
                    TextField.setText(Double.toString(total));
                    total2=total;
                    total = 0;
                    break;
                case '/':
                    total = total / Double.parseDouble(TextField.getText());
                    TextField.setText(Double.toString(total));
                    total2=total;
                    total = 0;
                    break;
            }
        });
    }

    private void buttonMultiplyAction(JButton buttonMultiply, char c) {
        buttonMultiply.addActionListener(e -> {
            math_operator = c;
            total = Double.parseDouble(TextField.getText());
            TextField.setText("");
        });
    }

    private void buttonSubtractAction() {
        buttonSubtract.addActionListener(e -> {
            math_operator='-';
            total=total-Double.parseDouble(TextField.getText());
            TextField.setText("");
        });
    }

    private void buttonAddAction() {
        buttonAdd.addActionListener(e -> {
            math_operator='+';
            total=total+Double.parseDouble(TextField.getText());
            TextField.setText("");
        });
    }

    private void buttonOneAction(JButton buttonOne) {
        buttonOne.addActionListener(e -> {

            String addText = TextField.getText() + buttonOne.getText();
            TextField.setText(addText);
        });
    }



}

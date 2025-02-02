import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorfulCalculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font font = new Font("Arial", Font.BOLD, 18);
    double num1, num2, result;
    char operator;

    Color bgColor = new Color(50, 50, 50);
    Color btnColor = new Color(70, 130, 180);
    Color textColor = Color.WHITE;

    public ColorfulCalculator() {
        frame = new JFrame("Colorful Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(bgColor);

        textField = new JTextField();
        textField.setBounds(30, 25, 320, 50);
        textField.setFont(font);
        textField.setEditable(false);
        frame.add(textField);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setBackground(btnColor);
            functionButtons[i].setForeground(textColor);
            functionButtons[i].setFocusPainted(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setBackground(Color.DARK_GRAY);
            numberButtons[i].setForeground(textColor);
            numberButtons[i].setFocusPainted(false);
        }

        panel = new JPanel();
        panel.setBounds(30, 100, 320, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(bgColor);

        panel.add(numberButtons[1]); panel.add(numberButtons[2]); panel.add(numberButtons[3]); panel.add(addButton);
        panel.add(numberButtons[4]); panel.add(numberButtons[5]); panel.add(numberButtons[6]); panel.add(subButton);
        panel.add(numberButtons[7]); panel.add(numberButtons[8]); panel.add(numberButtons[9]); panel.add(mulButton);
        panel.add(decButton); panel.add(numberButtons[0]); panel.add(equButton); panel.add(divButton);

        frame.add(panel);

        delButton.setBounds(30, 420, 150, 40);
        clrButton.setBounds(200, 420, 150, 40);
        frame.add(delButton);
        frame.add(clrButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String text = textField.getText();
            textField.setText(text.length() > 0 ? text.substring(0, text.length() - 1) : "");
        }
    }

    public static void main(String[] args) {
        new ColorfulCalculator();
    }
}

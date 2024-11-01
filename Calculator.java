import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator() {
        setTitle("2023011756 - 계산기");
        setVisible(true);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 4));
        add(new JButton("C"));
        add(new JButton("/"));
        add(new JButton("X"));
        add(new JButton("="));

        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        add(new JButton("+"));

        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("-"));

        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("0"));


    }

    public static void main(String[] args) {
        new Calculator();
    }

}

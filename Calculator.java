import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {
        setVisible(true);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Calculator();
    }

}

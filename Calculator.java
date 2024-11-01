import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Calculator extends JFrame {

    private JTextField inputSpace;
    private JPanel buttonPanel;
    private String num = "";
    private String prev_operation = "";
    private ArrayList<String> equation = new ArrayList<>();

    public Calculator() {

        // 계산기 틀 만들기
        setTitle("계산기");
        setVisible(true);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 계산 창 만들기
        inputSpace = new JTextField();
        setLayout(null);
        inputSpace.setEditable(false);
        inputSpace.setBackground(Color.WHITE);
        inputSpace.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽 정렬
        inputSpace.setFont(new Font("Arial", Font.BOLD, 20));
        inputSpace.setBounds(30, 40, 240, 40);
        add(inputSpace);

        // 버튼 패널 만들기
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 그리드
        buttonPanel.setBounds(30, 100, 240, 240);

        // 버튼 생성 및 추가
        String[] buttons = {
                "C", "÷", "+", "=",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "0"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            buttonPanel.add(button);
        }

        add(buttonPanel); // 버튼 패널을 프레임에 추가
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

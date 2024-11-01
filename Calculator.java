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
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 계산 창 만들기
        inputSpace = new JTextField();
        inputSpace.setEditable(false);
        inputSpace.setBackground(Color.WHITE);
        inputSpace.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽 정렬
        inputSpace.setFont(new Font("Arial", Font.BOLD, 20));
        add(inputSpace, BorderLayout.NORTH); // 위쪽에 배치

        // 버튼 패널 만들기
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 그리드

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

        add(buttonPanel, BorderLayout.CENTER); // 중앙에 버튼 패널 배치
    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
}

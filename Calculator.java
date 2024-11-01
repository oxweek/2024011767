import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame implements ActionListener {

    private JTextField inputSpace;
    private JPanel buttonPanel;
    private String num = "";
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
        inputSpace.setHorizontalAlignment(JTextField.RIGHT);
        inputSpace.setFont(new Font("Arial", Font.BOLD, 20));
        add(inputSpace, BorderLayout.NORTH);

        // 버튼 패널 만들기
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

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
            button.addActionListener(this); // 버튼에 이벤트 리스너 추가
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    // 버튼 클릭 이벤트 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) { // Clear
            num = "";
            equation.clear();
            inputSpace.setText("");
        } else if (command.equals("=")) { // 계산 결과
            equation.add(num);
            double result = calculate(equation);
            if (Double.isNaN(result)) {
                inputSpace.setText("0으로는 나눌 수 없습니다");
            } else {
                inputSpace.setText(String.valueOf(result));
            }
            num = "";
            equation.clear();
        } else if (command.equals("÷") || command.equals("x") || command.equals("+") || command.equals("-")) { // 연산자
            equation.add(num);
            equation.add(command);
            num = "";
        } else { // 숫자 버튼
            num += command;
            inputSpace.setText(num);
        }
    }

    // 사칙연산 계산 메서드
    private double calculate(ArrayList<String> equation) {
        double result = Double.parseDouble(equation.get(0));
        for (int i = 1; i < equation.size(); i += 2) {
            String operator = equation.get(i);
            double nextNum = Double.parseDouble(equation.get(i + 1));

            switch (operator) {
                case "+":
                    result += nextNum;
                    break;
                case "-":
                    result -= nextNum;
                    break;
                case "x":
                    result *= nextNum;
                    break;
                case "÷":
                    if (nextNum == 0) {
                        return Double.NaN; // NaN을 반환하여 0으로 나눌 수 없음 메시지를 표시
                    }
                    result /= nextNum;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
}

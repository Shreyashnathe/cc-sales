import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assignment5 extends JFrame implements ActionListener {

    JTextArea area;
    JTextField field;
    JButton btn;

    Assignment5() {

        setTitle("College Chatbot");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane sp = new JScrollPane(area);

        field = new JTextField();
        field.setFont(new Font("Arial", Font.PLAIN, 16));

        btn = new JButton("Send");
        btn.addActionListener(this);

        JPanel p = new JPanel(new BorderLayout());
        p.add(field, BorderLayout.CENTER);
        p.add(btn, BorderLayout.EAST);

        add(sp, BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);

        area.append("Chatbot : Hello! Ask me anything...\n");

        setVisible(true);
    }

    static String getResponse(String s) {

        s = s.toLowerCase();

        if (s.contains("hello") || s.contains("hi")) {
            return "Hello! How can I help you?";
        }

        if (s.contains("admission")) {
            return "Admissions are open. Visit the office.";
        }

        if (s.contains("fee")) {
            return "Fee details are available on the college website.";
        }

        if (s.contains("timing")) {
            return "College timings are 9 AM to 4 PM.";
        }

        if (s.contains("courses")) {
            return "We offer B.Tech, M.Tech and MBA programs.";
        }

        if (s.contains("bye") || s.contains("exit")) {
            return "Goodbye!";
        }

        return "Sorry, I didn't understand!";
    }

    public void actionPerformed(ActionEvent e) {

        String input = field.getText();

        if (input.trim().isEmpty()) {
            return;
        }

        area.append("You : " + input + "\n");

        String res = getResponse(input);

        area.append("Chatbot : " + res + "\n\n");

        field.setText("");

        if (input.equalsIgnoreCase("bye") ||
            input.equalsIgnoreCase("exit")) {

            JOptionPane.showMessageDialog(this,
                    "Chatbot Closed!");

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Assignment5();
    }
}
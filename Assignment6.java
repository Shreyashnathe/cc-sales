import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment6 extends JFrame implements ActionListener {

    JTextArea area;
    JTextField field;
    JButton btn;

    Assignment6() {

        setTitle("Help Desk Expert System");
        setSize(550, 550);
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

        area.append("=== Help Desk Expert System ===\n");
        area.append("Ask your problem...\n\n");

        setVisible(true);
    }

    static String ans(String q) {

        q = q.toLowerCase();

        if (q.contains("password"))
            return "Reset password using 'Forgot Password' option.";

        else if (q.contains("internet") || q.contains("wifi"))
            return "Restart router and check network cables.";

        else if (q.contains("printer"))
            return "Check printer connection and reinstall drivers.";

        else if (q.contains("slow"))
            return "Restart system and close unnecessary applications.";

        else if (q.contains("virus"))
            return "Run antivirus scan immediately.";

        else if (q.contains("login"))
            return "Verify username and password.";

        else if (q.contains("error"))
            return "Reinstall the software or contact support.";

        else if (q.contains("bye") || q.contains("exit"))
            return "Thank you for using Help Desk Expert System.";

        else
            return "Problem not found in knowledge base.";
    }

    public void actionPerformed(ActionEvent e) {

        String q = field.getText();

        if (q.trim().isEmpty()) {
            return;
        }

        area.append("User : " + q + "\n");

        String r = ans(q);

        area.append("System : " + r + "\n\n");

        field.setText("");

        if (q.equalsIgnoreCase("exit") ||
            q.equalsIgnoreCase("bye")) {

            JOptionPane.showMessageDialog(this,
                    "Closing Expert System");

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new Assignment6();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBotGUI extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    ChatBotGUI() {

        // Window settings
        setTitle("Customer Support Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input field
        inputField = new JTextField();

        // Send button
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        // Bottom panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        // Add components
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Rule-based chatbot responses
    public String getResponse(String message) {

        message = message.toLowerCase();

        if (message.contains("hello") || message.contains("hi")) {
            return "Hello! Welcome to Customer Support.";
        }

        else if (message.contains("product")) {
            return "We provide laptops, mobiles, and accessories.";
        }

        else if (message.contains("order")) {
            return "Please enter your Order ID.";
        }

        else if (message.contains("delivery")) {
            return "Delivery takes 3-5 business days.";
        }

        else if (message.contains("refund") || message.contains("return")) {
            return "Refund will be processed within 7 days.";
        }

        else if (message.contains("payment")) {
            return "We accept UPI, Credit Card, and Debit Card.";
        }

        else if (message.contains("contact")) {
            return "Contact us at support@gmail.com";
        }

        else if (message.contains("bye")) {
            return "Thank you! Have a nice day.";
        }

        else {
            return "Sorry, I didn't understand.";
        }
    }

    // Button click event
    public void actionPerformed(ActionEvent e) {

        String userText = inputField.getText();

        if (!userText.isEmpty()) {

            chatArea.append("You: " + userText + "\n");

            String botReply = getResponse(userText);

            chatArea.append("Bot: " + botReply + "\n\n");

            inputField.setText("");
        }
    }

    // Main method
    public static void main(String[] args) {
        new ChatBotGUI();
    }
}
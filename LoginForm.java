import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();
    private RoundedButton btnLogin = new RoundedButton("Login");
    private RoundedButton btnRegister = new RoundedButton("Go to Register");

    public LoginForm() {
        setTitle("User Login");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GradientPanel panel = new GradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel lblTitle = new JLabel("LOGIN");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(170, 20, 200, 30);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 90, 100, 25);
        lblUsername.setForeground(Color.WHITE);

        txtUsername.setBounds(160, 90, 200, 25);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 140, 100, 25);
        lblPassword.setForeground(Color.WHITE);

        txtPassword.setBounds(160, 140, 200, 25);

        btnLogin.setBounds(160, 190, 120, 35);
        btnRegister.setBounds(160, 240, 120, 35);
        btnRegister.setBackground(Color.GRAY);

        panel.add(lblTitle);
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnRegister);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());

            boolean found = false;
            for (User u : RegisterForm.users) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Dashboard(username);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnRegister.addActionListener(e -> {
            dispose();
            new RegisterForm();
        });
        setVisible(true);
    }
}
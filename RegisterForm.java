import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegisterForm extends JFrame {
    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();


    public static ArrayList<User> users = new ArrayList<>();

    public RegisterForm() {
        setTitle("User Registration");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GradientPanel panel = new GradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel lblTitle = new JLabel("CREATE ACCOUNT");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(110, 20, 300, 30);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 90, 100, 25);
        lblUsername.setForeground(Color.WHITE);

        txtUsername.setBounds(160, 90, 200, 25);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 140, 100, 25);
        lblPassword.setForeground(Color.WHITE);

        txtPassword.setBounds(160, 140, 200, 25);

        btnRegister.setBounds(160, 190, 120, 35);
        btnLogin.setBounds(160, 240, 120, 35);
        btnLogin.setBackground(Color.GRAY);

        panel.add(lblTitle);
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnRegister);
        panel.add(btnLogin);

        btnRegister.addActionListener(e -> registerUser());
        btnLogin.addActionListener(e -> {
            dispose();
            new LoginForm();
        });

        setVisible(true);
    }

    private void registerUser() {
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        users.add(new User(username, password));
        JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new LoginForm();
    }

    public static void main(String[] args) {
        new RegisterForm();
    }
}
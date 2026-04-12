import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Dashboard extends JFrame {

    public Dashboard(String username) {
        setTitle("Anime Glass Dashboard");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BackgroundPanel bg = new BackgroundPanel();
        bg.setLayout(null);
        setContentPane(bg);

        JPanel sidebar = new JPanel();
        sidebar.setBounds(20, 20, 200, 420);
        sidebar.setBackground(new Color(255, 255, 255, 30));
        sidebar.setLayout(null);
        bg.add(sidebar);

        JLabel user = new JLabel("Welcome, Mr. " + username);
        user.setBounds(20, 20, 180, 30);
        user.setForeground(Color.WHITE);
        user.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sidebar.add(user);

        JButton btnHome = glassButton("Home", 70);
        JButton btnProfile = glassButton("Profile", 120);
        JButton btnSettings = glassButton("Settings", 170);

        sidebar.add(btnHome);
        sidebar.add(btnProfile);
        sidebar.add(btnSettings);

        JPanel main = new JPanel();
        main.setBounds(240, 20, 520, 420);
        main.setBackground(new Color(255, 255, 255, 20));
        main.setLayout(null);
        bg.add(main);

        JLabel title = new JLabel("DASHBOARD SA GWAPO!");
        title.setBounds(140, 40, 300, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        main.add(title);

        JButton logout = new JButton("DIRI ANG LOGOUT");
        logout.setBounds(200, 300, 120, 40);
        logout.setBackground(new Color(180, 0, 255));
        logout.setForeground(Color.WHITE);
        main.add(logout);

        logout.addActionListener(e -> {
            new LoginForm().setVisible(true);
            dispose();
        });

        setVisible(true);
    }
    private JButton glassButton(String text, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(20, y, 160, 35);
        btn.setFocusPainted(false);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(255, 255, 255, 40));
        return btn;
    }

    class BackgroundPanel extends JPanel {

        Image bg;

        public BackgroundPanel() {
            try {
                bg = new ImageIcon(new URL(
                    "https://media.tenor.com/2uyENRmiUt0AAAAd/anime-aesthetic.gif"
                )).getImage();
            } catch (Exception e) {
                System.out.println("Background failed");
            }
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (bg != null) {
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String[] args) {
        new Dashboard("Admin");
    }
}
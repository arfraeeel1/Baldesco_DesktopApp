import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false);
        setBackground(new Color(30, 144, 255));
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));
        setBorderPainted(false);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g2);
        g2.dispose();
    }
}
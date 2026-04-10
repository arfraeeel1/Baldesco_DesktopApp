import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    private Color color1 = new Color(245, 245, 220); // beige
    private Color color2 = new Color(30, 144, 255);  // blue

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color2, width, height, color1);
        g2.setPaint(gp);
        g2.fillRect(0, 0, width, height);
    }
}
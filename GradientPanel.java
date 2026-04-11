import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.imageio.ImageIO;

class GradientPanel extends JPanel {

    private Image bgImage;

    public GradientPanel() {
        try {
            URL url = new URL("https://media.tenor.com/2uyENRmiUt0AAAAd/anime-aesthetic.gif"); // Sung Jin-Woo
            // URL url = new URL("https://media.tenor.com/2uyENRmiUt0AAAAd/anime-aesthetic.gif"); // Jujutsu

            bgImage = ImageIO.read(url);
            System.out.println("Anime background loaded!");
        } catch (Exception e) {
            System.out.println("Failed to load image.");
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0, 0, 0, 180));
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(new Color(120, 0, 255, 80));
        g2.fillOval(getWidth()/4, getHeight()/4, 300, 300);
    }
}
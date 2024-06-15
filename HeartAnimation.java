import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeartAnimation extends JPanel implements ActionListener {

    private int x = 0;
    private int y = 0;
    private int heartWidth = 50;
    private int heartHeight = 50;
    private Timer timer;

    public HeartAnimation() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Mengatur warna latar belakang
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Mengatur warna hati
        g2d.setColor(Color.RED);

        // Menggambar hati
        g2d.fillOval(x, y, heartWidth, heartHeight);

        // Menggambar garis
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Menggerakkan hati ke kanan sepanjang garis
        x += 1;
        if (x > getWidth()) {
            x = 0;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new HeartAnimation());
        frame.setVisible(true);
    }
}

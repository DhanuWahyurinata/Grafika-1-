import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeartBeatLine extends JPanel implements ActionListener {

    private int x = 0;
    private int y = 0;
    private int direction = 1;
    private int delay = 20;
    private Timer timer;

    public HeartBeatLine() {
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(3));

        // Draw the line
        g2d.drawLine(x, height / 2, x + 20, height / 2);

        // Draw the circle
        g2d.fillOval(x + 20, height / 2 - 10, 20, 20);

        // Draw the text
        g2d.drawString("Heart Rate: " + (int) (Math.random() * 100), 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += direction;
        if (x > getWidth() - 40 || x < 0) {
            direction *= -1;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart Beat Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new HeartBeatLine());
        frame.setVisible(true);
    }
}

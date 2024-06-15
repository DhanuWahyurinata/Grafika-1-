import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SolarSystemAnimation extends Frame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static final int SUN_RADIUS = 30;
    private static final int PLANET_RADIUS = 10;
    private static final int ORBIT_RADIUS = 200;
    private static final double ANGULAR_SPEED = 2 * Math.PI / 365;

    private double planetAngle = 0;

    public SolarSystemAnimation() {
        setTitle("Solar System Animation");
        setSize(WIDTH, HEIGHT);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void paint(Graphics g) {
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        // Draw Sun
        g.setColor(Color.YELLOW);
        g.fillOval(centerX - SUN_RADIUS, centerY - SUN_RADIUS, 2 * SUN_RADIUS, 2 * SUN_RADIUS);

        // Calculate position of the planet
        int planetX = centerX + (int) (ORBIT_RADIUS * Math.cos(planetAngle));
        int planetY = centerY - (int) (ORBIT_RADIUS * Math.sin(planetAngle));

        // Draw Planet
        g.setColor(Color.BLUE);
        g.fillOval(planetX - PLANET_RADIUS, planetY - PLANET_RADIUS, 2 * PLANET_RADIUS, 2 * PLANET_RADIUS);

        // Update planet angle for next frame
        planetAngle += ANGULAR_SPEED;
        if (planetAngle >= 2 * Math.PI) {
            planetAngle -= 2 * Math.PI;
        }
    }

    public static void main(String[] args) {
        SolarSystemAnimation animation = new SolarSystemAnimation();
        animation.animate();
    }

    private void animate() {
        while (true) {
            repaint();
            try {
                Thread.sleep(20); // Adjust speed of animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

import java.awt.*;
import java.awt.geom.*;

public class RoundedRectangleExample extends Frame {
    private int windowHeight;

    RoundedRectangleExample(int height) {
        addWindowListener(new MyFinishWindow());
        windowHeight = height;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(40, windowHeight - 50);
        yUp.preConcatenate(translate);

        g2d.transform(yUp);
        g2d.setStroke(new BasicStroke(3.0f));

        // Generate and draw a rounded rectangle
        RoundRectangle2D.Double roundedRect = new RoundRectangle2D.Double(100, 20, 100, 60, 20, 20);
        g2d.draw(roundedRect);

        g2d.setStroke(new BasicStroke(1.0f));
    }

    public static void main(String[] argv) {
        int height = 300;
        RoundedRectangleExample f = new RoundedRectangleExample(height);
        f.setTitle("Example: rounded rectangle");
        f.setSize(300, height);
        f.setVisible(true);
    }
}

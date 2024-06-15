import java.awt.BasicStroke;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.EventQueue;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.geom.AffineTransform;
    import java.awt.geom.Path2D;
    import javax.swing.Timer;

    import javax.swing.JFrame;
    import javax.swing.JPanel;
    public class HelloCurves {
        public HelloCurves() {
            JFrame jf = new JFrame("HelloCurves");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel jp = new MyJPanel();
            jf.add(jp);
            jf.pack();
            jf.setResizable(false);
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        }
        public static void main(String[] args) {
            EventQueue.invokeLater(HelloCurves::new);
        }
        class MyJPanel extends JPanel {
            private static final long serialVersionUID = 1L;
            public MyJPanel() {
                super();
                setPreferredSize(new Dimension(800, 600));
                setBackground(new Color(200, 200, 255));
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                AffineTransform gat = new AffineTransform();
                gat.scale(1.0, -1.0);
                gat.translate(getWidth() / 2.0, -getHeight() / 2.0);
                g2d.transform(gat);
                Path2D p2d = new Path2D.Double();

//Larger First Heart
    //            p2d.moveTo(0.0, -250.0);
    //            p2d.curveTo(-350.0, -125.0,-350.0, 375.0, 0, 175.0);
    //            p2d.curveTo(350.0, 375.0,350.0, -125.0, 0, -250.0);

//Smaller Second Heart
                p2d.moveTo(0.0, -150.0);
                p2d.curveTo(-200.0, -25.0,-200.0, 225.0, 0, 100.0);
                p2d.moveTo(0.0, -150.0);
                p2d.curveTo(200.0, -25.0,205.0, 235.0, 0, 100.0);

                g2d.setPaint(Color.PINK);
                g2d.fill(p2d);
                g2d.setStroke(new BasicStroke(5.0f));
                g2d.setPaint(Color.BLACK);
                g2d.draw(p2d);
                g2d.dispose();
            }
        }
    }
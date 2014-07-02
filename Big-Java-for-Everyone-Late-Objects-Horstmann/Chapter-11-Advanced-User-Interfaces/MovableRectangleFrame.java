

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MovableRectangleFrame extends JFrame {
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    private MovableRectangleComponent scene;
    
    public MovableRectangleFrame() {
        this.scene = new MovableRectangleComponent();
        this.scene.addMouseListener(new MousePressListener());
        super.add(this.scene);
        super.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    @SuppressWarnings("serial")
    class MovableRectangleComponent extends JComponent {
        private static final int RECTANGLE_WIDTH = 20;
        private static final int RECTANGLE_HEIGHT = 30;
        private int xLeft;
        private int yTop;

        public MovableRectangleComponent() {
            this.xLeft = 0;
            this.yTop = 0;
        }

        public void paintComponent(Graphics g) {
            g.fillRect(xLeft, yTop, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        }

        public void moveRectangle(int x, int y) {
            xLeft = x;
            yTop = y;
            repaint();
        }
    }

    class MousePressListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            scene.moveRectangle(e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    
    public static void main(String[] args) {
        JFrame testFrame = new MovableRectangleFrame();
    }
}

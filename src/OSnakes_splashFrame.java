import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

@SuppressWarnings("ALL")
public class OSnakes_splashFrame extends JFrame implements MouseListener {

    JLabel OSnakes_bg;

    OSnakes_splashFrame() throws InterruptedException {
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        URL iconURL = getClass().getResource("Resources/titleIcon.png");
        assert iconURL != null;
        ImageIcon titleIcon = new ImageIcon(iconURL);

        OSnakes_bg = new JLabel(new ImageIcon(getClass().getResource("Resources/OSnakes_bg.gif")));
        OSnakes_bg.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        OSnakes_bg.setVerticalAlignment(JLabel.CENTER);
        OSnakes_bg.setHorizontalAlignment(JLabel.CENTER);
        OSnakes_bg.addMouseListener(this);

        this.setTitle("Let OS Play");
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(titleIcon.getImage());
        this.getContentPane().setBackground(new Color(6,19,44));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().add(OSnakes_bg);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new OSnakes_MainFrame();
        this.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}

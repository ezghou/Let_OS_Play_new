import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

@SuppressWarnings("ALL")
public class OSnakes_MainFrame extends JFrame implements MouseListener {
    private final JButton startButton;
    private final JButton howButton;
    private final JButton homeButton;

    OSnakes_MainFrame() {
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        URL iconURL = getClass().getResource("Resources/titleIcon.png");
        assert iconURL != null;
        ImageIcon titleIcon = new ImageIcon(iconURL);

        JLabel mainLogo = new JLabel(new ImageIcon(getClass().getResource("Resources/OSnakes_mainLogo.png")), JLabel.CENTER);
        mainLogo.setBounds(230, 20, 600, 230);
        mainLogo.setVisible(true);

        startButton = new JButton();
        startButton.setText("START");
        startButton.setForeground(new Color(0, 128, 55));
        startButton.setFont(new Font("Verdana", Font.BOLD, 50));
        startButton.setHorizontalAlignment(SwingConstants.CENTER);
        startButton.setVerticalAlignment(SwingConstants.CENTER);
        startButton.setBounds(405, 300, 250, 100);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(this);

        howButton = new JButton();
        howButton.setText("HOW TO PLAY");
        howButton.setForeground(new Color(0, 128, 55));
        howButton.setFont(new Font("Verdana", Font.BOLD, 50));
        howButton.setHorizontalAlignment(SwingConstants.CENTER);
        howButton.setVerticalAlignment(SwingConstants.CENTER);
        howButton.setBounds(280, 375, 500, 100);
        howButton.setContentAreaFilled(false);
        howButton.setBorderPainted(false);
        howButton.setFocusPainted(false);
        howButton.addMouseListener(this);

        homeButton = new JButton();
        homeButton.setText("HOME");
        homeButton.setForeground(new Color(0, 128, 55));
        homeButton.setFont(new Font("Verdana", Font.BOLD, 50));
        homeButton.setHorizontalAlignment(SwingConstants.CENTER);
        homeButton.setVerticalAlignment(SwingConstants.CENTER);
        homeButton.setBounds(405, 450, 250, 100);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.addMouseListener(this);

        this.setTitle("Let OS Play");
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLayout(null);
        this.setResizable(false);
        this.setIconImage(titleIcon.getImage());
        this.getContentPane().setBackground(new Color(3,10,33));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.getContentPane().add(mainLogo);
        this.getContentPane().add(startButton);
        this.getContentPane().add(howButton);
        this.getContentPane().add(homeButton);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==startButton){
            try {
                new OSnakes_questionFrame();
            } catch (URISyntaxException | FileNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        if(e.getSource()==howButton){
            new OSnakes_howFrame();
            this.dispose();
        }
        if(e.getSource()==homeButton){
            new MainGameFrame(false);
            this.dispose();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==startButton){
            startButton.setFont(new Font("Verdana", Font.BOLD, 55));
        }
        if(e.getSource()==howButton){
            howButton.setFont(new Font("Verdana", Font.BOLD, 55));
        }
        if(e.getSource()==homeButton){
            homeButton.setFont(new Font("Verdana", Font.BOLD, 55));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==startButton){
            startButton.setFont(new Font("Verdana", Font.BOLD, 50));
        }
        if(e.getSource()==howButton){
            howButton.setFont(new Font("Verdana", Font.BOLD, 50));
        }
        if(e.getSource()==homeButton){
            homeButton.setFont(new Font("Verdana", Font.BOLD, 50));
        }
    }
}

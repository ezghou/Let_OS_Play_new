package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

@SuppressWarnings("ALL")
public class OSnakes_howFrame extends JFrame implements MouseListener {
    JLabel mainLogo;
    JButton backButton;
    Sounds bgMusic;

    OSnakes_howFrame(Sounds bgm) {
        bgMusic = bgm;
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        URL iconURL = getClass().getResource("/Resources/titleIcon.png");
        assert iconURL != null;
        ImageIcon titleIcon = new ImageIcon(iconURL);

        mainLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/OSnakes_howFrame.png")));
        mainLogo.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        mainLogo.setLocation(0, -50);
        mainLogo.setVisible(true);

        backButton = new JButton();
        backButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_backButton.png")));
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setBounds(870, 530, 125, 70);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(this);

        this.setTitle("Let OS Play");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLayout(null);
        this.setResizable(false);
        this.setIconImage(titleIcon.getImage());
        this.getContentPane().setBackground(new Color(3,10,33));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.getContentPane().add(mainLogo);
        this.getContentPane().add(backButton);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new OSnakes_MainFrame(bgMusic);
        this.dispose();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        new OSnakes_MainFrame(bgMusic);
        this.dispose();
    }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) {
        backButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_backButtonHL.png")));
    }
    @Override
    public void mouseExited(MouseEvent e) {
        backButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_backButton.png")));
    }
}

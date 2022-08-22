package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class Lockdown_HowToPlayFrame extends JFrame implements MouseListener{

@SuppressWarnings("ALL")
    JLabel mainLogo;
    JButton backButton;
    Sounds click = new Sounds();

    Lockdown_HowToPlayFrame() {
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        URL iconURL = getClass().getResource("/Resources/titleIcon.png");
        assert iconURL != null;
        ImageIcon titleIcon = new ImageIcon(iconURL);

        mainLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/Lockdown_HowToPlayImage.png")));
        mainLogo.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        mainLogo.setLocation(0, 0);
        mainLogo.setVisible(true);

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(9, 27, 12));
        backButton.setFont(new Font("Cambria", Font.BOLD, 25));
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setBounds(10, 550, 100, 40);
        backButton.setContentAreaFilled(true);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),4));
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

        this.getContentPane().add(backButton);
        this.getContentPane().add(mainLogo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        click.soundChoice(4);
        new Lockdown_MainFrame();
        this.dispose();
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==backButton){
            backButton.setFont(new Font("Cambria", Font.BOLD, 28));
            backButton.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),5));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==backButton){
            backButton.setFont(new Font("Cambria", Font.BOLD, 25));
            backButton.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),4));
        }
    }
}

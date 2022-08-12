package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@SuppressWarnings("ALL")
public class MainGameFrame extends JFrame implements ActionListener {
    static boolean clickedLockdown = false;
    Lockdown_GamePanel gamePanel = new Lockdown_GamePanel();
    JLabel logo;
    JButton selectLadder;
    JButton selectLockdown;
    JButton selectOSNAKES;

    MainGameFrame(boolean checkLockdown) {
        clickedLockdown = checkLockdown;
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;

        if(clickedLockdown == false) {
            URL iconURL = getClass().getResource("/Resources/titleIcon.png");
            assert iconURL != null;
            ImageIcon titleIcon = new ImageIcon(iconURL);

            logo = new JLabel(new ImageIcon(getClass().getResource("/Resources/LogoSmall.png")));
            logo.setVerticalAlignment(JLabel.CENTER);
            logo.setHorizontalAlignment(JLabel.CENTER);
            logo.setBounds(230, 0, 600, 120);
            logo.setForeground(Color.WHITE);
            logo.setVisible(true);

            selectLadder = new JButton();
            selectLadder.setIcon(new ImageIcon(getClass().getResource("/Resources/selectLadder.png")));
            selectLadder.setHorizontalAlignment(SwingConstants.CENTER);
            selectLadder.setVerticalAlignment(SwingConstants.CENTER);
            selectLadder.setBounds((int) Math.round(SCREEN_WIDTH * 0.1744791), (int) Math.round(SCREEN_HEIGHT * 0.20254629), 300, 200);
            selectLadder.addActionListener(this);

            selectLockdown = new JButton();
            selectLockdown.setIcon(new ImageIcon(getClass().getResource("/Resources/selectLockdown.png")));
            selectLockdown.setHorizontalAlignment(SwingConstants.CENTER);
            selectLockdown.setVerticalAlignment(SwingConstants.CENTER);
            selectLockdown.setBounds((int) Math.round(SCREEN_WIDTH * 0.5651041666), (int) Math.round(SCREEN_HEIGHT * 0.20254629), 300, 200);
            selectLockdown.addActionListener(this);

            selectOSNAKES = new JButton();
            selectOSNAKES.setIcon(new ImageIcon(getClass().getResource("/Resources/selectOSNAKES.png")));
            selectOSNAKES.setHorizontalAlignment(SwingConstants.CENTER);
            selectOSNAKES.setVerticalAlignment(SwingConstants.CENTER);
            selectOSNAKES.setBounds((int) Math.round(SCREEN_WIDTH * 0.3697916666666), (int) Math.round(SCREEN_HEIGHT * 0.5787037), 300, 200);
            selectOSNAKES.addActionListener(this);

            this.setTitle("Let OS Play");
            this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setResizable(false);
            this.setIconImage(titleIcon.getImage());
            this.getContentPane().setBackground(new Color(6, 19, 44));
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            System.out.println("Lockdown accessed? " + clickedLockdown);


            this.getContentPane().add(logo);
            this.getContentPane().add(selectLadder);
            this.getContentPane().add(selectLockdown);
            this.getContentPane().add(selectOSNAKES);
        }

        if(clickedLockdown == true){
            URL iconURL = getClass().getResource("/Resources/titleIcon.png");
            ImageIcon titleIcon = new ImageIcon(iconURL);

            this.setTitle("Let OS Play");
            this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setIconImage(titleIcon.getImage());
//        this.getContentPane().setBackground(new Color(6,19,44));
            this.setLocationRelativeTo(null); //Center frame in screen
//            this.setLayout(null);
            this.setVisible(true);

            this.add(gamePanel);
            gamePanel.startGameThread();
        }


    }


    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
//        new SplashScreen();
        new main.Lockdown_MainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectLadder) {
            try {
                System.out.println("Lockdown accessed? "+clickedLockdown);
                new TheLadder_splashFrame();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        if (e.getSource() == selectLockdown) {
            try {
                clickedLockdown = true;
                System.out.println("Lockdown accessed? "+clickedLockdown);
                new Lockdown_SplashScreen();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        if (e.getSource() == selectOSNAKES) {
            try {
                System.out.println("Lockdown accessed? "+clickedLockdown);
                new OSnakes_splashFrame();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
    }
}


package main;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("ALL")
public class SplashScreen extends JFrame {

    SplashScreen() throws InterruptedException {
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/Resources/Logo.gif")));
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setHorizontalAlignment(JLabel.CENTER);

        this.setTitle("Let OS Play");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/titleIcon.png")).getImage());
        this.getContentPane().setBackground(new Color(6, 19, 44));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.getContentPane().add(logo);

        Thread.sleep(3000);
        new MainGameFrame();
        this.dispose();
    }
}

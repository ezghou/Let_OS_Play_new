import javax.management.monitor.GaugeMonitor;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Lockdown_GameFrame extends JFrame{

    int SCREEN_WIDTH = 1070;
    int SCREEN_HEIGHT = 695;
    Lockdown_GamePanel gamePanel = new Lockdown_GamePanel();

    Lockdown_GameFrame(){

        URL iconURL = getClass().getResource("Resources/titleIcon.png");
        ImageIcon titleIcon = new ImageIcon(iconURL);

        this.setTitle("Let OS Play");
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(titleIcon.getImage());
//        this.getContentPane().setBackground(new Color(6,19,44));
        this.setLocationRelativeTo(null); //Center frame in screen
        this.setLayout(null);
        this.setVisible(true);

        this.add(gamePanel);
    }

}


import javax.management.monitor.GaugeMonitor;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Lockdown_GameFrame extends JFrame{

    int SCREEN_WIDTH = 1260;
    int SCREEN_HEIGHT = 760;
    Lockdown_GamePanel gamePanel = new Lockdown_GamePanel();

    private final JLabel mainLogo;
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
        this.setVisible(true);

        mainLogo = new JLabel(new ImageIcon(getClass().getResource("Resources/Lockdown_Lawn.png")));
        mainLogo.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        mainLogo.setVerticalAlignment(JLabel.VERTICAL);
        mainLogo.setHorizontalAlignment(JLabel.HORIZONTAL);
        mainLogo.setVisible(true);



        this.add(mainLogo);
        this.add(gamePanel);
    }

}


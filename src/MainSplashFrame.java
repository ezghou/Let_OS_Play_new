import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@SuppressWarnings("ALL")
public class MainSplashFrame extends JFrame{

    MainSplashFrame() throws InterruptedException {
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        URL iconURL = getClass().getResource("Resources/titleIcon.png");
        ImageIcon titleIcon = new ImageIcon(iconURL);

        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("Resources/Logo.gif")));
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setHorizontalAlignment(JLabel.CENTER);

        this.setTitle("Let OS Play");
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(titleIcon.getImage());
        this.getContentPane().setBackground(new Color(6,19,44));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.getContentPane().add(logo);

        Thread.sleep(3000);
        new MainFrame();
        this.dispose();
    }

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        //new MainSplashFrame();
        //new TheLadder_Quiz();
        new Lockdown_MainFrame();

    }
}

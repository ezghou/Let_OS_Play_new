import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class Lockdown_InfectedFrame extends JFrame implements MouseListener{
        JLabel mainLogo;
        JButton backButton;
        JButton Home;
        JTextField Score;
        JTextField Congrats;

    Lockdown_InfectedFrame(int score) {
            int SCREEN_WIDTH = 1060;
            int SCREEN_HEIGHT = 660;
            URL iconURL = getClass().getResource("Resources/titleIcon.png");
            assert iconURL != null;
            ImageIcon titleIcon = new ImageIcon(iconURL);

            mainLogo = new JLabel(new ImageIcon(getClass().getResource("Resources/Lockdown_InfectedFrame.png")));
            mainLogo.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            mainLogo.setLocation(0, 0);
            mainLogo.setVisible(true);

            backButton = new JButton();
            backButton.setText("Back");
            backButton.setForeground(new Color(230, 244, 251));
            backButton.setBackground(new Color(9, 27, 12));
            backButton.setFont(new Font("Cambria", Font.BOLD, 20));
            backButton.setHorizontalAlignment(SwingConstants.CENTER);
            backButton.setVerticalAlignment(SwingConstants.CENTER);
            backButton.setBounds(40, 550, 150, 40);
            backButton.setFocusable(false);
            backButton.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),4));
            backButton.addMouseListener(this);

            Home = new JButton();
            Home.setText("Home");
            Home.setForeground(new Color(230, 244, 251));
            Home.setBackground(new Color(9, 27, 12));
            Home.setFont(new Font("Cambria", Font.BOLD, 20));
            Home.setHorizontalAlignment(SwingConstants.CENTER);
            Home.setVerticalAlignment(SwingConstants.CENTER);
            Home.setBounds(870, 550, 150, 40);
            Home.setFocusable(false);
            Home.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),4));
            Home.addMouseListener(this);

            Score = new JTextField("Score: " + score + "/30");
            Score.setBounds(130, 370, 800, 35);
            Score.setFont(new Font("Cambria", Font.BOLD, 40));
            Score.setHorizontalAlignment(SwingConstants.CENTER);
            Score.setOpaque(false);
            Score.setForeground(new Color(255, 0, 0));
            Score.setBorder(null);

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
            this.getContentPane().add(Home);
            this.getContentPane().add(Score);
            this.getContentPane().add(mainLogo);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == backButton){
                new Lockdown_MainFrame();
                this.dispose();
            }
            if(e.getSource() == Home){
                new MainFrame();
                this.dispose();
            }
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
        if(e.getSource()==Home){
            Home.setFont(new Font("Cambria", Font.BOLD, 28));
            Home.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),5));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==backButton){
            backButton.setFont(new Font("Cambria", Font.BOLD, 25));
            backButton.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),4));
        }
        if(e.getSource()==Home){
            Home.setFont(new Font("Cambria", Font.BOLD, 25));
            Home.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),4));
        }
    }
    }


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

    @SuppressWarnings("ALL")
    public class Lockdown_MainFrame extends JFrame implements MouseListener {

        private final JButton Play;
        private final JButton HowToPlayButton;
        private final JButton Exit;
        private final JLabel mainLogo;

        Lockdown_MainFrame() {
            int SCREEN_WIDTH = 1060;
            int SCREEN_HEIGHT = 660;
            URL iconURL = getClass().getResource("Resources/titleIcon.png");
            assert iconURL != null;
            ImageIcon titleIcon = new ImageIcon(iconURL);

            mainLogo = new JLabel(new ImageIcon(getClass().getResource("Resources/Lockdown_Splashscreen.png")));
            mainLogo.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            mainLogo.setVerticalAlignment(JLabel.CENTER);
            mainLogo.setHorizontalAlignment(JLabel.CENTER);
            mainLogo.setVisible(true);

            Play = new JButton();
            Play.setText("Play");
            Play.setForeground(new Color(230, 244, 251));
            Play.setBackground(new Color(17, 71, 90));
            Play.setFont(new Font("Cambria", Font.BOLD, 25));
            Play.setHorizontalAlignment(SwingConstants.CENTER);
            Play.setVerticalAlignment(SwingConstants.CENTER);
            Play.setBounds(450, 228, 190, 55);
            Play.setContentAreaFilled(false);
            Play.setFocusable(false);
            Play.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            Play.addMouseListener(this);

            HowToPlayButton = new JButton();
            HowToPlayButton.setText("How to Play");
            HowToPlayButton.setForeground(new Color(230, 244, 251));
            HowToPlayButton.setBackground(new Color(17, 71, 90));
            HowToPlayButton.setFont(new Font("Cambria", Font.BOLD, 25));
            HowToPlayButton.setHorizontalAlignment(SwingConstants.CENTER);
            HowToPlayButton.setVerticalAlignment(SwingConstants.CENTER);
            HowToPlayButton.setBounds(450, 303, 190, 55);
            HowToPlayButton.setContentAreaFilled(false);
            HowToPlayButton.setFocusable(false);
            HowToPlayButton.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            HowToPlayButton.addMouseListener(this);

            Exit = new JButton();
            Exit.setText("Home");
            Exit.setForeground(new Color(230, 244, 251));
            Exit.setBackground(new Color(17, 71, 90));
            Exit.setFont(new Font("Cambria", Font.BOLD, 25));
            Exit.setHorizontalAlignment(SwingConstants.CENTER);
            Exit.setVerticalAlignment(SwingConstants.CENTER);
            Exit.setBounds(450, 378, 190, 55);
            Exit.setContentAreaFilled(false);
            Exit.setFocusable(false);
            Exit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            Exit.addMouseListener(this);

            this.setTitle("Let OS Play");
            this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            this.setLayout(null);
            this.setResizable(false);
            this.setIconImage(titleIcon.getImage());
            this.getContentPane().setBackground(new Color(3,10,33));
            this.setLocationRelativeTo(null);
            this.setVisible(true);

            this.getContentPane().add(Play);
            this.getContentPane().add(HowToPlayButton);
            this.getContentPane().add(Exit);
            this.getContentPane().add(mainLogo);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource()==Play){
                new TheLadder_ApplicationForm();
                this.dispose();
            }
            if(e.getSource()==HowToPlayButton){
                new TheLadder_HowToPlayFrame();
                this.dispose();
            }
            if(e.getSource()==Exit){
                new MainFrame();
                this.dispose();
            }


        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {

            if(e.getSource()==Play){
                Play.setFont(new Font("Cambria", Font.BOLD, 30));
                Play.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),5));
            }
            if(e.getSource()==HowToPlayButton){
                HowToPlayButton.setFont(new Font("Cambria", Font.BOLD, 30));
                HowToPlayButton.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),5));
            }

            if(e.getSource()==Exit){
                Exit.setFont(new Font("Cambria", Font.BOLD, 30));
                Exit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),5));
            }


        }
        @Override
        public void mouseExited(MouseEvent e) {

            if(e.getSource()==Play){
                Play.setFont(new Font("Cambria", Font.BOLD, 25));
                Play.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            }
            if(e.getSource()==HowToPlayButton){
                HowToPlayButton.setFont(new Font("Cambria", Font.BOLD, 25));
                HowToPlayButton.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            }

            if(e.getSource()==Exit){
                Exit.setFont(new Font("Cambria", Font.BOLD, 25));
                Exit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            }


        }
    }
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

    @SuppressWarnings("ALL")
    public class TheLadder_WinFrame extends JFrame implements MouseListener {
        JLabel mainLogo;
        JButton backButton;
        JButton Home;
        JTextField Score;
        JTextField Congrats;

        TheLadder_WinFrame(int score) {
            int SCREEN_WIDTH = 1060;
            int SCREEN_HEIGHT = 660;
            URL iconURL = getClass().getResource("/Resources/titleIcon.png");
            assert iconURL != null;
            ImageIcon titleIcon = new ImageIcon(iconURL);

            mainLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/TheLadder_WinFrame.png")));
            mainLogo.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            mainLogo.setLocation(0, 0);
            mainLogo.setVisible(true);

            backButton = new JButton();
            backButton.setText("Back");
            backButton.setForeground(new Color(230, 244, 251));
            backButton.setBackground(new Color(17, 71, 90));
            backButton.setFont(new Font("Cambria", Font.BOLD, 20));
            backButton.setHorizontalAlignment(SwingConstants.CENTER);
            backButton.setVerticalAlignment(SwingConstants.CENTER);
            backButton.setBounds(40, 550, 150, 40);
            backButton.setContentAreaFilled(false);
            backButton.setFocusable(false);
            backButton.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            backButton.addMouseListener(this);

            Home = new JButton();
            Home.setText("Home");
            Home.setForeground(new Color(230, 244, 251));
            Home.setBackground(new Color(17, 71, 90));
            Home.setFont(new Font("Cambria", Font.BOLD, 20));
            Home.setHorizontalAlignment(SwingConstants.CENTER);
            Home.setVerticalAlignment(SwingConstants.CENTER);
            Home.setBounds(870, 550, 150, 40);
            Home.setContentAreaFilled(false);
            Home.setFocusable(false);
            Home.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            Home.addMouseListener(this);

            Score = new JTextField("Score: " + score + "/30");
            Score.setBounds(300, 207, 800, 35);
            Score.setFont(new Font("Cambria", Font.BOLD, 40));
            Score.setHorizontalAlignment(SwingConstants.LEFT);
            Score.setOpaque(false);
            Score.setForeground(new Color(230, 244, 251));
            Score.setBorder(null);

            Congrats = new JTextField("YOU ARE NOW PROMOTED AS A CEO!");
            Congrats.setBounds(300, 315, 800, 35);
            Congrats.setFont(new Font("Cambria", Font.BOLD, 30));
            Congrats.setHorizontalAlignment(SwingConstants.LEFT);
            Congrats.setOpaque(false);
            Congrats.setForeground(new Color(230, 244, 251));
            Congrats.setBorder(null);

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
            this.getContentPane().add(Congrats);
            this.getContentPane().add(Score);
            this.getContentPane().add(mainLogo);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == backButton){
                new TheLadder_MainFrame();
                this.dispose();
            }
            if(e.getSource() == Home){
                new MainGameFrame(false);
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
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }




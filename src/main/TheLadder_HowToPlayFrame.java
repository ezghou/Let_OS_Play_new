package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

    @SuppressWarnings("ALL")
    public class TheLadder_HowToPlayFrame extends JFrame implements MouseListener {
        JLabel mainLogo;
        JButton backButton;
        Sounds buttonClick = new Sounds();

        TheLadder_HowToPlayFrame() {
            int SCREEN_WIDTH = 1060;
            int SCREEN_HEIGHT = 660;
            URL iconURL = getClass().getResource("/Resources/titleIcon.png");
            assert iconURL != null;
            ImageIcon titleIcon = new ImageIcon(iconURL);

            mainLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/TheLadder_HowToPlay.png")));
            mainLogo.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            mainLogo.setLocation(0, 0);
            mainLogo.setVisible(true);

            backButton = new JButton();
            backButton.setText("Back");
            backButton.setForeground(new Color(230, 244, 251));
            backButton.setBackground(new Color(17, 71, 90));
            backButton.setFont(new Font("Cambria", Font.BOLD, 25));
            backButton.setHorizontalAlignment(SwingConstants.CENTER);
            backButton.setVerticalAlignment(SwingConstants.CENTER);
            backButton.setBounds(50, 550, 100, 40);
            backButton.setContentAreaFilled(false);
            backButton.setFocusable(false);
            backButton.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            //backButton.setFocusPainted(false);
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
            buttonClick.soundChoice(4);
            MainGameFrame.theLadder_mainFrame.setVisible(true);
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
                backButton.setFont(new Font("Cambria", Font.BOLD, 30));
                backButton.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),5));
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==backButton){
                backButton.setFont(new Font("Cambria", Font.BOLD, 25));
                backButton.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            }
        }
    }


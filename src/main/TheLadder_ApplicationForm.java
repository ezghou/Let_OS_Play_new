package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

    @SuppressWarnings("ALL")
    public class TheLadder_ApplicationForm extends JFrame implements MouseListener{

        private final JLabel mainLogo;
        private final JButton Back;
        private final JButton Submit;
        private final JTextField EnterName;
        private final JTextField EnterAge;
        private final JTextField EnterAddress;

        TheLadder_ApplicationForm() {
            int SCREEN_WIDTH = 1060;
            int SCREEN_HEIGHT = 660;
            URL iconURL = getClass().getResource("/Resources/titleIcon.png");
            assert iconURL != null;
            ImageIcon titleIcon = new ImageIcon(iconURL);

            mainLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/TheLadder_ApplicationForm.png")), JLabel.CENTER);
            mainLogo.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            mainLogo.setVerticalAlignment(JLabel.CENTER);
            mainLogo.setHorizontalAlignment(JLabel.CENTER);
            mainLogo.setLocation(0, -30);
            mainLogo.setVisible(true);

            Back = new JButton();
            Back.setText("Back");
            Back.setForeground(new Color(230, 244, 251));
            Back.setBackground(new Color(17, 71, 90));
            Back.setFont(new Font("Cambria", Font.BOLD, 25));
            Back.setHorizontalAlignment(SwingConstants.CENTER);
            Back.setVerticalAlignment(SwingConstants.CENTER);
            Back.setBounds(50, 550, 140, 40);
            Back.setContentAreaFilled(false);
            Back.setFocusable(false);
            Back.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            //Back.setFocusPainted(false);
            Back.addMouseListener(this);


            Submit = new JButton();
            Submit.setText("Submit");
            Submit.setForeground(new Color(230, 244, 251));
            Submit.setBackground(new Color(17, 71, 90));
            Submit.setFont(new Font("Cambria", Font.BOLD, 25));
            Submit.setHorizontalAlignment(SwingConstants.CENTER);
            Submit.setVerticalAlignment(SwingConstants.CENTER);
            Submit.setBounds(440, 335, 180, 40);
            Submit.setContentAreaFilled(false);
            Submit.setFocusable(false);
            Submit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            //Submit.setFocusPainted(false);
            Submit.addMouseListener(this);

            EnterName = new JTextField("Enter your Name");
            EnterName.setBounds(260, 140, 540, 40);
            EnterName.setFont(new Font("Cambria", Font.BOLD, 22));
            EnterName.setOpaque(false);
            EnterName.setForeground(new Color(230, 244, 251));
            EnterName.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),1));

            EnterAge = new JTextField("Enter your Age");
            EnterAge.setBounds(260, 195, 540, 40);
            EnterAge.setFont(new Font("Cambria", Font.BOLD, 22));
            EnterAge.setOpaque(false);
            EnterAge.setForeground(new Color(230, 244, 251));
            EnterAge.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),1));

            EnterAddress = new JTextField("Enter your Address");
            EnterAddress.setBounds(260, 250, 540, 40);
            EnterAddress.setFont(new Font("Cambria", Font.BOLD, 22));
            EnterAddress.setOpaque(false);
            EnterAddress.setForeground(new Color(230, 244, 251));
            EnterAddress.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),1));

            this.setTitle("Let OS Play");
            this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            this.setLayout(null);
            this.setResizable(false);
            this.setIconImage(titleIcon.getImage());
            this.getContentPane().setBackground(new Color(3,10,33));
            this.setLocationRelativeTo(null);
            this.setVisible(true);

            this.getContentPane().add(EnterName);
            this.getContentPane().add(EnterAge);
            this.getContentPane().add(EnterAddress);
            this.getContentPane().add(Back);
            this.getContentPane().add(Submit);
            this.getContentPane().add(mainLogo);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource()==Back){
                new TheLadder_MainFrame();
                this.dispose();
            }

            if(e.getSource() == Submit){
                try {
                    new TheLadder_Quiz();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                this.dispose();
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource()==Back){
                Back.setFont(new Font("Cambria", Font.BOLD, 30));
                Back.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),5));
            }

            if(e.getSource()==Submit){
                Submit.setFont(new Font("Cambria", Font.BOLD, 30));
                Submit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),5));
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==Back){
                Back.setFont(new Font("Cambria", Font.BOLD, 25));
                Back.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            }

            if(e.getSource()==Submit){
                Submit.setFont(new Font("Cambria", Font.BOLD, 25));
                Submit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
            }
        }
    }
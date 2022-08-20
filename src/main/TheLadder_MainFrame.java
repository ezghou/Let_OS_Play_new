package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
public class TheLadder_MainFrame extends JFrame implements MouseListener {
    
    private final JButton ApplyNow;
    private final JButton HowToPlayButton;
    private final JButton Exit;
    Sounds music = new Sounds();
    Sounds buttonClick = new Sounds();


    TheLadder_MainFrame() throws InterruptedException {
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        URL iconURL = getClass().getResource("/Resources/titleIcon.png");
        assert iconURL != null;
        ImageIcon titleIcon = new ImageIcon(iconURL);

        JLabel mainLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/TheLadder_MainFrame.png")), JLabel.CENTER);
        mainLogo.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        mainLogo.setVerticalAlignment(JLabel.CENTER);
        mainLogo.setHorizontalAlignment(JLabel.CENTER);
        mainLogo.setVisible(true);

        ApplyNow = new JButton();
        ApplyNow.setText("Apply Now");
        ApplyNow.setForeground(new Color(230, 244, 251));
        ApplyNow.setBackground(new Color(17, 71, 90));
        ApplyNow.setFont(new Font("Cambria", Font.BOLD, 25));
        ApplyNow.setHorizontalAlignment(SwingConstants.CENTER);
        ApplyNow.setVerticalAlignment(SwingConstants.CENTER);
        ApplyNow.setBounds(450, 228, 190, 55);
        ApplyNow.setContentAreaFilled(false);
        ApplyNow.setFocusable(false);
        ApplyNow.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
        //ApplyNow.setFocusPainted(false);
        ApplyNow.addMouseListener(this);

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
        //HowToPlayButton.setFocusPainted(false);
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
        //Exit.setFocusPainted(false);
        Exit.addMouseListener(this);

        music();

        this.setTitle("Let OS Play");
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLayout(null);
        this.setResizable(false);
        this.setIconImage(titleIcon.getImage());
        this.getContentPane().setBackground(new Color(3,10,33));
        this.setLocationRelativeTo(null);
        this.setVisible(false);

        this.getContentPane().add(ApplyNow);
        this.getContentPane().add(HowToPlayButton);
        this.getContentPane().add(Exit);
        this.getContentPane().add(mainLogo);
    }

    public void music(){
        try {
            music.soundChoice(1);
        } catch (Exception e) {
            Logger.getLogger(MainGameFrame.class.getName()).log(Level.SEVERE, null, e);
        }

        music.playLoop();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource()==ApplyNow){
            try {
                buttonClick.soundChoice(4);
                new TheLadder_Quiz();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }
        if(e.getSource()==HowToPlayButton){
            buttonClick.soundChoice(4);
            new TheLadder_HowToPlayFrame();
            this.dispose();
        }
        if(e.getSource()==Exit){
            buttonClick.soundChoice(4);
            MainGameFrame.theLadder_mainFrame.music.stop();
            new MainGameFrame();
            this.dispose();
        }


    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource()==ApplyNow){
            ApplyNow.setFont(new Font("Cambria", Font.BOLD, 30));
            ApplyNow.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),5));
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

        if(e.getSource()==ApplyNow){
            ApplyNow.setFont(new Font("Cambria", Font.BOLD, 25));
            ApplyNow.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
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

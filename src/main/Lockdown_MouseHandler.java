package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Lockdown_MouseHandler implements MouseListener, MouseMotionListener {
    public int x;
    public int y;
    public int lawnX = -200;
    public int lawnY = -200;
    public int lawn;
    public boolean taxPayerCardClicked = false;
    public boolean nurseCardClicked = false;
    public boolean doctorCardClicked = false;
    public boolean soldierCardClicked = false;
    public boolean backCardClicked = false;
    public String currentCard;

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(String.format("Mouse clicked at %d, %d", e.getX(),e.getY()));
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            System.out.println(String.format("Mouse pressed down the mouse"));

            //Cards Location
            if((x >= 5 && x <= 110) && y >= 70 && y <= 150 ){
                System.out.println("Tax Payer Card BEEN Pressed: X: "  + x + " Y: " + y);
                taxPayerCardClicked = true;
                currentCard = "taxPayer";
            }

            if((x >= 5 && x <= 110) && y >= 155 && y <= 235 ){
                System.out.println("Nurse Card BEEN Pressed: X: "  + x + " Y: " + y);
                nurseCardClicked = true;
                currentCard = "nurse";
            }

            if((x >= 5 && x <= 110) && y >= 240 && y <= 320 ){
                System.out.println("Doctor Card BEEN Pressed: X: "  + x + " Y: " + y);
                doctorCardClicked = true;
                currentCard = "doctor";
            }

            if((x >= 5 && x <= 110) && y >= 325 && y <= 405 ){
                System.out.println("Soldier Card BEEN Pressed: X: "  + x + " Y: " + y);
                soldierCardClicked = true;
                currentCard = "soldier";
            }

            if((x >= 5 && x <= 100) && y >= 550 && y <= 595 ){
                System.out.println("Back Card BEEN Pressed: X: "  + x + " Y: " + y);
                backCardClicked = true;
            }





            //Lawn Location

            //Row 1
            if((x >= 110 && x <= 215) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 1 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 1;
                lawnX = 110;
                lawnY = 89;
            }
            if((x >= 216 && x <= 315) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 2 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 2;
                lawnX = 210;
                lawnY = 88;
            }
            if((x >= 300 && x <= 400) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 3 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 3;
                lawnX = 300;
                lawnY = 88;
            }
            if((x >= 400 && x <= 500) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 4 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 4;
                lawnX = 400;
                lawnY = 88;
            }
            if((x >= 500 && x <= 600) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 5 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 5;
                lawnX = 500;
                lawnY = 88;
            }
            if((x >= 600 && x <= 700) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 6 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 6;
                lawnX = 600;
                lawnY = 88;
            }
            if((x >= 700 && x <= 770) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 7 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 7;
                lawnX = 690;
                lawnY = 88;
            }
            if((x >= 785 && x <= 885) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 8 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 8;
                lawnX = 785;
                lawnY = 88;
            }
            if((x >= 885 && x <= 980) && y >= 88 && y <= 190 ){
                System.out.println("Lawn 9 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 9;
                lawnX = 885;
                lawnY = 88;
            }


            //Row 2
            if((x >= 110 && x <= 215) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 10 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 10;
                lawnX = 110;
                lawnY = 190;
            }
            if((x >= 210 && x <= 300) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 11 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 11;
                lawnX = 210;
                lawnY = 190;
            }
            if((x >= 300 && x <= 400) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 12 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 12;
                lawnX = 300;
                lawnY = 190;
            }
            if((x >= 400 && x <= 500) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 13 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 13;
                lawnX = 400;
                lawnY = 190;
            }
            if((x >= 500 && x <= 600) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 14 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 14;
                lawnX = 500;
                lawnY = 190;
            }
            if((x >= 595 && x <= 695) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 15 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 15;
                lawnX = 595;
                lawnY = 190;
            }
            if((x >= 695 && x <= 795) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 16 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 16;
                lawnX = 695;
                lawnY = 190;
            }
            if((x >= 775 && x <= 875) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 17 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 17;
                lawnX = 775;
                lawnY = 190;
            }
            if((x >= 880 && x <= 980) && y >= 190 && y <= 290 ){
                System.out.println("Lawn 18 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 18;
                lawnX = 880;
                lawnY = 190;
            }

            //Row 3
            if((x >= 110 && x <= 210) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 19 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 19;
                lawnX = 110;
                lawnY = 310;
            }
            if((x >= 210 && x <= 310) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 20 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 20;
                lawnX = 210;
                lawnY = 310;
            }
            if((x >= 310 && x <= 410) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 21 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 21;
                lawnX = 310;
                lawnY = 310;
            }
            if((x >= 410 && x <= 510) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 22 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 22;
                lawnX = 410;
                lawnY = 310;
            }
            if((x >= 500 && x <= 590) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 23 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 23;
                lawnX = 500;
                lawnY = 310;
            }
            if((x >= 590 && x <= 690) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 24 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 24;
                lawnX = 590;
                lawnY = 310;
            }
            if((x >= 695 && x <= 795) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 25 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 25;
                lawnX = 695;
                lawnY = 310;
            }
            if((x >= 780 && x <= 880) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 26 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 26;
                lawnX = 780;
                lawnY = 310;
            }
            if((x >= 883 && x <= 980) && y >= 310 && y <= 390 ){
                System.out.println("Lawn 27 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 27;
                lawnX = 883;
                lawnY = 310;
            }

            //Row 4
            if((x >= 110 && x <= 210) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 28 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 28;
                lawnX = 110;
                lawnY = 410;
            }
            if((x >= 210 && x <= 310) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 29 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 29;
                lawnX = 210;
                lawnY = 410;
            }
            if((x >= 310 && x <= 410) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 30 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 30;
                lawnX = 310;
                lawnY = 410;
            }
            if((x >= 410 && x <= 510) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 31 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 31;
                lawnX = 410;
                lawnY = 410;
            }
            if((x >= 500 && x <= 610) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 32 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 32;
                lawnX = 500;
                lawnY = 410;
            }
            if((x >= 590 && x <= 690) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 33 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 33;
                lawnX = 590;
                lawnY = 410;
            }
            if((x >= 690 && x <= 790) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 34 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 34;
                lawnX = 690;
                lawnY = 410;
            }
            if((x >= 790 && x <= 890) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 35 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 35;
                lawnX = 790;
                lawnY = 410;
            }
            if((x >= 890 && x <= 980) && y >= 400 && y <= 500 ){
                System.out.println("Lawn 36 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 36;
                lawnX = 890;
                lawnY = 410;
            }

            //Row 5
            if((x >= 110 && x <= 210) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 37 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 37;
                lawnX = 110;
                lawnY = 520;
            }
            if((x >= 210 && x <= 310) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 38 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 38;
                lawnX = 210;
                lawnY = 520;
            }
            if((x >= 305 && x <= 405) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 39 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 39;
                lawnX = 305;
                lawnY = 520;
            }
            if((x >= 405 && x <= 505) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 40 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 40;
                lawnX = 405;
                lawnY = 520;
            }
            if((x >= 500 && x <= 600) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 41 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 41;
                lawnX = 500;
                lawnY = 520;
            }
            if((x >= 600 && x <= 700) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 42 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 42;
                lawnX = 600;
                lawnY = 520;
            }
            if((x >= 690 && x <= 790) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 43 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 43;
                lawnX = 690;
                lawnY = 520;
            }
            if((x >= 790 && x <= 890) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 44 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 44;
                lawnX = 790;
                lawnY = 520;
            }
            if((x >= 890 && x <= 990) && y >= 500 && y <= 600 ){
                System.out.println("Lawn 45 have BEEN Pressed: X: "  + x + " Y: " + y);
                lawn = 45;
                lawnX = 890;
                lawnY = 520;
            }














            if((x > 115) && y > 88 && y < 621 ){
                System.out.println("Lawn have BEEN Pressed: X: "  + x + " Y: " + y);
                taxPayerCardClicked = false;
                nurseCardClicked = false;
                doctorCardClicked = false;
                soldierCardClicked = false;
                backCardClicked = false;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            System.out.println(String.format("You entered an area"));
        }

        @Override
        public void mouseExited(MouseEvent e) {

//            System.out.println(String.format("You exits an area"));
        }
            //MOUSE MOTION EVENTS
        @Override
        public void mouseDragged(MouseEvent e) {

//            System.out.println(String.format("Mouse dragged"));
        }

        @Override
        public void mouseMoved(MouseEvent e) {
//            System.out.println(String.format("Mouse move at %d, %d", e.getX(),e.getY()));
            x = e.getX();
            y = e.getY();
        }

    }


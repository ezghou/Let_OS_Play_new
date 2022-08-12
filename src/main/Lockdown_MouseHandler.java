package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Lockdown_MouseHandler implements MouseListener, MouseMotionListener {

    public int x;
    public int y;

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(String.format("Mouse clicked at %d, %d", e.getX(),e.getY()));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println(String.format("Mouse pressed down the mouse"));

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println(String.format("Mouse released"));

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println(String.format("You entered an area"));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println(String.format("You exits an area"));
        }
            //MOUSE MOTION EVENTS
        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println(String.format("Mouse dragged"));
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println(String.format("Mouse move at %d, %d", e.getX(),e.getY()));
            x = e.getX();
            y = e.getY();
        }

    }


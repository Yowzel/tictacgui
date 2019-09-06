/**
* This is a simple GUI program for java, it allows the player to play a
* 4x4 tic tac toe game against the computer. Once the user clicks on a cell
* where they would like to move, the computer will then move against the player
* if the board is full the game will stop playing, and say that it was a draw
* if the computer wins, it will say that the computer won and ask the user to close the Window
* if the user won it will say they won and end the game. Lastly, if no winner is found and
* the board is not full it will just alternate between users turn and computers turn.
* Lastly, the user can remove a computers O and replace it with its own.
*
* @author Gia-Huy Gonzalez
* @version 11 May 2019
* @since 29 April 2019
*/


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.util.*;

public class TTTGUI extends JFrame{
  // variables for the TTTGUI
  // creating static variable of the TTTGUI
  static TTTGUI c = new TTTGUI();
  // creating the frame for the GUI
  static JFrame f;
  // creating the panel for the boards buttons
  static JPanel tictac;
  // creating the jlabel for the board
  static JLabel turn;
  // creating the static buttons for the GUI
  static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
  public static void main(String[] args){
    f = new JFrame("Tic Tac Toe GUI");
    f.setSize(400, 400);
    JPanel l = new JPanel();
    turn = new JLabel("Your turn", JLabel.CENTER);
    l.setLayout(new FlowLayout());
    l.add(turn);
    tictac = new JPanel();
    tictac.setLayout(new GridLayout(4, 4));
    createButtons();
    f.setLayout(new BorderLayout());
    f.add(tictac, BorderLayout.CENTER);
    f.add(l, BorderLayout.SOUTH);
    //JLabel turn = new JLabel("Your turn" , JLabel.RIGHT);
    //tictac.add(turn);
    //turn.setVerticalAlignment(JLabel.CENTER);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.show();
  }

  /**
  * This is a method that helps create the buttons for the tic tac toe board.
  * the buttons are static and global so the method can just declare all the buttons.
  * alongside they add the buttons to the tictac board panel. Lastly, it calls
  * upon createButtons2() and that adds actionlisteners to each button.
  *
  */
  public static void createButtons(){
    b1 = new JButton("");
    b2 = new JButton("");
    b3 = new JButton("");
    b4 = new JButton("");
    b5 = new JButton("");
    b6 = new JButton("");
    b7 = new JButton("");
    b8 = new JButton("");
    b9 = new JButton("");
    b10= new JButton("");
    b11= new JButton("");
    b12= new JButton("");
    b13= new JButton("");
    b14= new JButton("");
    b15= new JButton("");
    b16= new JButton("");
    tictac.add(b1);
    tictac.add(b2);
    tictac.add(b3);
    tictac.add(b4);
    tictac.add(b5);
    tictac.add(b6);
    tictac.add(b7);
    tictac.add(b8);
    tictac.add(b9);
    tictac.add(b10);
    tictac.add(b11);
    tictac.add(b12);
    tictac.add(b13);
    tictac.add(b14);
    tictac.add(b15);
    tictac.add(b16);
    createButtons2();
  }

  /**
  * CreateButtons2 is a static void method that adds action listeners to each
  * button that is created. It will then pass in the JLabel turn, which is the
  * label at the button of the GUI stating whos turn it is to move, either
  * the computer or the players turn. Next it passes in which button it is.
  * Alongside side with a number to help the button action listener.
  * Finally, it will pass in the TTTGUI itself in order for the button action
  * listener to have access to each button.
  *
  */
  public static void createButtons2(){
    b1.addActionListener(new ButtonActionListener(turn, b1, 1, c));
    b2.addActionListener(new ButtonActionListener(turn, b2, 2, c));
    b3.addActionListener(new ButtonActionListener(turn, b3, 3, c));
    b4.addActionListener(new ButtonActionListener(turn, b4, 4, c));
    b5.addActionListener(new ButtonActionListener(turn, b5, 5, c));
    b6.addActionListener(new ButtonActionListener(turn, b6, 6, c));
    b7.addActionListener(new ButtonActionListener(turn, b7, 7, c));
    b8.addActionListener(new ButtonActionListener(turn, b8, 8, c));
    b9.addActionListener(new ButtonActionListener(turn, b9, 9, c));
    b10.addActionListener(new ButtonActionListener(turn, b10, 10, c));
    b11.addActionListener(new ButtonActionListener(turn, b11, 11, c));
    b12.addActionListener(new ButtonActionListener(turn, b12, 12, c));
    b13.addActionListener(new ButtonActionListener(turn, b13, 13, c));
    b14.addActionListener(new ButtonActionListener(turn, b14, 14, c));
    b15.addActionListener(new ButtonActionListener(turn, b15, 15, c));
    b16.addActionListener(new ButtonActionListener(turn, b16, 16, c));
  }
}

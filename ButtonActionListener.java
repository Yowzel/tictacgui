/**
* This is the button action listener for the TTTGUI. It will preform
* all the technical stuff of the GUI. Such as, moving the computer
* it will move on the TTTBoard and on the TTTGUI. It will also change
* the label that is on the TTTGUI. It has the constructor method to
* connect the buttons and stuff.
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

public class ButtonActionListener implements ActionListener {
  // Creating the variables for the Action Listener
  // Creating the static board for the game
  private static TTTBoard theBoard;
  // creating the static char letter for the user
  private static char user;
  // creating the TTTGUI inside the Button Action Listener
  private static TTTGUI masterBoard;
  // creating the computers char letter
  private static char computer;
  // creating a counter for the game
  private static int counter;
  // creating a boolean variable to see if the game is still playable
  private static boolean playing;
  // creating a 1d array that will help with logic
  private static int[] board;
  // creating a JLabel that connects it with TTTGUI's JLabel
  private JLabel message;
  // creating button to connect with TTTGUI's button
  private JButton but;
  // helps with figuring out which button was clicked
  private int pos;

  /**
  * This is the constructor method for the program. It will help intialize a lot
  * of the variables that will be used throughout program.

  * @param update update will take in the JLabel from TTTGUI and it with listener's Jlabel
  * @param button this is to connect with the button pressed with the listener
  * @param position this is to see which button is pressed and help place it on the TTTBoard
  * @param master this is the TTTGUI so that the listener can have access to all of the buttons
  *
  */
  public ButtonActionListener(JLabel update, JButton button, int position, TTTGUI master){
    playing = true;
    theBoard =  new TTTBoard(4);
    masterBoard = master;
    ///compareBoard = new TTTBoard(4);
    user = 'X';
    computer = 'O';
    counter = 0;
    board = new int[16];
    message = update;
    pos = position;
    //System.out.println(position);
    but = button;
  }

  /**
  * This is the real action listener that will preform after the button is clicked
  * this will preform the logic to see whos turn it is. Once the user clicks the button
  * it will change it to X. Then it will call add(). After it changes the JLabel to
  * Computers turn. Update the counter. Then check if the game is over.
  * After it will preform the computers turn, it will update the Label to users turn
  * then establishes the AI to help with the board. After it moves updates counter
  * and sees if the game is over.
  *
  * @param event is action listener and gets the action event that is happening
  *
  */
  public void actionPerformed(ActionEvent event){
    if(counter%2 == 0 && playing == true ){
      but.setText(String.valueOf(user));
      add();
      message.setText("Computers turn");
      counter++;
      endGame();
    }
    if(counter%2 != 0 && playing == true) {
      message.setText("Your turn");
      TTTAI ai = new TTTAI();
      ai.move(theBoard, computer);
      aiMove();
      counter++;
      endGame();
    }
  }

  /**
  * This is method that is called win you wanna see if the game is over.
  * it will check the board and see if the user has won. If they did,
  * it will update the label and say the user has won. Else see if the
  * computer has won. If not it will see if the board is a tie and the
  * board is full making it no longer playable.
  *
  */
  public void endGame(){
    if(theBoard.winner() == user){
      playing = false;
      message.setText("You won! end the game.");
    } else if (theBoard.winner() == computer){
      playing = false;
      message.setText("Sorry, the computer won! end the game");
    } else if(counter == 16 && theBoard.winner() == ' '){
      playing = false;
      message.setText("It's a draw!");
    }
  }

  /**
  * This method is the ai move method. Which essentially goes through the TTTBoard
  * checks each cell and see where the computer has just moved to. Once it finds where
  * the computer has moved to it will then move it to that spot in the GUI
  *
  */
  public void aiMove(){
    int num = 0;
    for(int row = 0; row < 4; row++){
      for(int col = 0; col < 4; col++){
        if(theBoard.get(row, col) != ' ' && board[num] == 0){
          if(num == 0){
            board[num] = 1;
            masterBoard.b1.setText("O");
          } else if(num == 1){
            board[num] = 1;
            masterBoard.b2.setText("O");
          } else if(num == 2){
            board[num] = 1;
            masterBoard.b3.setText("O");
          } else if(num == 3){
            board[num] = 1;
            masterBoard.b4.setText("O");
          } else if(num == 4){
            board[num] = 1;
            masterBoard.b5.setText("O");
          } else if(num == 5){
            board[num] = 1;
            masterBoard.b6.setText("O");
          } else if(num == 6){
            board[num] = 1;
            masterBoard.b7.setText("O");
          } else if(num == 7){
            board[num] = 1;
            masterBoard.b8.setText("O");
          } else if(num == 8){
            board[num] = 1;
            masterBoard.b9.setText("O");
          } else if(num == 9){
            board[num] = 1;
            masterBoard.b10.setText("O");
          } else if(num == 10){
            board[num] = 1;
            masterBoard.b11.setText("O");
          } else if(num == 11){
            board[num] = 1;
            masterBoard.b12.setText("O");
          } else if(num == 12){
            board[num] = 1;
            masterBoard.b13.setText("O");
          } else if(num == 13){
            board[num] = 1;
            masterBoard.b14.setText("O");
          } else if(num == 14){
            board[num] = 1;
            masterBoard.b15.setText("O");
          } else {
            board[num] = 1;
            masterBoard.b16.setText("O");
          }
        }
        num++;
      }
    }
  }

  /**
  * This method is the add method, it will figure out the button that was just pressed
  * after figuring out the button that was pressed it will add that button pressed
  * to the 1d array. Then adds it to the 2d array. This will help with the logic in the program.
  *
  */
  public void add(){
    if(pos == 1){
      theBoard.set(0, 0, user);
      board[0] = 1;
      ////compareBoard.set(0, 0, user);
    } else if(pos == 2){
      theBoard.set(0, 1, user);
      board[1] = 1;
      //compareBoard.set(0, 1, user);
    } else if(pos == 3){
      board[2] = 1;
      theBoard.set(0, 2, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 4){
      board[3] = 1;
      theBoard.set(0, 3, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 5){
      board[4] = 1;
      theBoard.set(1, 0, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 6){
      board[5] = 1;
      theBoard.set(1, 1, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 7){
      board[6] = 1;
      theBoard.set(1, 2, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 8){
      board[7] = 1;
      theBoard.set(1, 3, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 9){
      board[8] = 1;
      theBoard.set(2, 0, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 10){
      board[9] = 1;
      theBoard.set(2, 1, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 11){
      board[10] = 1;
      theBoard.set(2, 2, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 12){
      board[11] = 1;
      theBoard.set(2, 3, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 13){
      board[12] = 1;
      theBoard.set(3, 0, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 14){
      board[13] = 1;
      theBoard.set(3, 1, user);
      //compareBoard.set(0, 2, user);
    } else if(pos == 15){
      board[14] = 1;
      theBoard.set(3, 2, user);
      //compareBoard.set(0, 2, user);
    } else {
      board[15] = 1;
      theBoard.set(3, 3, user);
      //compareBoard.set(0, 2, user);
    }
    //System.out.println(theBoard.toString());
  }
}

/**
* The TTTBoard program creates a 2 dimension array
* the default constructor creates the size as 3
* the other constructor creates an array of the size that is passed in
* there are many methods that allow the user to play the game of tic tac toe
*
* @author Gia-Huy Gonzalez
* @version 5 Feb 2019
* @since 2 Feb 2019
*/
public class TTTBoard {

  private char[][] board;
  private int globalSize;
  static int DEFAULT_SIZE = 3;

  /**
  * This is the constructor for the method
  *
  * @throws IllegalArgumentException if size is not greater than 0
  * @param size This is the parameter to create the size of the array
  */
  public TTTBoard(int size){
    globalSize = size;
    if(size < 1){
      throw new IllegalArgumentException("size must be greater than 1");
    } else {
      board = new char[size][size];
    }
  }

  /**
  * This is the constructor for the method if no parameter is passed
  */
  public TTTBoard(){
    globalSize = DEFAULT_SIZE;
    board = new char[DEFAULT_SIZE][DEFAULT_SIZE];
  }

  /**
  * Method is for returning the character in the 2d array
  *
  * @throws IndexOutOfBoundsException if the r and c is not within the array.
  * @param r one position in the 2d array
  * @param c second position in the 2d array
  * @return returns the character in the 2d array
  */
  public char get(int r, int c){
    if(r > globalSize -1 || c > globalSize-1 || r < 0 || c < 0 ){
      throw new IndexOutOfBoundsException("you're input is out of bounds");
    }
    if(board[r][c] == 0){
      return(' ');
    }
    return(board[r][c]);
  }

  /**
  * Set the position in the array as a character
  *
  * @throws IndexOutOfBoundsException if r and c is not possible.
  * @param r one position in the 2d array
  * @param c second position in the 2d array
  * @param ch the character that will be placed into the 2d array
  */
  public void set(int r, int c, char ch){
    if(r > globalSize -1 || c > globalSize-1 || r < 0 || c < 0 ){
      throw new IndexOutOfBoundsException("you're input is out of bounds");
    }
    board[r][c] = ch;
  }

  /**
  * return the size of the array
  *
  * @return the integer size of the array
  */
  public int size(){
    return globalSize;
  }

  /**
  * Method checks to see if there is a winner in the array
  *
  * @return character if a winner is found, if not a space is returned
  */
  public char winner(){
    // checks for diagonal
    //variables for checking right diagonal
    char rightDiag = board[0][0];
    int rightCounter = 0;
    for(int i = 0; i <globalSize; i++){
      if(rightDiag == board[i][i] && rightDiag != 0){
        rightCounter++;
      }
      if(rightCounter == globalSize){
        return rightDiag;
      }
    }
    //variables for checking left diagonal
    char leftDiag = board[0][globalSize-1];
    int leftCounter = 0;
    int num = globalSize-1;
    for(int i = 0; i<globalSize; i++){
      if(leftDiag == board[i][num] && leftDiag != 0){
        leftCounter++;
      }
      num--;
      if(leftCounter == globalSize){
        return leftDiag;
      }
    }
    // checks the rows
    for(int i = 0; i < globalSize; i++){
      int counter = 0;
      char letter = board[i][i];
      for(int j = 0; j <globalSize; j++){
        if(letter == board[i][j] && letter != 0){
          counter++;
        }
      }
      if(counter == globalSize){
        return letter;
      }
    }
    // checks the columns
    for(int i = 0; i < globalSize; i++){
      int counter = 0;
      char letter = board[i][i];
      for(int j = 0 ; j <globalSize; j++){
        if(letter == board[j][i]&& letter != 0){
          counter++;
        }
      }
      if(counter == globalSize){
        return letter;
      }
    }
    //if none of these return a winner, space is returned
    return(' ');
  }

  /**
  * Method creates the 2d array into a tictactoe board
  *
  * @return the tictactoe board as a single string
  */
  public String toString(){
    // creating the string
    String table = "";
    // for loop to create the board
    for(int i = 0; i < globalSize ; i++ ){
      //for each character in the board
      for(int j = 0; j < 2 * (globalSize - 1); j++){
        //if statements to add the characters from the array into the string
        if(j < globalSize && i <globalSize) {
          if(board[i][j] != 0){
            table += board[i][j];
            if(j<globalSize-1){
              table += "|";
            }
          } else if (j< globalSize-1){
            table += " |";
          } else{
            table += " ";
          }
        }
      }
      // creates the next line in the string
      if(i<globalSize-1){
        table += "\n";
      }
      // creates the + - part of the table
      if(i < globalSize-1){
        for(int y = 0; y < 2 * globalSize - 1; y++){
          if(y%2 == 0){
            table += "-";
          } else {
            table += "+";
          }
        }
      }
      //next line for the table
      if(i<globalSize - 1)
        table += "\n";
    }
    return table;
  }
}

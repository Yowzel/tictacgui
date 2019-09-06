/**
* The TTTAI class is to see if there is legal moves that a player can make
* The main method of this is to see if there is a move for the player to make
* the first statement is to see if there is any winner of the board or if the board is is is
*
*
* @author Gia-Huy Gonzalez
* @version 10 Apr 2019
* @since 2 Feb 2019
*/
import java.io.*;
import java.util.*;
//board.winner() != ' ' ||
public class TTTAI{
  /**
  * This is the main method for this class, called move. This will play a vitale
  * role in the game. Because if the player has a winning move it will set the player
  * to the winning position. Or if there is not winning move it will see if the opponent
  * has a winning move it will block the opponent. If all else fails it will move the player
  * to a random position.
  *
  * @throws IllegalArgumentException if the board does not have a winner or if it is full, throws IllegalArgumentException
  * @param board is the type board that will be passed into the method
  * @param who is the character used to either move to a spot or block an opponent
  *
  */
  public static void move(TTTBoard board, char who){
    Random ran = new Random();
    if(board.winner() != ' ' || isFull(board) == true){
      throw new IllegalArgumentException("This board already has a winner or there is a winner");
    } else if(canRow(board, who) == true){
      //System.out.println("Row");
      rowAI(board,who);
    } else if(canCol(board, who) == true) {
      //System.out.println("Column");
      colAI(board,who);
    } else if(canRightDiag(board, who) == true){
      //System.out.println("right diag");
      rightDiagAI(board, who);
    } else if(canLeftDiag(board, who) == true){
      //System.out.println("left diag");
      leftDiagAI(board, who);
    } else if(canBlockRow(board, who) == true){
      //System.out.println("block row");
      blockRow(board, who);
    } else if(canBlockCol(board, who) == true){
      //System.out.println("block col");
      blockCol(board, who);
    } else if(canBlockRight(board, who) == true){
      //System.out.println("block right");
      blockRight(board, who);
    } else if(canBlockLeft(board, who) == true){
      //System.out.println("block left");
      //System.out.println("left is happening");
      blockLeft(board, who);
    } else{
      int pos1 = ran.nextInt(board.size());
      int pos2 = ran.nextInt(board.size());
      boolean open = true;
      while(open == true){
        if(board.get(pos1, pos2) == ' '){
          board.set(pos1, pos2, who);
          open = false;
        } else{
          pos1 = ran.nextInt(board.size());
          pos2 = ran.nextInt(board.size());
        }
      }
    }
  }

  /**
  * This is the method that will be used to see if the board is already full
  * works by checking each row to see if there is any blank spaces. If there is a space
  * found then the boards not full. Else board is full
  *
  * @param board is the type board that will be passed into the method
  * @return returns true if the board is full, else it will return false
  */
  public static boolean isFull(TTTBoard board){
    // this checks threw each row to see if there are no spaces left
    // if space is found then the board is not full
    for(int i = 0; i < board.size(); i++){
      for(int j = 0; j < board.size(); j++){
        if(board.get(i, j) == ' '){
          return false;
        }
      }
    }
    //if a space is not found then the board is full
    return true;
  }

  /**
  * This method will see if the player has a winning move
  * it will check if there is any place the player can have a winning move
  * if there is a winning move it will return true
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move, else no winning move
  */
  public static boolean canRow(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int whoCounter = 0;
      int rowSpace = -1;
      int colSpace = -1;
      for(int j = 0; j < board.size(); j++){
        if(board.get(i, j) == who){
          whoCounter++;
        } else if(board.get(i, j) ==  ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      if(whoCounter == board.size()-1 && rowSpace != -1 && colSpace != -1){
        return true;
      }
    }
    return false;
  }

  /**
  * This method will see if there is any opening spots for the player to win
  * it will check each row and see if there is a winning spot. If there is it will
  * move the player to the winning position.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void rowAI(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int whoCounter = 0;
      int rowSpace = 0;
      int colSpace = 0;
      for(int j = 0; j < board.size(); j++){
        if(board.get(i, j) == who){
          whoCounter++;
        } else if(board.get(i, j) ==  ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      if(whoCounter == board.size()-1){
        board.set(rowSpace, colSpace, who);
        break;
      }
    }
  }

  /**
  * This method will see if the player has a winning move in the columns
  * it will check if there is any place the player can have a winning move
  * if there is a winning move it will return true else it will return false
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move, else no winning move
  */
  public static boolean canCol(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int whoCounter = 0;
      int rowSpace = -1;
      int colSpace = -1;
      for(int j = 0; j < board.size(); j++){
        //System.out.println("Who: " + whoCounter + "col: " + j + "row: " + i);
        if(board.get(j, i) == who){
          //System.out.println("Who: " + whoCounter + "col: " + j + "row: " + i);
          whoCounter++;
        } else if(board.get(j, i) == ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      //System.out.println(whoCounter);
      //System.out.println("Who: " + whoCounter + "col: " + colSpace + "row: " + rowSpace);
      if(whoCounter == board.size()-1 && rowSpace != -1 && colSpace != -1) {
        return true;
      }
    }
    return false;
  }

  /**
  * this method will see if the player(who) has any column positions
  * were they can win. If one is found it will move the player to that
  * column position.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void colAI(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int whoCounter = 0;
      int rowSpace = 0;
      int colSpace = 0;
      for(int j = 0; j < board.size(); j++){
        if(board.get(j, i) == who){
          whoCounter++;
        } else if(board.get(j, i) ==  ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      if(whoCounter == board.size()-1){
        board.set(colSpace, rowSpace, who);
        break;
      }
    }
  }

  /**
  * This method will check the right diag of the board. If there is a
  * right diagonal position that the player can move to. It will return true
  * else return false
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move, else no winning move
  */
  public static boolean canRightDiag(TTTBoard board, char who){
    char rightDiag = who;
    int spaces = -1;
    int rightCounter = 0;
    for(int i = 0; i <board.size(); i++){
      if(rightDiag == board.get(i, i)){
        rightCounter++;
      } else if(board.get(i, i) == ' '){
        spaces = i;
      }
      if(rightCounter == board.size() -1 && spaces != -1){
        return true;
      }
    }
    return false;
  }

  /**
  * This method will see if the right diag of the board has a winning move
  * for the player(who). If there is a winning move it will move the player(who)
  * to the position
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void rightDiagAI(TTTBoard board, char who){
    char rightDiag = who;
    int spaces = 0;
    int rightCounter = 0;
    for(int i = 0; i <board.size(); i++){
      if(rightDiag == board.get(i, i)){
        rightCounter++;
      } else if(board.get(i, i) ==  ' '){
        spaces = i;
      }
    }
    if(rightCounter == board.size() -1){
      board.set(spaces, spaces, who);
    }
  }

  /**
  * This method will see if the left diag of the board has a winning move
  * for the player(who). If there is a winning move it will move the player(who)
  * to the position
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void leftDiagAI(TTTBoard board, char who){
    char leftDiag = who;
    int leftCounter = 0;
    int space = 0;
    int space2 = 0;
    int num = board.size()-1;
    for(int i = 0; i<board.size(); i++){
      if(leftDiag == board.get(i, num)){
        leftCounter++;
      } else if(board.get(i, num) == ' '){
        space = i;
        space2 = num;
      }
      num--;
    }
    if(leftCounter == board.size()-1){
      board.set(space, space2, who);
    }
  }

  /**
  * This method will check the left diagonal of the board. If there is a
  * left diagonal position that the player can move to. It will return true
  * else return false
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move, else no winning move
  */
  public static boolean canLeftDiag(TTTBoard board, char who){
    char leftDiag = who;
    int leftCounter = 0;
    int space = -1;
    int space2 = -1;
    int num = board.size()-1;
    for(int i = 0; i<board.size(); i++){
      if(leftDiag == board.get(i, num)){
        leftCounter++;
      } else if(board.get(i, num) == ' '){
        space = i;
        space2 = num;
      }
      num--;
    }
    if(leftCounter == board.size()-1 && space != -1 && space2 != -1){
      return true;
    }
    return false;
  }

  /**
  * This method is to see if there is a way for the player to block the
  * opponent from winning in a row. If the opponent can win, this will return
  * true.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move for the opponent.
  */
  public static boolean canBlockRow(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int oppCounter = 0;
      int rowSpace = -1;
      int colSpace = -1;
      for(int j = 0; j < board.size(); j++){
        if(board.get(i, j) != who && board.get(i, j) != ' '){
          oppCounter++;
        } else if(board.get(i, j) == ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      if(oppCounter == board.size()-1 && rowSpace != -1 && colSpace != -1){
        return true;
      }
    }
    return false;
  }

  /**
  * This method will check the board, and see if there is a winning move for the
  * opponent. If the opponent has a winning move it will stop the winning move
  * from happening.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void blockRow(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int oppCounter = 0;
      int rowSpace = 0;
      int colSpace = 0;
      for(int j = 0; j < board.size(); j++){
        if(board.get(i, j) != who && board.get(i, j) != ' '){
          oppCounter++;
        } else if(board.get(i, j) ==  ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      if(oppCounter == board.size()-1){
        board.set(rowSpace, colSpace, who);
        break;
      }
    }
  }

  /**
  * This method will search the entire board, it will see if the opponent
  * has a winning move in the columns. If so, it will return true else return false
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move for the opponent or false
  */
  public static boolean canBlockCol(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int oppCounter = 0;
      int rowSpace = -1;
      int colSpace = -1;
      for(int j = 0; j < board.size(); j++){
        if(board.get(j, i) != who && board.get(j, i) != ' '){
          oppCounter++;
        } else if(board.get(j, i) == ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      if(oppCounter == board.size()-1 && rowSpace != -1 && colSpace != -1){
        return true;
      }
    }
    return false;
  }

  /**
  * This method will look through each column within the board.
  * it will see if the opponent has a winning move. If there is, it will
  * block the winning move.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void blockCol(TTTBoard board, char who){
    for(int i = 0; i < board.size(); i++){
      int oppCounter = 0;
      int rowSpace = 0;
      int colSpace = 0;
      for(int j = 0; j < board.size(); j++){
        if(board.get(j, i) != who && board.get(j, i) != ' '){
          oppCounter++;
        } else if(board.get(j, i) ==  ' '){
          rowSpace = i;
          colSpace = j;
        }
      }
      if(oppCounter == board.size()-1){
        board.set(colSpace, rowSpace, who);
        break;
      }
    }
  }

  /**
  * This method will check the right diagonal of the board.
  * It will see if the opponents can win at the right diagonal.
  * if so it will return true or return false.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move for the opponent or false
  */
  public static boolean canBlockRight(TTTBoard board, char who){
    char rightDiag = who;
    int spaces = -1;
    int rightCounter = 0;
    for(int i = 0; i <board.size(); i++){
      if(board.get(i, i) != who && board.get(i, i) != ' '){
        rightCounter++;
      } else if(board.get(i, i) == ' '){
        spaces = i;
      }
      if(rightCounter == board.size() -1 && spaces != -1){
        return true;
      }
    }
    return false;
  }

  /**
  * This method will go through each position in the right diagonal.
  * if there is a spot for the opponent to win. This method will block
  * the winning move from happening.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void blockRight(TTTBoard board, char who){
    char rightDiag = who;
    int spaces = 0;
    int rightCounter = 0;
    for(int i = 0; i <board.size(); i++){
      if(board.get(i, i) != who && board.get(i, i) != ' '){
        rightCounter++;
      } else if(board.get(i, i) ==  ' '){
        spaces = i;
      }
    }
    if(rightCounter == board.size() -1){
      board.set(spaces, spaces, who);
    }
  }

  /**
  * This method will search each position in the left diagonal of the board.
  * if there is a spot for the opponent to win. This method will stop the
  * winning move from happening.
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  */
  public static void blockLeft(TTTBoard board, char who){
    char leftDiag = who;
    int leftCounter = 0;
    int space = 0;
    int space2 = 0;
    int num = board.size()-1;
    for(int i = 0; i<board.size(); i++){
      if(board.get(i, num) != who && board.get(i, num) != ' '){
        leftCounter++;
      } else if(board.get(i, num) == ' '){
        space = i;
        space2 = num;
      }
      num--;
    }
    if(leftCounter == board.size()-1){
      board.set(space, space2, who);
    }
  }

  /**
  * This method will count each position at the left diagonal. By doing so,
  * it will look if there is a winning move for the opponent. If there is a
  * winning move for the opponent it will return true else return false
  *
  * @param board is the type board that will be passed into the method
  * @param who is the character we will be seeing if there is any spots to win
  * @return returns true if there is a winning move for the opponent or false
  */
  public static boolean canBlockLeft(TTTBoard board, char who){
    char leftDiag = who;
    int leftCounter = 0;
    int space = -1;
    int space2 = -1;
    int num = board.size()-1;
    for(int i = 0; i<board.size(); i++){
      if(board.get(i, num) != who && board.get(i, num) != ' '){
        leftCounter++;
      } else if(board.get(i, num) == ' '){
        space = i;
        space2 = num;
      }
      num--;
    }
    if(leftCounter == board.size()-1 && space != -1 && space2 != -1){
      return true;
    }
    return false;
  }
}

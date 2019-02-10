public class QueenBoard {
  private int[][] board;
  private int count;

  public QueenBoard(int size){
    board = new int[size][size];
    count = 0;
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] != 0) return false;
    else {
      board[r][c] = -1;
      for (int i = c+1; i < board.length; i++) {
        if (board[r][i] != -1) board[r][i]++;
      }
      for (int i = 0; i < board.length; i++) {
        if (board[i][c] != -1) board[i][c]++;
      }
      for (int i = 1; i < board.length-c && i < board.length-r; i++) {
        if (board[r+i][c+i] != -1) board[r+i][c+i]++;
      }
      for (int i = 1; i <= r && i < board.length-c; i++) {
        if (board[r-i][c+i] != -1) board[r-i][c+i]++;
      }
      return true;
    }
  }

  public boolean removeQueen(int r, int c){
    if (board[r][c] != -1) return false;
    else {
      board[r][c] = 0;
      for (int i = c+1; i < board.length; i++) {
        if (board[r][i] != -1) board[r][i]--;
      }
      for (int i = 0; i < board.length; i++) {
       if (board[i][c] != 0) board[i][c]--;
      }
      for (int i = 1; i < board.length-c && i < board.length-r; i++) {
        if (board[r+i][c+i] != 0) board[r+i][c+i]--;
      }
      for (int i = 1; i <= r && i < board.length-c; i++) {
        if (board[r-i][c+i] != 0) board[r-i][c+i]--;
      }
      return true;
    }
  }

  // /**
  // *@return The output string formatted as follows:
  // *All numbers that represent queens are replaced with 'Q'
  // *all others are displayed as underscores '_'
  // *There are spaces between each symbol:
  // *"""_ _ Q _
  // *Q _ _ _
  // *_ _ _ Q
  // *_ Q _ _"""
  // *(pythonic string notation for clarity,
  // *excludes the character up to the *)
  // */
  //
  public String toString(){
    String s = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) s+="_ ";
        else if (board[i][j] == -1) s+="Q ";
        else s+="X ";
        //s+=board[i][j]+" ";
      }
      s+="\n";
    }
    return s;
  }
  // /**
  // *@return false when the board is not solveable and leaves the board filled with zeros;
  // *        true when the board is solveable, and leaves the board in a solved state
  // *@throws IllegalStateException when the board starts with any non-zero value
  // */
  public boolean solve(){
  	if (count == 8) {
  		return true;
  		System.out.println(toString());
  	}
  	else{
    	for (int i = 0; i < board.length; i++) {
      	for (int j = 0; j < board.length; j++) {
        	if (addQueen(i,j)) {

        	System.out.println(toString());
        	}
      	}
    	}
    }
    return false;
  }
  //
  // /**
  // *@return the number of solutions found, and leaves the board filled with only 0's
  // *@throws IllegalStateException when the board starts with any non-zero value
  // */
  // public int countSolutions(){}

}

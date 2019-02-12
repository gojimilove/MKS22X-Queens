public class QueenBoard {
  private int[][] board;
  private int counter;

  public QueenBoard(int size){
    board = new int[size][size];
    counter = 0;
  }

  /**
   * Attempts to add a queen at specified row, col coords. If
   * successful, marks specified position as -1 to indicate queen,
   * adds 1 to all threatened positions to the right, below, and above
   *
   * @param r row to add queen at
   * @param c column to add queen at
   * @return  true if possible to place queen without threatening
   *          one another, false if not possible
  */
  public boolean addQueen(int r, int c) {
    if (board[r][c] != 0) return false;
    else {
      board[r][c] = -1;
      for (int i = c + 1; i < board.length; i++) {
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

  /**
   * Attempts to remove a queen from specified row, col coords. If
   * successful, marks specified position as 0 to remove the queen,
   * subtracts 1 from all previously threatened positions to the right, below, and above
   *
   * @param r row to remove queen from
   * @param c column to remove queen from
   * @return  true if there is a queen at the given coordinates to remove, false otherwise
  */
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

  /**
  *@return the size of the board (length or width, they're the same)
  */
  public int length() {
  	return board.length;
  }

  /**
  @return the number value at the given row and column of the board
  */
  public int getSpace(int r, int c) {
  	return board[r][c];
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *   Q _ _ _
  *   _ _ _ Q
  *   _ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  
  public String toString() {
    String s = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) s+="_ ";
        else if (board[i][j] == -1) s+="Q ";
        else s+="_ ";
        //s+=board[i][j]+" ";
      }
      s+="\n";
    }
    return s;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve() {
  	return solveH(this, 0);
  }

  private boolean solveH(QueenBoard b, int c) {
  	if (c == b.length()) {
  		//System.out.println(b);
  		return true;
  	}
  	else {
  		for (int r = 0; r < b.length(); r++) {
  			//System.out.println("["+r+", "+c+"]");
  			if (b.addQueen(r, c)) {
  				//System.out.println(b);
  				if (solveH(b, c+1)) return true;
          b.removeQueen(r,c);
  			}
  		}
  	}
  	return false;
  }
  
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions() {
  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board.length; j++) {
  			if (board[i][j] != 0) throw new IllegalStateException("the board is not empty");
  		}
  	}
  	countH(this, 0);
  	return counter;
  }

  private boolean countH(QueenBoard b, int c) {
  	if (c == b.length()) {
  		//System.out.println(b);
  		counter++;
  		//System.out.println("Solutions: "+counter);
  	}
  	else {
  		for (int r = 0; r < b.length(); r++) {
  			if (b.addQueen(r, c)) {
  				if (countH(b, c+1)) return true;
          b.removeQueen(r,c);
  			}
  		}
  	}
  	return false;
  }

}

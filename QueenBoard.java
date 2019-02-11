public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  /**
   * Attempts to add a queen at specified row, col coords. If
   * successful, marks specified position as -1 to indicate queen,
   * adds 1 to all threatened positions to the right and above
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

  public int length() {
  	return board.length;
  }

  // /**
  // *@return The output string formatted as follows:
  // *All numbers that represent queens are replaced with 'Q'
  // *all others are displayed as underscores '_'
  // *There are spaces between each symbol:
  // *"""_ _ Q _
  // *   Q _ _ _
  // *   _ _ _ Q
  // *   _ Q _ _"""
  // *(pythonic string notation for clarity,
  // *excludes the character up to the *)
  // */
  //
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
  // /**
  // *@return false when the board is not solveable and leaves the board filled with zeros;
  // *        true when the board is solveable, and leaves the board in a solved state
  // *@throws IllegalStateException when the board starts with any non-zero value
  // */
  public boolean solve() {
  	return nq(this, 0);
  }

  // private boolean nq(QueenBoard b, int c) {
  // 	for (int i = 0; i < b.length(); i++) {
  // 		boolean success = b.addQueen(i,c);
  // 		System.out.println("\nRow: "+i+" Col: "+c+" Success: "+success);
  // 		// if (!success) {//if it doesnt fit
  // 		// 	return false;
  // 		// } 
  // 		if (success) {
  // 			if (c == b.length()) {
  // 				System.out.println(b);
  // 				return true;
  // 			} 
  // 			else {
  // 				System.out.println(b);
	 //  			return nq(b, c+1);
  // 			}
  // 		}
  //   }
  //   return true;
  // }

  private boolean nq(QueenBoard b, int c) {
  	if (c == b.length()) {
  		System.out.println(b);
  		return true;
  	}
  	else {
  		for (int r = 0; r < b.length(); r++) {
  			//System.out.println("["+r+", "+c+"]");
  			if (b.addQueen(r, c)) {
  				//System.out.println(b);
  				return nq(b, c+1);
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

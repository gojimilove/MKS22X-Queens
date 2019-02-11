public class Driver {
  public static void main(String[] args) {
    QueenBoard qb = new QueenBoard(8);
    System.out.println(qb);
    // for (int i = 0; i < 8; i++) {
    // 	for (int j = 0; j < 8; j++) {
    // 		if (qb.addQueen(j,i)) System.out.println(qb);
    // 	}
    // }
    System.out.println(qb.solve());
    // qb.addQueen(0,0);
    // System.out.println(qb);
    // qb.removeQueen(0,0);
    // System.out.println(qb);
    // qb.solve();
  }
}

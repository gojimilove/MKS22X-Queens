public class Driver {
  public static void main(String[] args) {
    QueenBoard a = new QueenBoard(8);
    System.out.println(a);
    // for (int i = 0; i < 8; i++) {
    // 	for (int j = 0; j < 8; j++) {
    // 		a.addQueen(i,j);
    // 		System.out.println(a);
    // 		a.removeQueen(i,j);
    // 	}
    // }
    a.addQueen(0,0);
    System.out.println(a);
    a.removeQueen(0,0);
    System.out.println(a);
    a.solve();
  }
}

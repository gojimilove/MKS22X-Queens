public class Driver {
  public static void main(String[] args) {
    QueenBoard q8 = new QueenBoard(8);
    //System.out.println(q8);
    System.out.println("8x8: "+q8.solve());
    System.out.println(q8);

    QueenBoard q1 = new QueenBoard(1);
    //System.out.println(q1);
    System.out.println("1x1: "+q1.solve());
    System.out.println(q1);

    QueenBoard q2 = new QueenBoard(2);
    //System.out.println(q2);
    System.out.println("2x2: "+q2.solve());
    System.out.println(q2);

    QueenBoard q3 = new QueenBoard(3);
    //System.out.println(q3);
    System.out.println("3x3: "+q3.solve());
    System.out.println(q3);

    QueenBoard q4 = new QueenBoard(4);
    //System.out.println(q4);
    System.out.println("4x4: "+q4.solve());
    System.out.println(q4);

    QueenBoard q10 = new QueenBoard(10);
    //System.out.println(q10);
    System.out.println("10x10: "+q10.solve());
    System.out.println(q10);
    // qb.addQueen(0,0);
    // System.out.println(qb);
    // qb.removeQueen(0,0);
    // System.out.println(qb);
    // qb.solve();
  }
}

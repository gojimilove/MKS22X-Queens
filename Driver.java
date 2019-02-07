public class Driver {
  public static void main(String[] args) {
    QueenBoard a = new QueenBoard(8);
    System.out.println(a);
    a.addQueen(5,5);
    System.out.println(a);
  }
}

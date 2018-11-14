
public class Main {
    private int[][] mines;
    private char[][] Board;
    private int row, column;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
  
    public Main(){
      mine = new int[10][10];
      Board = new char[10][10];
      initializeMines();          //초기화된 판
      placeMines();               //지뢰를 무작위 위치로 채움
      NominesOfSurroundingNeighbours(); //주변에 지뢰가 있는지 숫자로 표현해줌
      startBoard();                     //게임시작
}

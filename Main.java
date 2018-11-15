

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
      placeMines();                //지뢰를 무작위 위치로 채움
      NominesOfSurroundingNeighbours(); //주변에 지뢰가 있는지 숫자로 표현해줌
      startBoard();                      //게임시작
}
    public boolean win() {
    	int count = 0;
    	for(int line = 1; line < 9; line++)
    		for(int column = 1; column < 9; column++)
    			if(Board[line][column] == '#')
    				count++;
    	if(count == 10)
    		return true;
    	else
    		return false;
    }
    
    public void revealNeighbours() {
    	for(int i = -1; i<2; i++)
    		for(int j = -1; j<2; j++)
    			if(mines[row + i][column + j] != -1)
    				Board[row + i][column + j] = Character.forDigit(mines[row + i][column + j], 10);
    }
    
    public int getPosition(int line, int column) {
    	return mines[line][column];
    }
    
    public boolean readAndsetPosition() {
    	do {
    		System.out.print("\nrow: ");
    		row = sc.nextInt();
    		System.out.print("Column: ");
    		column = sc.nextInt();
    		
    	if( (Board[row][column] != '*') && ((row < 9 && row > 0) && (column < 9 && column > 0)))
    		System.out.println("Field already shown");
    	
    	if( row < 1 || row > 8 || column < 1 || column > 8)
    		System.out.println("Choose a number between 1 and 8");
    	
    	}while((row < 1 || row > 8 || column < 1 || column > 8) || (Board[row][column] != '*'));
    	
    	if(getPosition(row, column) == -1 )
    		return true;
    	else
    		return false;
    	}
    
    
    
    }
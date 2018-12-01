
import java.util.Random;
import java.util.Scanner;


public class Main {
    private int[][] mines;
    private char[][] Board;
    private int row, column;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
  
    public Main(){
      mines = new int[12][12];
      Board = new char[12][12];
      initializeMines();          //초기화된 판
      placeMines();                //지뢰를 무작위 위치로 채움
      NominesOfSurroundingNeighbours(); //주변에 지뢰가 있는지 숫자로 표현해줌
      startBoard();                      //게임시작
}
    public boolean win() {
    	int count = 0;
    	for(int line = 1; line < 11; line++)
    		for(int column = 1; column < 11; column++)
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
    				Board[row + i][column + j] = Character.forDigit(mines[row + i][column + j], 12);
    }
    
    public int getPosition(int Line, int Column) {
    	return mines[Line][Column];
    }
    
    public void flag(int row, int column, int num) {
    	if(num == 2) {
    		if(Board[row][column] == '-')
    			Board[row][column] = '@'; //@는 깃발 표시
    		else
    			System.out.println("깃발을 꽂을 수 없습니다.");
    	}
    	num = 0;
    }
    
    public void outFlag(int row, int column, int num) {
    	if(num == 3) {
    		if(Board[row][column] == '@')
    			Board[row][column] = '-'; //깃발 삭제
    		else
    			System.out.println("깃발을 삭제할 수 없습니다.");
    	}
    	num = 0;
    }
    
    public boolean readAndsetPosition() {
    	do {
    		System.out.print("\nrow: ");
    		row = sc.nextInt();
    		System.out.print("column: ");
    		column = sc.nextInt();
    		System.out.print("1번 : 지뢰 찾기, 2번 : 깃발 꽂기, 3번 : 깃발 삭제>>");
    		num = sc.nextInt();
    		
    	if( (Board[row][column] != '-') && ((row < 11 && row > 0) && (column < 11 && column > 0)))
    		System.out.println("이미 입력한 좌표입니다.");
    	
    	
    	if( row < 1 || row > 10 || column < 1 || column > 10)
    		System.out.println("row, column : 1~10 사이 숫자를 입력하세요.");
    	
    	if(num != 1 && num != 2)
    		System.out.println("1, 2, 3번으로 클릭, 깃발 꽂기, 깃발 삭제를 할 수 있습니다");
    	
		if( num ==1) {
    		revealNeighbours();
    		showMain();
    	}else if(num == 2) {
    	flag(row, column, num);
    	showMain();
    	}else if(num ==3){
    	outFlag(row, column, num);
    	showMain();
    	}
		
    	}while((row < 1 || row > 10 || column < 1 || column > 10) || (Board[row][column] != '-') || num != 2 || num != 3);
    	
    	if((getPosition(row, column) == -1) && (num == 1))
    		return true;
    	else
    		return false;
		
	}
	
	public void showMain() {
	
		System.out.println("\n		Lines");
		for(int Line = 10; Line > 0; Line--) {
			if(Line >= 10) {
				System.out.print("		" + Line + "");
			}else {
			System.out.print("		" + Line + " ");
			}
			for(int Column = 1; Column < 11; Column++) {
				System.out.print(" " + Board[Line][Column] + " ");
			}
			
			System.out.println();
		}
		System.out.print("\n  		   ");
		for(int x = 1; x < 11; x++) {
			if( x <=9) {
		System.out.print(x + "  ");
		}else {
		System.out.print(x +" ");
		}
		}
		
		System.out.println();
		System.out.println("			Columns");
		}
	
	
	public void NominesOfSurroundingNeighbours() {
		for(int line = 1; line < 11; line++)
			for(int column = 1; column < 11; column++) {
			
				for(int i = -1; i <=1; i++)
					for(int j = -1; j <= 1; j++)
						if(mines[line][column] != -1)
							if(mines[line+i][column+j] == -1)
								mines[line][column]++;
			}
	}
	
	public void revealMines() {
		for(int i = 1; i < 11; i++)
			for(int j = 1; j < 11; j++)
				if(mines[i][j] == -1)
					Board[i][j] = '#';
		
		showMain();
	}
	
	public void startBoard() {
		for(int i = 1; i < mines.length; i++)
			for(int j = 1; j < mines.length; j++)
				Board[i][j] = '-';
	}
	
	public void initializeMines() {
		for(int i = 0; i < mines.length; i++)
			for(int j = 0; j < mines.length; j++)
				mines[i][j] = 0;
	}
	
	public void placeMines() {
		boolean raffled;
		int Line, Column;
		for(int i = 0; i < 12; i++) {
			do{
				Line = random.nextInt(10) + 1;
				Column = random.nextInt(10) + 1;
				
				if(mines[Line][Column] == -1)
					raffled = true;
				else
					raffled = false;
			}while(raffled);
			
			mines[Line][Column] = -1;
		}
	}
}

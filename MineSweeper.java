import *.Main; // *.import.

public class Minesweeper {
private Grid grid;
boolean finish = false;
int count=0;

public Minesweeper(){
    grid = new Grid();
    startGame(grid);
}

public static void main(String[] args) {
  new Minesweeper();
}

public void startGame(Grid grid){
    do{
        count++;
        System.out.println(count + "번째 선택"); 
        grid.showGrid(); // 지뢰찾기 배열을 보여주는 함수 호출
        finish = grid.readAndSet(); // 입력 값을 받고 검사, 배치하는 함수 호출

        if(!finish){
            grid.search(); // 주변 8개의 칸을 조사
            finish = grid.win();
        }

    }while(!finish);
    
    if(grid.win()) {
        grid.revealMines();
        System.out.println("축하합니다. 당신의 선택 횟수는  "+count+" 입니다. ");
        // 승리시 선택 횟수를 알려줌
    }
    else {
        grid.revealMines();
        System.out.println("아쉽습니다. 지뢰를 선택했습니다.");
        // 패배시 메시지만 출력

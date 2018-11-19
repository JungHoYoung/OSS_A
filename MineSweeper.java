import *.Main; // *.import.

public class MineSweeper {
private Main main;
boolean finish = false;
int count=0;

public MineSweeper(){
    main = new Main();
    startGame(main);
}

public static void main(String[] args) {
  new MineSweeper();
}

public void startGame(Main main){
    do{
        count++;
        System.out.println(count + "번째 선택"); 
        main.showGrid(); // 지뢰찾기 배열을 보여주는 함수 호출
        finish = main.readAndSet(); // 입력 값을 받고 검사, 배치하는 함수 호출

        if(!finish){
            main.search(); // 주변 8개의 칸을 조사
            finish = main.win();
        }

    }while(!finish);
    
    if(main.win()) {
        main.revealMines();
        System.out.println("축하합니다. 당신의 선택 횟수는  "+count+" 입니다. ");
        // 승리시 선택 횟수를 알려줌
    }
    else {
        main.revealMines();
        System.out.println("아쉽습니다. 지뢰를 선택했습니다.");
        // 패배시 메시지만 출력

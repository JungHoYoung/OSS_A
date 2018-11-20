

public class MineSweeper {
private Main main_M;
boolean finish = false;
int count=0;

public MineSweeper(){
    main_M = new Main();
    startGame(main_M);
}

public static void main(String[] args) {
  new MineSweeper();
}

public void startGame(Main main_M){
    do{
        count++;
        System.out.println(count + "번째 턴"); 
        main_M.showMain(); // 지뢰찾기 배열을 보여주는 함수 호출
        finish = main_M.readAndsetPosition(); // 입력 값을 받고 검사, 배치하는 함수 호출

        if(!finish){
            main_M.revealNeighbours(); // 주변 8개의 칸을 조사
            finish = main_M.win();
        }

    }while(!finish);
    
    if(main_M.win()) {
        main_M.revealMines();
        System.out.println("축하합니다. 당신은 " + count + "번째 턴에 이겼습니다. ");
        // 승리시 선택 횟수를 알려줌
    }
    else {
        main_M.revealMines();
        System.out.println("아쉽습니다. 지뢰를 선택했습니다.");
        // 패배시 메시지만 출력
    }
}
}

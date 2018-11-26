

import java.util.Scanner;

public class MineSweeper{
	private static Main main_M;
	private static Main_middle main_middle;
	private static Main_hard main_hard;
	
    static boolean finish = false;
    static int count=0;

    public MineSweeper(int Value){
        main_M = new Main();
        main_middle = new Main_middle();
        main_hard = new Main_hard();
         if(Value == 1) {
        	 startGame(main_M);
        	 return;
         }else if(Value == 2) {
        	 startGame(main_middle);
        	 return;
         }else {
        	 startGame(main_hard);
        	 return;
    }
    }
    

    public static void main(String[] args) {
      
     
      System.out.print("난이도를 입력하세요 (1~3): ");
      Scanner sc = new Scanner(System.in);
      int Value = sc.nextInt();
      
     
      if(Value == 1) {
    	
    	 System.out.println(Value + " 난이도 (하)");
    	 new MineSweeper(Value);
    	 startGame(main_M);
    	
    	 return;
    	 
     }else if(Value == 2){  
    	 System.out.println(Value + " 난이도 (중)");
    	 new MineSweeper(Value);
    	 startGame(main_middle);
     	 
    	 return;
     	 
     } else if(Value == 3){
    	 System.out.println(Value + " 난이도 (상)");
    	 new MineSweeper(Value);
    	 startGame(main_hard); 
      	 
    	 return;
      	 
     }
    }
    
    

    public static void startGame(Main main_M){
    	do{
        	
       
            		count++;
                    System.out.println(count + "번째 턴");
                    
                    main_M.showMain();                		// 지뢰찾기 배열을 보여주는 함수 호출
                    finish = main_M.readAndsetPosition();	// 입력 값을 받고 검사, 배치하는 함수 호출

                    if(!finish){
                        main_M.revealNeighbours(); 			// 주변 8개의 칸을 조사
                        finish = main_M.win();
                    }  
    	}while(!finish);

                    if(main_M.win()){
                        System.out.println("축하합니다. 당신은 " + count + "번째 턴에 이겼습니다. "); // 승리시 선택 횟수를 알려줌
                        main_M.revealMines();
                    } else {
                        System.out.println("아쉽습니다. 지뢰를 선택했습니다.");  				   // 패배시 메시지만 출력
                        main_M.revealMines();
                        System.exit(999);
                    }
    	}
    	
    
        public static void startGame(Main_middle main_middle) {
        	do{
            		count++;
                    System.out.println(count + "번째 턴");
                    
                    main_middle.showMain();                 	// 지뢰찾기 배열을 보여주는 함수 호출
                    finish = main_middle.readAndsetPosition();	// 입력 값을 받고 검사, 배치하는 함수 호출

                    if(!finish){
                    	main_middle.revealNeighbours();			// 주변 8개의 칸을 조사
                        finish = main_middle.win();
                    } 
        	}while(!finish);

                    if(main_middle.win()){
                        System.out.println("축하합니다. 당신은 " + count + "번째 턴에 이겼습니다. "); // 승리시 선택 횟수를 알려줌
                        main_middle.revealMines();
                    } else {
                        System.out.println("아쉽습니다. 지뢰를 선택했습니다.");					  // 패배시 메시지만 출력
                        main_middle.revealMines();
                        System.exit(999);
                    }
        }
        
        
        public static void startGame(Main_hard main_hard) {   		
        	do {
            		count++;
                    System.out.println(count + "번째 턴");
                    
                    main_hard.showMain();                		// 지뢰찾기 배열을 보여주는 함수 호출
                    finish = main_hard.readAndsetPosition();	// 입력 값을 받고 검사, 배치하는 함수 호출

                    if(!finish){
                    	main_hard.revealNeighbours();			// 주변 8개의 칸을 조사
                        finish = main_hard.win();
                    }
        	}
            	 while(!finish);

                 if(main_hard.win()){
                     System.out.println("축하합니다. 당신은 \" + count + \"번째 턴에 이겼습니다. ");	// 승리시 선택 횟수를 알려줌
                     main_hard.revealMines();
                 } else {
                     System.out.println("아쉽습니다. 지뢰를 선택했습니다.");							 // 패배시 메시지만 출력
                     main_hard.revealMines();
                 }
            	
        }
        
 
}

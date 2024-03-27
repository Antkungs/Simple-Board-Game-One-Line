package lab7_simpleboardgame;
import java.util.Scanner;

public class Game {
    
    private Dice dice;
    private Board board;
    private Figure figure1;
    private Figure figure2;
    private Figure currentFigure;
    
    public Game(char name1,char name2){
        board = new Board();
        figure1 = new Figure(name1);
        figure2 = new Figure(name2);
        currentFigure = figure1; // ให้ player 1 เริ่มก่อน
    }
    
    public void start(){
        Scanner scan = new Scanner(System.in);
        board.setBoard(figure1,figure2);
        while(true){
           currentFigure.move(board,figure1,figure2,currentFigure); //ทำการทอยและเปลี่ยนตำแหน่ง
           board.printBoard(currentFigure); //แสดงกระดาษพร้อมหมาก
           //เช็คหาผผู้ชนะโดยยึดตาม currentFigure
           if(checkWin(currentFigure)){
               System.out.println("\n !!Congratulations!! \n    "+currentFigure.getName()+" is Winner!!!");
               System.out.println("    Thank for play ");
               break;
           }
           //สลับplayer 1 to 2 || 2 to 1
        currentFigure = (currentFigure == figure1) ? figure2 : figure1;
        System.out.println("\nPress enter to see the next turn ...");
        String enterkey = scan.nextLine();  
        
       }
    }
    //method เช็คหาผู้ชนะ
    public boolean checkWin(Figure currentPlayer){
        //return x = ถ้าcurrentPlayer อยู่ในตำแหน่งที่มากกว่าหรือเท่ากับ maxBoardSize ให้ส่งค่า true       
        return (currentPlayer.getPosition() >= board.getSize()-1);
    }
}

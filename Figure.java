package lab7_simpleboardgame;

public class Figure {
    
    private char name;
    
    private int position;
    private int move;
    
    public Figure(char name){
        this.name = name;
    }
    //เปลี่ยนตำแหน่ง
    public void move(Board board,Figure n1,Figure n2,Figure currentFigure){
        while(true){           
            //สุ่มเลขเพื่อเปลี่ยนตำแหน่งที่อยู่
            currentFigure.move = Dice.diceRandom();
            //เปลี่ยนตำแหน่งที่อยู่
            currentFigure.position += currentFigure.move;
            //เช็คว่าตำแหน่งของตัวที่เดินนั้นเดินไปทับอีกตัวหรือไม่ ถ้าทับให้ทำการสุ่มใหม่
            if(n1.position == n2.position){
                //ลบการเดิน และทำการวนลูปไปสุ่มใหม่
                currentFigure.position -= currentFigure.move;
                currentFigure.move = Dice.diceRandom();
                continue;
            }
            //ทำการแสดงผล และเรียกใช้ method board.moveFigure เพื่อทำการเปลี่ยนตำแหน่งบนกระดานให้ตรง
            else{
                currentFigure.position = (currentFigure.position > board.getSize() ) ? currentFigure.position = board.getSize() : currentFigure.position;
                
                board.moveFigure(currentFigure);
                break;//ออกลูปเพื่อทำการสลับการเดิน
            }
        }
    }   
    //getter & setter   
    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getPosition() {
        return position-1;
    }

    public void setPosition(int position) {
        this.position = position;
    }  
    
    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}

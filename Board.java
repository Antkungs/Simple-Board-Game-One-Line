package lab7_simpleboardgame;

public class Board {
    private int size;
    private char[] cell; // 0-9
    
    public Board(){
        this.size = 10;
        this.cell = new char[size];
        for(int i = 0;i<size;i++){
            this.cell[i] = '_';
        }
    }
    
    public void setBoard(Figure n1,Figure n2){
        n1.setPosition(1);
        n2.setPosition(2);
        cell[0] = n1.getName();
        cell[1] = n2.getName();
        //ให้ player1 อยู่ที่ pos 1 (cell[0]) && ให้ player2 อยู่ที่ pos 2 (cell[1])
        printBoard();
    }
    
    public void moveFigure(Figure n){
        for(int i = 0;i<size;i++){
            if(cell[i] == n.getName()) cell[i] = '_'; 
            if((n.getPosition()) == i) cell[i] = n.getName();
        }
    }
    //แสดงผลของกระดาษ
    public void printBoard(){
        System.out.println("######################");
        System.out.println("#    set up game!!   #");
        System.out.print("#");
        for(int i = 0;i<size;i++){
            System.out.print(cell[i]+" ");
        }
        System.out.print("#");
        System.out.println("\n######################");
    }
    
    public void printBoard(Figure currentFigure){
        
        System.out.println("\n\n       "+currentFigure.getName()+"'s turn     ");
        System.out.println("######################");
        System.out.println("#    "+currentFigure.getName()+"'move "+currentFigure.getMove()+" slot   #");       
        System.out.print("#");
        for(int i = 0;i<size;i++){
            System.out.print(cell[i]+" ");
        }
        System.out.print("#");
        System.out.println("\n######################");
        
    }

    //getter & setter
    public char[] getCell() {
        return cell;
    }

    public void setCell(char[] cell) {
        this.cell = cell;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}

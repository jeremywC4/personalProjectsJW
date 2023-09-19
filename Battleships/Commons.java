import java.util.Scanner;

class Commons{
  Scanner sc = new Scanner(System.in);
  
  //prompts for row from user
  public int rowPrompt(){
    int row = 0;
    String guess = "";
    while(true){
      System.out.println("Select Row (A-J)");
      guess = (sc.next()).toUpperCase();
      if(guess.equals("A")){
        row = 1;
        break;
      }else if(guess.equals("B")){
        row = 2;
        break;
      }else if(guess.equals("C")){
        row = 3;
        break;
      }else if(guess.equals("D")){
        row = 4;
        break;
      }else if(guess.equals("E")){
        row = 5;
        break;
      }else if(guess.equals("F")){
        row = 6;
        break;
      }else if(guess.equals("G")){
        row = 7;
        break;
      }else if(guess.equals("H")){
        row = 8;
        break;
      }else if(guess.equals("I")){
        row = 9;
        break;
      }else if(guess.equals("J")){
        row = 10;
        break;
      }
    }
    return row;
  }

  //prompts for col from user
  public int colPrompt(){
    String guess = "";
    int col = 0;
    while(true){
      System.out.println("Select Column (1-10)");
      guess = sc.next();
      try{
        col = Integer.parseInt(guess);
        if(col>0&&col<11){
          break;
        }
      }catch(NumberFormatException e){
        System.out.println("Invalid Input");
      }
    }
    return col;
  }
    

  //prints out the board given (any)
  public void printBoard(String[][] board){
    for (String[] x : board){
      for (String y : x){
        System.out.print(y + " ");
      }
      System.out.println();
    }
  }
  
  //prints out the board given (bot's board)
  public void printPOV(String[][] board){
    System.out.println("\nHAL-9K's BOARD");
    for (String[] x : board){
      for (String y : x){
        System.out.print(y + " ");
      }
      System.out.println();
    }
  }

  //prints our the board given (user's board)
  public void printBotBoard(String[][] board){
      System.out.println("\t\t\t\t\t\tYOUR BOARD");
    for(String[] x : board){
      System.out.print("\t\t\t\t\t\t");
      for (String y : x){
        System.out.print(y + " ");
      }
      System.out.println();
    }
  }
}
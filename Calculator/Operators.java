import java.util.Scanner;

public class Operators{
  
  private String equation;
  private int secondEndIndex;
  private int firstStartIndex;
  private double answer;
  private double firstNum;
  private double secondNum;
  private Scanner scan = new Scanner(System.in);


  //parentheses equation
  public String doParenthesis(String equation){
    if(!equation.contains("(")){
      return equation;
    }else{
      String inParenthesis;
      String answer;
      //finds the last "(" and first ")"
      for(int i = equation.length()-1; i>=0; i--){
        if(equation.substring(i,i+1).equals("(")&&i<equation.indexOf(")")){
          inParenthesis = equation.substring(i+1, equation.indexOf(")"));
          answer = calc(inParenthesis);
          equation = equation.substring(0,i) + answer + equation.substring(equation.indexOf(")")+1);
          break;
        }
      }
      return doParenthesis(equation);
    }
  }
  

  //exponent method
  public String doExponent(String equation){
    if(!equation.contains("^")){
      return equation;
    }else{
      
      //finds first number index
      firstStartIndex = equation.indexOf('^')-1;
  while(Character.isDigit(equation.charAt(firstStartIndex))||equation.charAt(firstStartIndex)==('.')||equation.charAt(firstStartIndex)==('-')){
        if(firstStartIndex>0){
          firstStartIndex-=1;  
        }else{
          break;
        }
      }
  
      if(firstStartIndex!=0){       
        firstStartIndex+=1;
      }
      
      //finds second number end index
      secondEndIndex = equation.indexOf('^')+1;
  while(Character.isDigit(equation.charAt(secondEndIndex))||equation.charAt(secondEndIndex)==('.')||equation.charAt(secondEndIndex)==('-')){
          if(secondEndIndex==equation.length()-1){ 
            secondEndIndex+=1;                       
            break;                           
          }
          if(secondEndIndex<equation.length()){
            secondEndIndex+=1;
          }else{
            break;
          }
        }
    
    //creates first number
    System.out.println("firstStartIndex = " + firstStartIndex);
    firstNum = Double.parseDouble(equation.substring(firstStartIndex, equation.indexOf('^'))); 
    System.out.println("firstNum = " + firstNum);

    //creates second number
    secondNum = Double.parseDouble(equation.substring(equation.indexOf('^')+1,secondEndIndex));
    System.out.println("secondEndIndex = " + secondEndIndex);
    System.out.println("secondNum = " + secondNum);

    //does math
    answer = (Math.pow(firstNum, secondNum));
    System.out.println("answer = " + answer);

    //rewrites equation -- only need line - changed from firstStartIndex+1 to firstStartIndex
    if(firstStartIndex==0){
      equation = answer + equation.substring(secondEndIndex);
    }else{
      equation = equation.substring(0,firstStartIndex) + answer + equation.substring(secondEndIndex);
    }
      System.out.println("Equation: " + equation);
      //reruns method and recurses if needed
      return doExponent(equation);
    }
  }


  //division method
  public String doDivision(String equation){
    if(!equation.contains("/")){
      return equation;
    }else{
      
      //finds first number index
      firstStartIndex = equation.indexOf('/')-1;
  while(Character.isDigit(equation.charAt(firstStartIndex))||equation.charAt(firstStartIndex)==('.')||equation.charAt(firstStartIndex)==('-')){
      if(firstStartIndex>0){
        firstStartIndex-=1;
      }else{
        break;
      }
    }
      
    if(firstStartIndex!=0){
      firstStartIndex+=1;
    }
      
    //finds second number end index
    secondEndIndex = equation.indexOf('/')+1;
    while(Character.isDigit(equation.charAt(secondEndIndex))||equation.charAt(secondEndIndex)==('.')||equation.charAt(secondEndIndex)==('-')){
      if(secondEndIndex==equation.length()-1){
        secondEndIndex+=1;
        break;
      }
      if(secondEndIndex<equation.length()){
        secondEndIndex+=1;
      }else{
        break;
      }
    }
    
    //creates first number
    firstNum = Double.parseDouble(equation.substring(firstStartIndex, equation.indexOf('/')));
    System.out.println("firstStartIndex = " + firstStartIndex);
    System.out.println("firstNum = " + firstNum);

    //creates second number
    secondNum = Double.parseDouble(equation.substring(equation.indexOf('/')+1,secondEndIndex));
    System.out.println("secondEndIndex = " + secondEndIndex);
    System.out.println("secondNum = " + secondNum);

    //does math
    answer = (firstNum/secondNum);
    System.out.println("answer = " + answer);

    //rewrites equation
   if(firstStartIndex==0){
      equation = answer + equation.substring(secondEndIndex);
    }else{
      equation = equation.substring(0,firstStartIndex) + answer + equation.substring(secondEndIndex);
    }
    System.out.println("Equation: " + equation);
    //reruns method and recurses if needed
    return doDivision(equation);
    }
  }

  
  //multiplication method
  public String doMultiplication(String equation){
    if(!equation.contains("*")){
        return equation;
    }else{
      
      //finds first number index
      firstStartIndex = equation.indexOf('*')-1;
  while(Character.isDigit(equation.charAt(firstStartIndex))||equation.charAt(firstStartIndex)==('.')||equation.charAt(firstStartIndex)==('-')){
        if(firstStartIndex>0){
          firstStartIndex-=1;
        }else{
          break;
        }
      }
      
      if(firstStartIndex!=0){
        firstStartIndex+=1;
      }
      
      //finds second number end index
      secondEndIndex = equation.indexOf('*')+1;
  while(Character.isDigit(equation.charAt(secondEndIndex))||equation.charAt(secondEndIndex)==('.')||equation.charAt(secondEndIndex)==('-')){
          if(secondEndIndex==equation.length()-1){
            secondEndIndex+=1;
            break;
          }
          if(secondEndIndex<equation.length()){
            secondEndIndex+=1;
          }else{
            break;
          }
        }
      
      //creates first number
      firstNum = Double.parseDouble(equation.substring(firstStartIndex, equation.indexOf('*')));
      System.out.println("firstStartIndex = " + firstStartIndex);
      System.out.println("firstNum = " + firstNum);
  
      //creates second number
      secondNum = Double.parseDouble(equation.substring(equation.indexOf('*')+1,secondEndIndex));
      System.out.println("secondEndIndex = " + secondEndIndex);
      System.out.println("secondNum = " + secondNum);
  
      //does math
      answer = (firstNum*secondNum);
      System.out.println("answer = " + answer);
  
      //rewrites equation
      if(firstStartIndex==0){
        equation = answer + equation.substring(secondEndIndex);
      }else{
        equation = equation.substring(0,firstStartIndex) + answer + equation.substring(secondEndIndex);
      }
      
      //reruns method and recurses if needed
      return doMultiplication(equation);
    }
  }
  

  //addition method
  public String doAddition(String equation){
    if(!equation.contains("+")){
      return equation;
    }else{
      
      //finds first number index
      firstStartIndex = equation.indexOf('+')-1;
  while(Character.isDigit(equation.charAt(firstStartIndex))||equation.charAt(firstStartIndex)==('.')||equation.charAt(firstStartIndex)==('-')){
        if(firstStartIndex>0){
          firstStartIndex-=1;
        }else{
          break;
        }
      }
      
      //finds first number end index
      secondEndIndex = equation.indexOf('+')+1;
  while(Character.isDigit(equation.charAt(secondEndIndex))||equation.charAt(secondEndIndex)==('.')||equation.charAt(secondEndIndex)==('-')){
          if(secondEndIndex==equation.length()-1){
            secondEndIndex+=1;
            break;
          }
          if(secondEndIndex<equation.length()){
            secondEndIndex+=1;
          }else{
            break;
          }
        }
  
        if(firstStartIndex!=0)
        firstStartIndex+=1;
      
      //creates first number
      firstNum = Double.parseDouble(equation.substring(firstStartIndex, equation.indexOf('+')));
      System.out.println("firstStartIndex = " + firstStartIndex);
      System.out.println("firstNum = " + firstNum);
  
      //creates second number
      secondNum = Double.parseDouble(equation.substring(equation.indexOf('+')+1,secondEndIndex));
      System.out.println("secondEndIndex = " + secondEndIndex);
      System.out.println("secondNum = " + secondNum);
  
      //does math
      answer = (firstNum+secondNum);
      System.out.println("answer = " + answer);
  
      //rewrites equation
      if(firstStartIndex==0){
        equation = answer + equation.substring(secondEndIndex);
      }else{
        equation = equation.substring(0,firstStartIndex) + answer + equation.substring(secondEndIndex);
      }
        
      System.out.println("Equation: " + equation);
        
      return doAddition(equation);
    }
  }

  
  public void calculate(){
    System.out.println("\nWhat would you like to calculate?");
    equation = scan.nextLine();
    equation = equation.toLowerCase();
    equation = equation.replace(" ", "");
    equation = equation.replace("--", "+");
    equation = equation.replace("-", "+-");
    //if equation starts with a negative
    if(equation.indexOf("+")==0){
      equation = equation.substring(1);
    }
    System.out.println("Equation: " + equation);
    doMath(equation);
  }

  
  public void doMath(String equation){
    equation = doParenthesis(equation);
    equation = doExponent(equation);
    equation = doDivision(equation);
    equation = doMultiplication(equation);
    equation = doAddition(equation);
    //subtraction is done implicitly in the addition method
  }
  
  public String calc(String equation){
    equation = doExponent(equation);
    equation = doDivision(equation);
    equation = doMultiplication(equation);
    equation = doAddition(equation);
    //subtraction is done implicitly
    return equation;
  }
  
}
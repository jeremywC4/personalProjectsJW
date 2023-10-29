import java.util.ArrayList;
import java.util.Collections;

public class Scores{

  private int streak = 1;
  private int currentScore;
  private int maxScore = 0;
  ArrayList<Integer> highScores = new ArrayList<Integer>();
  
  public Scores(){}
  
  public void addToScore(){
    currentScore += 100*streak;
    System.out.println("Streak: x" + streak + " Multiplier");
  }
  
  public int returnScore(){
    return currentScore;
  }

  public void resetScore(){
    currentScore = 0;
  }

  public void increaseStreak(){
    streak += 1;
  }

  public void resetStreak(){
    streak = 1;
  }

  //need to implement a target counter in gamepanel (user inputs how many they want)
  public int maxPossible(int allTargets){
    if(allTargets == 0){
      System.out.println("Maximum Score Possible: " + maxScore);
      return maxScore;
    }else{
      maxScore += 100*allTargets;
      return maxPossible(allTargets-1);
    }
  }

  public void gameOver(){
    highScores.add(currentScore);
    resetStreak();
    resetScore();
    if(highScores.size()>1)
      sortHighScores();
  }

  //precondition - size > 1
  public void sortHighScores(){
    for(int i = 0; i < highScores.size()-1; i++){
      for(int k = 0; k < highScores.size()-1; k++){
        if(highScores.get(k) < highScores.get(k+1)){
          Collections.swap(highScores, k+1, k);
        }
      }
    }
  }
  public void printList(){
    for(int i:highScores){
      System.out.println(i);
    }
  }
  public ArrayList<Integer> getHighScores(){
    return highScores;
  }
  
}
import java.util.*;

public class task1_NumberGame {

    public static void main(String[] args) {
        
        task1_NumberGame game=new task1_NumberGame();
        game.gamestart();
        
    }

    public void gamestart(){
        Scanner sc=new Scanner(System.in);
        System.out.println("This is the number guessing game..!!");
        System.out.println("You have 10 attempts to guess the number..!");

        int n1=1;
        int n2=100;
        

        Random random=new Random();

        int randomnum=random.nextInt(n2-n1+1)+n1;
        int guessnum = 0;
        int numOfRound=1;
        int attempts=10;

        while(numOfRound<=attempts){
                System.out.println(numOfRound+". Guess the number:");
                guessnum = sc.nextInt();
                numOfRound = numOfRound + 1;
    
                if(guessnum < randomnum){
                    System.out.println("Entered number is low.Try again");
                }
    
                else if(guessnum > randomnum){
                    System.out.println("Entered number is high.Try again");
                }
                
                else {
                    System.out.println("\nCongratulations. You have guessed the number "+randomnum+" in "+numOfRound+" tries");
                    return;
                }
            }
                System.out.println("\nSorry,you have run out of attempts.The correct number is "+randomnum);
                sc.close();
        
        
        
    }
}
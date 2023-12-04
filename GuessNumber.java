import java.util.Random;

import javax.swing.JOptionPane;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();

        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int roundsWon = 0;
        int totalAttepmt=0;

        JOptionPane.showMessageDialog(null, "WellCome Number Guessing Game");
     do{
        int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        int attepmt = 0;
         JOptionPane.showMessageDialog(null,"round"+(roundsWon+1)+ " I think your Numbei in" + maxNumber + "and" + minNumber);
        JOptionPane.showMessageDialog(null, "You have chances" + maxAttempts);

     while (attepmt< maxAttempts) {
            String guessnumber = JOptionPane.showInputDialog("Enter Guess Number :");
            int GuessNumber = Integer.parseInt(guessnumber);
            attepmt++;
            totalAttepmt++;

            if (GuessNumber == randomNumber) {
                JOptionPane.showMessageDialog(null,
                        "Congratulations! You guessed the number " + randomNumber + " in " +attepmt
                                + " attempts.");
                break;

            } else if (GuessNumber < randomNumber) {

                JOptionPane.showMessageDialog(null, "Too low. Try again.");

            } else {
                JOptionPane.showMessageDialog(null, "Too high. Try again.");

            }
        }

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                roundsWon++;
               //JOptionPane.showMessageDialog(null, "User chose Yes. Continuing...");
              
               

            } else{
                JOptionPane.showMessageDialog(null, "User chose No. Exiting..." +totalAttepmt);
              break;
            }
           
            //  else if (choice == JOptionPane.CLOSED_OPTION) {
            //  JOptionPane.showMessageDialog(null, "Dialog closed without making a choice.");
            // }while(true);
        

            }while(true);
    }
    
    }


    


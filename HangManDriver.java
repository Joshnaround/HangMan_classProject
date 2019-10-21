import java.util.Scanner;//needed for Scanner class
import java.io.*; //needed for File and IOException
import java.util.ArrayList;
import java.util.Random;
/** Take Home test 2. HangMan Game
 * This game takes in a random phrase from a user selected txt file for hangman game
 *
 * @author Joshua herrera
 * @version 10/18/2019
 */
public class HangManDriver
{
    public static void main(String[] args) throws IOException
    {
        Scanner in;//a reference that will point to an Scanner object
        Scanner input;//a referecence that will point to an Scanner object for files
        char guess;//local variable that holds user input for the letter they guess
        boolean[] lettersUsed = new boolean[2000];//creates array list of letters the users guess
        int menuOp;//local variabl that holds user input for the menu option
        String result = null;//hold the random string
        Random r = new Random();//creates new Random objects
        in = new Scanner(System.in);//creates new Scanner object


        //This displays a menu for the user to selct a category of phrases to guess from
        //Takes in users choice and tests it in an if loop
        //inside the if loop it imports correct file
        //adds all lines to array list
        //gets random line from array list
        //sets random line equal to result variable
        System.out.println("Category of Phrases");
        System.out.println("-------------------");
        System.out.println("1. Cartoon Characters\n2. Video Game Titles\n3. Movie Stars\n4. Items in Minecraft\n5. Photography Locations \n ");
        System.out.println("Enter the number corrisponding with the category you would like to play:  ");
        menuOp = in.nextInt();
        in.nextLine();
        if(menuOp == 1)
        {
          ArrayList<String> arrayList = new ArrayList<>();
          input = new Scanner(new File("CartoonCharacters.txt"));
          while (input.hasNext())
          {
              arrayList.add(input.nextLine());
          }
          result = arrayList.get(r.nextInt(arrayList.size()));
          input.close();
        }

        if(menuOp == 2)
        {
          ArrayList<String> arrayList = new ArrayList<>();
          input = new Scanner(new File ("videogameTitles.txt"));
          while (input.hasNext())
          {
              arrayList.add(input.nextLine());
          }
          result = arrayList.get(r.nextInt(arrayList.size()));
          input.close();
        }

        if(menuOp == 3)
        {
          ArrayList<String> arrayList = new ArrayList<>();
          input = new Scanner(new File ("movieStars.txt"));
          while (input.hasNext())
          {
              arrayList.add(input.nextLine());
          }
          result = arrayList.get(r.nextInt(arrayList.size()));
          input.close( );
        }

        if(menuOp == 4)
        {
          ArrayList<String> arrayList = new ArrayList<>();
          input = new Scanner(new File ("itemsinMinecraft.txt"));
          while (input.hasNext())
          {
              arrayList.add(input.nextLine());
          }
          result = arrayList.get(r.nextInt(arrayList.size()));
          input.close( );
        }

        if(menuOp == 5)
        {
          ArrayList<String> arrayList = new ArrayList<>();
          input = new Scanner(new File ("photographyLocations.txt"));
          while (input.hasNext())
          {
              arrayList.add(input.nextLine());
          }
          result = arrayList.get(r.nextInt(arrayList.size()));
          input.close( );
        }

        //creates new HangMan object and sends random phrase
        HangMan usersPhrase = new HangMan(result);

        //prints out separation line and dashes inplace inplace of phrase to guess
        System.out.println("\n" + usersPhrase.toString());

        //Run while loop with correct() isnt true & getEndGame() isnt lettersUsed
        //run do loop while the letter they guess hasnt already been guessed
        //do loop prompts user to enter the letter they want to guess
        //prints "you guessed that letter already" if they guessed that letters
        //if they havent guessed that letter is calls searchPhrase method with letters
        //prints to string containing line separation, dashes inplace of phrase and HangMan
        //if the letter they guessed is incorrect
        while(usersPhrase.correct() != true && usersPhrase.getEndGame() != true)
        {
            do
            {
                System.out.print("\nEnter your character: ");
                guess = in.nextLine().charAt(0);

                if (lettersUsed[guess])
                {
                    System.out.println("You guessed that letter already.");
                }
            }
            while (lettersUsed[guess]);
            lettersUsed[guess] = true;
            usersPhrase.searchPhrase(guess);
            System.out.println("\n" + usersPhrase.toString());
        }

        //prints Correct if users phrase is correct
        if (usersPhrase.correct())
        {
            System.out.println("Correct! You guessed the phrase!");
        }

        //Prints GameOver at end of game
        System.out.println("Game Over");

    }
}

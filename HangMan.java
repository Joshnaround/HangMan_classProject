
/** Take Home test 2. HangMan Game
 * This game takes in a random phrase from a user selected txt file for hangman game
 *
 * @author Joshua herrera
 * @version 10/18/2019
 */
public class HangMan
{
    private String phrase;//the phrase the user is trying to guess
    private StringBuilder guess;//the string builder for the phrase the user is trying to guess
    private StringBuilder drawHangman;//the string builder to draw the hangman
    private int incorrect;//holds the number of incorrect guesses
    private boolean endGame;//holds the boolean to run or end the game

    /**The no-args constructor that sets incorrect to zero, endgame to false,
     *and creates 2 string builder objects and 1 new string object for the phrase
     *
     */
    public HangMan()
    {
        incorrect = 0;
        endGame = false;
        guess = new StringBuilder();
        phrase = new String();
        drawHangman = new StringBuilder();
    }

    /**This constructor takes in a phrase and creates a new phrase object with @param String inPhrase
     * and appends stringBuilder guess to hold dashes to the length of the phrase
     * @param String inPhrase - the phrase the user is tryint to guess
     *
     */
    public HangMan(String inPhrase)
    {
        phrase = new String(inPhrase);
        guess = new StringBuilder();
        drawHangman = new StringBuilder();
        for (int i = 0; i < phrase.length(); ++i)
        {
            guess.append("_ ");
        }


        drawHangman = new StringBuilder();

        incorrect = 0;
        endGame = false;
    }


    /** the searchPhrase method excepts @param char letter and indexes the phrase for the letter guessed,
    *if correct it sets the dashes that corrispond with the letter to the letter guessed, if incorrect
    *it adds 1 to incorrect guess variable and calls drawhangman
    *@param char letter - users inputed letter guess for phrase
    *
    */
    public void searchPhrase(char letter)
    {
        int count = 0;
        int pos;
        for (pos = 0, pos = phrase.indexOf(letter); pos != -1; pos = phrase.indexOf(letter, pos + 1))
        {
            ++count;
            guess.setCharAt(pos * 2, letter);
        }
        if (count == 0)
        {
            ++incorrect;
            drawHangMan(incorrect);
        }
    }

    /**The correct method returns boolean correct:  true or false
    * uses for loop to run if statment the length of the phrase. If statement tests
    *every char in phrase to users guess char
    *@return Correct
    */
    public boolean correct()
    {
        boolean correct = true;

        for (int i = 0, j = 0; i < phrase.length() && correct; ++i, j += 2)
        {
            if (phrase.charAt(i) != guess.charAt(j))
            {
                correct = false;
            }
        }

        return correct;
    }

    /**The drawHangMan method takes the int value of the incorrect guess (@param int incorrect) and tests
    *value through a series of if statements that will append drawHangMan StringBuilder and draw the
    *hangman.
    *Once the user has made 7 incorrect guess it will finish drawing the hangman and set boolean endGame to true.
    */
    public void drawHangMan(int incorrect)
    {
        if(incorrect == 1)
        {
           drawHangman.append("\n\t\t\t 0");
        }

        if(incorrect == 2)
        {
            drawHangman.append("\n\t\t       /");
        }

        if(incorrect == 3)
        {
            drawHangman.append(" |");
        }

        if(incorrect == 4)
        {
            drawHangman.append(" \\");
        }

        if(incorrect == 5)
        {
            drawHangman.append("\n\t\t         |");
        }

        if(incorrect == 6)
        {
            drawHangman.append("\n\t\t        /");
        }

        if(incorrect == 7)
        {
            drawHangman.append(" \\\n\n        GameOver, You Loose!!\n");
            endGame = true;
        }
    }

    /**The getEndGame method returns boolean endGame either true or false
    * @return endGame
    */
    public boolean getEndGame()
    {
        return endGame;
    }


    /** The toString method returns a string that displays a sepration line followed by the stringBuilder for
     * the phrase that has been appended to dashes and will change to display users correct letter and hangman
     *
     * @return String
     */
    public String toString()
    {
        return new String("\n***************************************\n" + (Object)guess + "\n" + drawHangman.toString());
    }



}

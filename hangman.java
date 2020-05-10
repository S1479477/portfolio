/*
 * Name: Joseph Summerlin
 * Date: 1.18.2019
 * Description: Hangman Game
 */
import java.util.Scanner; //imports scanner utility
import java.util.Random;    //imports random utility
public class hangman {
    private static final Random randomNumbers = new Random();
    
        public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in); //all purpose scanner
            Scanner names = new Scanner(System.in); //scanner for names
            //string buffers for letter selection
            StringBuffer sb = new StringBuffer();   
            StringBuffer buffer = new StringBuffer();
            String wordToGuess;
            //variables
            int test = 0;
            double wins = 0.00;
            double losses = 0.00;
            int wordLength;
            int wordToGuessLength;
            int position;
            int livesLost = 1;
            int totalLives = 7;
            int lettersRemaining;
            boolean guessInWord;
            char guess;
            
            double games = 0.00;
            double winP;
            double lossP;
            //char choices = ' ';
            StringBuffer prevGuessedLetters; 
            
            Scanner input = new Scanner(System.in);
            char choices;
            
            System.out.println("Enter your name: ");
            String name = names.nextLine();
        
            //declare variable
            //String wordToGuess[] = new String[29];
            //insert array for words and their values
        
            String[] fast_food = new String[]{"fries","burger","shake","cheese","ketchup","icecream","cheeseburger","pickle","mustard","drink"}; //word bank for fast food category
            String[] presidents = new String[]{"trump","obama","bush","reagan","lincoln","washington","kennedy","wilson","jackson","jefferson"};    //word bank for presidents category
            String[] school = new String[]{"pencil","class","lunch","learning","bell","notebook","backpack","play","laptop","folder"};  //word bank for school category
            String[] cars = new String[]{"turbo","burnout","drift","horsepower","footpounds","tires","oil","antifreeze","fluids","race"};   //word bank for cars category
            String[] farming = new String[]{"plow","crops","fertilizer","mill","barn","cattle","truck","prod","fence","scarecrow"}; //word bank for farming category
            //Display the rules of the game
                System.out.printf("You are playing the game Hang Man. You have to guess the letters in the word.%nYou will see how many letters are in the word and you have 7 changes to be wrong.%n%n");
              do
              {  
               //reinitializes variables for game
                sb = new StringBuffer();
                buffer = new StringBuffer();
                wordToGuess = " ";
                test = 0;
               
                wordLength = 0;
                wordToGuessLength = 0;
                position = 0;
                livesLost = 1;
                totalLives = 7;
                lettersRemaining = 0;
                guessInWord = true;
                guess = ' ';
                //char choices = ' ';
                prevGuessedLetters = new StringBuffer();
                
                input = new Scanner(System.in);
                choices = ' ';   
                //random category selection
                switch(randomNumbers.nextInt(5))
                {
                    case 0:
                        {
                            System.out.println("The category is fast food");
                            wordToGuess = fast_food[(int) (Math.random() * fast_food.length)];
                            wordLength = wordToGuess.length();
                            System.out.println("Wins: " + wins);
                            System.out.println("Losses: " + losses);
                            System.out.println("The word you are quessing has " + wordLength + " letters in it");
                            lettersRemaining = wordLength;
                            //outputs empty blanks
                            for (position = 0; position < wordLength; position++) 
                            {
                                sb.append("_ ");
                            }
                            System.out.println(sb.toString());
                    
                            //loop for checking letters
                            while (lettersRemaining > 0 && totalLives >= 0) {
                                //prompt user to guess a letter
                                System.out.println("Guess a letter:");
                                guess = myScanner.findWithinHorizon(".", 0).charAt(0);
                        
                                //check if the letter guessed is in the secretWord
                                guessInWord = (wordToGuess.indexOf(guess)) != -1;
                                
                                //user guesses incorrectly
                                if (guessInWord == false) {
                                    
                                    System.out.print("Sorry, " + name + " you have lost a life. You still have ");
                                    totalLives -= livesLost;
                                    
                                    System.out.print(totalLives);
                                    System.out.println(" life/lives left. Keep trying.");
                                    printhm(totalLives);
                                    
                                    //user guesses correctly
                                } else {
                                    System.out.println("That was a good guess " + name + ", well done!");
                        
                                    //outputs blanks with letter position
                                    for (position = 0; position < wordLength; position++) {
                                        //outputs letter in correct position of unguessed word
                                        if (wordToGuess.charAt(position) == guess) {
                                            System.out.print(guess + " ");
                                            lettersRemaining--;
                                            
                                            //outputs underscore instead of unguessed letter
                                        } else {
                                            System.out.print("_ ");
                                        }
                                    }
                                }
                                System.out.println();
                                prevGuessedLetters = buffer.append(guess);
                                System.out.print("Previously guessed letters: ");
                                System.out.println(prevGuessedLetters);
                                System.out.print("Letters remaining: ");
                                System.out.println(lettersRemaining);
                            }
                            
                            //user loses
                            if (totalLives <= test) {
                                System.out.println("Sorry " + name + ", you lose!");
                                System.out.println("The word you were trying to guess was " + wordToGuess);
                                losses++;
                                games++;
                                
                                //user wins
                            } else {
                                System.out.print("Well done, you win " + name + "! The word was ");
                                System.out.println(wordToGuess);
                                wins++;
                                games++;
                            }
                            break;
                        }    
                    case 1:
                        {
                            System.out.println("The category is presidents (last names)");
                            wordToGuess = presidents[(int) (Math.random() * presidents.length)];
                            wordLength = wordToGuess.length();
                            System.out.println("Wins: " + wins);
                            System.out.println("Losses: " + losses);
                            System.out.println("The word you are quessing has " + wordLength + " letters in it");
                            lettersRemaining = wordLength;
                            //outputs empty blanks of the word
                            for (position = 0; position < wordLength; position++) 
                            {
                                sb.append("_ ");
                            }
                            System.out.println(sb.toString());
                
                            //user starts guessing words
                            while (lettersRemaining > 0 && totalLives >= 0) {
                                //prompt user to guess a letter
                                System.out.println("Guess a letter:");
                                guess = myScanner.findWithinHorizon(".", 0).charAt(0);
                        
                                //check if the letter guessed is in the secretWord
                                guessInWord = (wordToGuess.indexOf(guess)) != -1;
                                
                                   //if user guesses incorrectly
                                if (guessInWord == false) {
                                    
                                    System.out.print("Sorry " + name + ", you have lost a life. You still have ");
                                    totalLives -= livesLost;
                                    
                                    System.out.print(totalLives);
                                    System.out.println(" life/lives left. Keep trying.");
                                    printhm(totalLives);
                                } else {
                                    //user guesses correct
                                    System.out.println("That was a good guess " + name + ", well done!");
                                    
                                    //outputs blanks with letter appended
                                    for (position = 0; position < wordLength; position++) {
                                        //outputs correct letter
                                        if (wordToGuess.charAt(position) == guess) {
                                            System.out.print(guess + " ");
                                            lettersRemaining--;
                                            
                                            //outputs underscore
                                        } else {
                                            System.out.print("_ ");
                                        }
                                    }
                                }
                                System.out.println();
                                prevGuessedLetters = buffer.append(guess);
                                System.out.print("Previously guessed letters: ");
                                System.out.println(prevGuessedLetters);
                                System.out.print("Letters remaining: ");
                                System.out.println(lettersRemaining);
                            }
                            //user loses
                            if (totalLives <= test) {
                                System.out.println("Sorry " + name + ", you lose!");
                                System.out.println("The word you were trying to guess was " + wordToGuess);
                                losses++;
                                games++;
                                
                                //user wins
                            } else {
                                
                                System.out.print("Well done, you win " + name + "! The word was ");
                                System.out.println(wordToGuess);
                                wins++;
                                games++;
                            }
                            break;
                        }
                    case 2:
                        {
                            System.out.println("The category is school.");
                            wordToGuess = school[(int) (Math.random() * school.length)];
                            wordLength = wordToGuess.length();
                            System.out.println("Wins: " + wins);
                            System.out.println("Losses: " + losses);
                            System.out.println("The word you are quessing has " + wordLength + " letters in it");
                            lettersRemaining = wordLength;
                            
                            //outputs blanks equal to word length
                            for (position = 0; position < wordLength; position++) 
                            {
                                sb.append("_ ");
                            }
                            System.out.println(sb.toString());
            
                            //user starts guessing
                            while (lettersRemaining > 0 && totalLives >= 0) {
                                //prompt user to guess a letter
                                System.out.println("Guess a letter:");
                                guess = myScanner.findWithinHorizon(".", 0).charAt(0);
                        
                                //check if the letter guessed is in the secretWord
                                guessInWord = (wordToGuess.indexOf(guess)) != -1;
                                
                                //user guesses incorrectly
                                if (guessInWord == false) {
                                    
                                    System.out.print("Sorry " + name + ", you have lost a life. You still have ");
                                    totalLives -= livesLost;
                                    
                                    System.out.print(totalLives);
                                    System.out.println(" life/lives left. Keep trying.");
                                    printhm(totalLives);
                                    
                                    //user guesses correctly
                                } else {
                                    System.out.println("That was a good guess " + name + ", well done!");
                        
                                    //outputs guess into empty blank
                                    for (position = 0; position < wordLength; position++) {
                                        
                                        //adds correct letter to correct blank
                                        if (wordToGuess.charAt(position) == guess) {
                                            System.out.print(guess + " ");
                                            lettersRemaining--;
                                            
                                            //adds blank to unguessed word
                                        } else {
                                            System.out.print("_ ");
                                        }
                                    }
                                }
                                System.out.println();
                                prevGuessedLetters = buffer.append(guess);
                                System.out.print("Previously guessed letters: ");
                                System.out.println(prevGuessedLetters);
                                System.out.print("Letters remaining: ");
                                System.out.println(lettersRemaining);
                            }
                            //user loses
                            if (totalLives <= test) {
                                System.out.println("Sorry " + name + ", you lose!");
                                System.out.println("The word you were trying to guess was " + wordToGuess);
                                losses++;
                                games++;
                                
                                //user wins
                            } else {
                                
                                System.out.print("Well done, you win " + name + "! The word was ");
                                System.out.println(wordToGuess);
                                wins++;
                                games++;
                            }
                            break;
                        }
                    case 3:
                        {
                            System.out.println("The category is cars.");
                            wordToGuess = cars[(int) (Math.random() * cars.length)];
                            wordLength = wordToGuess.length();
                            System.out.println("Wins: " + wins);
                            System.out.println("Losses: " + losses);
                            System.out.println("The word you are quessing has " + wordLength + " letters in it");
                            lettersRemaining = wordLength;
                            
                            //outputs blanks for word to guess
                            for (position = 0; position < wordLength; position++) 
                            {
                            sb.append("_ ");
                            }
                            System.out.println(sb.toString());
                    
                            //user begins guessing
                            while (lettersRemaining > 0 && totalLives >= 0) {
                                //prompt user to guess a letter
                                System.out.println("Guess a letter:");
                                guess = myScanner.findWithinHorizon(".", 0).charAt(0);
                        
                                //check if the letter guessed is in the secretWord
                                guessInWord = (wordToGuess.indexOf(guess)) != -1;
                                
                                    //user guesses incorrectly
                                if (guessInWord == false) {
                                    
                                    System.out.print("Sorry " + name + ", you have lost a life. You still have ");
                                    totalLives -= livesLost;
                                    
                                    System.out.print(totalLives);
                                    System.out.println(" life/lives left. Keep trying.");
                                    printhm(totalLives);
                                    
                                    //user guesses correctly
                                } else {
                                    
                                    System.out.println("That was a good guess " + name + ", well done!");
                                    
                                    //outputs correct guess with blanks
                                    for (position = 0; position < wordLength; position++) {
                                        
                                        //output letter to correct position
                                        if (wordToGuess.charAt(position) == guess) {
                                            System.out.print(guess + " ");
                                            lettersRemaining--;
                                            
                                            //output underscore
                                        } else {
                                            System.out.print("_ ");
                                        }
                                    }
                                }
                                System.out.println();
                                prevGuessedLetters = buffer.append(guess);
                                System.out.print("Previously guessed letters: ");
                                System.out.println(prevGuessedLetters);
                                System.out.print("Letters remaining: ");
                                System.out.println(lettersRemaining);
                            }
                            //user loses
                            if (totalLives <= test) {
                                System.out.println("Sorry " + name + ", you lose!");
                                System.out.println("The word you were trying to guess was " + wordToGuess);
                                losses++;
                                games++;
                                
                                //user wins
                            } else {
                                
                                System.out.print("Well done, you win " + name + "! The word was ");
                                System.out.println(wordToGuess);
                                wins++;
                                games++;
                            }
                            break;
                        }
                    case 4:
                        {
                            System.out.println("The category is farming.");
                            wordToGuess = farming[(int) (Math.random() * farming.length)];
                            wordLength = wordToGuess.length();
                            System.out.println("Wins: " + wins);
                            System.out.println("Losses: " + losses);
                            System.out.println("The word you are quessing has " + wordLength + " letters in it");
                            lettersRemaining = wordLength;
                            
                            //outputs underscore for each letter in word
                            for (position = 0; position < wordLength; position++) 
                            {
                                sb.append("_ ");
                            }
                            System.out.println(sb.toString());
                    
                            //user begins guessing
                            while (lettersRemaining > 0 && totalLives >= 0) {
                                //prompt user to guess a letter
                                System.out.println("Guess a letter:");
                                guess = myScanner.findWithinHorizon(".", 0).charAt(0);
                        
                                //check if the letter guessed is in the secretWord
                                guessInWord = (wordToGuess.indexOf(guess)) != -1;
                                
                                    //user guesses incorrectly
                                if (guessInWord == false) {
                                    
                                    System.out.print("Sorry, " + name + " you have lost a life. You still have ");
                                    totalLives -= livesLost;
                                    
                                    System.out.print(totalLives);
                                    System.out.println(" life/lives left. Keep trying.");
                                    printhm(totalLives);
                                    
                                    //user guesses correctly
                                } else {
                                    
                                    System.out.println("That was a good guess " + name + " , well done!");
                                    
                                    //appends correct guessed letter to unguessed word
                                    for (position = 0; position < wordLength; position++) {
                                        
                                        //outputs letter to unguessed word 
                                        if (wordToGuess.charAt(position) == guess) {
                                            System.out.print(guess + " ");
                                            lettersRemaining--;
                                            
                                            //outputs underscore for unguessed letter
                                        } else {
                                            System.out.print("_ ");
                                        }
                                    }
                                }
                                System.out.println();
                                prevGuessedLetters = buffer.append(guess);
                                System.out.print("Previously guessed letters: ");
                                System.out.println(prevGuessedLetters);
                                System.out.print("Letters remaining: ");
                                System.out.println(lettersRemaining);
                            }
                            //user loses
                            if (totalLives <= test) {
                                System.out.println("Sorry " + name + ", you lose!");
                                System.out.println("The word you were trying to guess was " + wordToGuess);
                                losses++;
                                games++;
                                
                            } else {
                                //user wins
                                System.out.print("Well done, you win " + name + "! The word was ");
                                System.out.println(wordToGuess);
                                wins++;
                                games++;
                            }
                            break;
                        }
                    
                }
                
                
                
            
            //checks if user wants to play again
            System.out.println("Would you like to play again? (y or n)");
            choices = input.next(".").charAt(0);
        } while (choices != 'n');
        //outputs game statistics
        winP = (wins / games);
        lossP = (losses / games);
        System.out.printf(name + " has won " + wins + " games.%n");
        System.out.printf(name + " has lost " + losses + " games.%n");
        System.out.printf("Percentage of Wins: " + (100 * winP));
        System.out.printf("%nPercentage of Losses: " + (100 * lossP));
    }
    //outputs hangman graphic for each life
    public static void printhm(int lives)
    {
        //7 lives
        if (lives == 7)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     %n");
            System.out.printf("|    %n");
            System.out.printf("|      %n");
            System.out.printf("|      %n");
            System.out.printf("___%n");
        }
        // 6 lives
        else if (lives == 6)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     O%n");
            System.out.printf("|    %n");
            System.out.printf("|     %n");
            System.out.printf("|    %n");
            System.out.printf("___%n");
        }
        // 5 lives
        else if(lives == 5)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     O%n");
            System.out.printf("|     |%n");
            System.out.printf("|     %n");
            System.out.printf("|    %n");
            System.out.printf("___%n");
        }
        // 4 lives
        else if(lives == 4)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     O%n");
            System.out.printf("|     |_%n");
            System.out.printf("|     %n");
            System.out.printf("|    %n");
            System.out.printf("___%n");
        }
        // 3 lives
        else if(lives == 3)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     O%n");
            System.out.printf("|    _|_%n");
            System.out.printf("|     %n");
            System.out.printf("|    %n");
            System.out.printf("___%n");
        }
        // 2 lives
        else if(lives == 2)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     O%n");
            System.out.printf("|    _|_%n");
            System.out.printf("|     |%n");
            System.out.printf("|    %n");
            System.out.printf("___%n");
        }
        // 1 life
        else if(lives == 1)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     O%n");
            System.out.printf("|    _|_%n");
            System.out.printf("|     |%n");
            System.out.printf("|    /%n");
            System.out.printf("___%n");
        }
        // final guess
        else if(lives == 0)
        {
            System.out.printf("%n_______%n");
            System.out.printf("|     |%n");
            System.out.printf("|     O%n");
            System.out.printf("|    _|_%n");
            System.out.printf("|     |%n");
            System.out.printf("|    //%n");
            System.out.printf("___%n");
        }
    }
}
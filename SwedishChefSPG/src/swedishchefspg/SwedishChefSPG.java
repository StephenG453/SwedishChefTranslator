import java.util.Arrays;
import java.util.Scanner;

public class SwedishChefSPG 
{
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);
    
    private String message; //Original message the user inputs
        
    private String[] splittedWords; //Splitted words of the original message
        
    public static void main(String[] args) 
    {
        SwedishChefSPG scSPG = new SwedishChefSPG();
        scSPG.obtainTheOriginalMessage();
        scSPG.putMessageIntoSubStringArray();
        scSPG.translateMessage();
        scSPG.takeMessageOutOfArray();
    }
    
    private void obtainTheOriginalMessage ()
    {
        System.out.println("Please enter the text: ");
        
        message = INPUT_SCANNER.nextLine(); //User enter the message they want translated        
    }
    
    private void putMessageIntoSubStringArray ()
    {
        splittedWords = message.split("\\s+");  //Seperate the words by spaces and put them into an array        
    }
    
    private boolean wasWordChanged = false; //Was a full word changed?
        
    private void translateMessage ()
    {
        for (int w = 0; w < splittedWords.length; w++)  //Go through every word in the message...
        {
            wasWordChanged = false;
            boolean was_w_ChangedTo_v = false;  //was the character 'w' already changed to 'v'?
            
            switch (splittedWords[w])   //Translate a full word if neccassary
            {
                case "and":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "und");
                    wasWordChanged = true;
                    break;
                case "And":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "Und");
                    wasWordChanged = true;
                    break;
                case "then":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "den");
                    wasWordChanged = true;
                    break;
                case "Then":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "Den");
                    wasWordChanged = true;
                    break;
                case "the":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "der");
                    wasWordChanged = true;
                    break;
                case "The":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "Der");
                    wasWordChanged = true;
                    break;
                case "yes":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "ya");
                    wasWordChanged = true;
                    break;
                case "Yes":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "Ya");
                    wasWordChanged = true;
                    break;
                case "which":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "vich");
                    wasWordChanged = true;
                    break;
                case "Which":
                    splittedWords[w] = splittedWords[w].replace(splittedWords[w], "Vich");
                    wasWordChanged = true;
                    break;
                default:
                    break;
            }
            
            if (!wasWordChanged)    //If a word was NOT changed... time to check for individual characters
            {    
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'x')
                {
                    splittedWords[w] = splittedWords[w].replace("x", "xy");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'w'
                        || splittedWords[w].charAt(0) == 'w');
                {
                    was_w_ChangedTo_v = true;
                    splittedWords[w] = splittedWords[w].replace("w", "v");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'W'
                        || splittedWords[w].charAt(0) == 'W');
                {
                    splittedWords[w] = splittedWords[w].replace("W", "V");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'd')
                {
                    splittedWords[w] = splittedWords[w].replace("d", "dy");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'p')
                {
                    splittedWords[w] = splittedWords[w].replace("p", "py");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'v'
                        || splittedWords[w].charAt(0) == 'v')
                {
                    if (!was_w_ChangedTo_v) //If w has NOT been changed prior...
                    {
                        splittedWords[w] = splittedWords[w].replace("v", "f");
                    } 
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'e')
                {
                    splittedWords[w] = splittedWords[w].replace("e", "ey");
                }                
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'r'
                    && splittedWords[w].charAt(splittedWords[w].length() - 2) == 'i')
                {
                    splittedWords[w] = splittedWords[w].replace("ir", "ur");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'r'
                    && splittedWords[w].charAt(splittedWords[w].length() - 2) == 'o')
                {
                    splittedWords[w] = splittedWords[w].replace("or", "ur");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'u'
                    && splittedWords[w].charAt(splittedWords[w].length() - 2) == 'o')
                {
                    splittedWords[w] = splittedWords[w].replace("ou", "oo");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'e'
                    && splittedWords[w].charAt(splittedWords[w].length() - 2) == 'u')
                {
                    splittedWords[w] = splittedWords[w].replace("ue", "oo");
                }
                if ((splittedWords[w].charAt(0) == 'T' && splittedWords[w].charAt(1) == 'h')
                        || (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'h'
                        && (splittedWords[w].charAt(splittedWords[w].length() - 2) == 'T')))
                {
                    splittedWords[w] = splittedWords[w].replace("Th", "D");
                }
                if ((splittedWords[w].charAt(0) == 't' && splittedWords[w].charAt(1) == 'h')
                        || (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'h'
                        && (splittedWords[w].charAt(splittedWords[w].length() - 2) == 't')))
                {
                    splittedWords[w] = splittedWords[w].replace("th", "d");
                }
                if (splittedWords[w].charAt(splittedWords[w].length() - 1) == 'k'
                    && splittedWords[w].charAt(splittedWords[w].length() - 2) == 'c'
                    && splittedWords[w].charAt(splittedWords[w].length() - 3) == 'i')
                {
                    splittedWords[w] = splittedWords[w].replace("ick", "ook");
                }
            }            
        }
    }
    
    private void takeMessageOutOfArray ()
    {
        String finalMessage = Arrays.toString(splittedWords).replaceAll(",|\\[|\\]", "");
        
        System.out.println(finalMessage);   //Print the completed translation in a nice format
    }
}

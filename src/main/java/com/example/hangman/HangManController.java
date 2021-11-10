package com.example.hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.*;


public class HangManController {

    /* The following three variables are final and should never be changed. The first is to generate a random word
     * and the corresponding hint. The next two are the word and hint put into variables. */
    private String[] wordAndHint = generateString();
    private String wordToGuess = wordAndHint[0];
    private String hint = wordAndHint[1];
    private int counterForLoss = 0;

    private String printedWord; // The printed word is the character array converted to a string.
    char[] currentPlaceHolder = generatePlaceHolder(wordToGuess); // Generates a blank placeholder for the word.

    /* This method will generate the random word/hint for the game.*/
    public static String[] generateString() {
        String[] finalArray = new String[2];
        HashMap<String, String> wordDictionary = new HashMap<String, String>();

        //Start Dictionary (Put words and hints inside here please. Words should be all caps.)
        wordDictionary.put("WOOD", " Used to build things ");
        wordDictionary.put("SNOW", " A cold percipitation ");
        wordDictionary.put("ICE SKATING", " Physical activity in winter ");
        wordDictionary.put("HOT CHOCOLATE", " A warm sweet drink ");
        wordDictionary.put("APPLE CIDER", " A warm sweet drink ");
        wordDictionary.put("GIFT", " Something you give to someone freely ");
        wordDictionary.put("REINDEER", " A relative of deer ");
        wordDictionary.put("ELF", " Pointy ears ");
        wordDictionary.put("FIREPLACE", " To keep you warm ");
        wordDictionary.put("CANDY", " Small sweets ");
        wordDictionary.put("HAT AND MITTENS", " You put on to keep you warm ");
        wordDictionary.put("CHRISTMAS TREE", " You decorate and display ");
        wordDictionary.put("WREATH", " Placed on door for decoration ");
        wordDictionary.put("MISTLETOE", " You kiss if you are under this ");
        wordDictionary.put("SLEIGH", " A form of transportation ");
        wordDictionary.put("COAL", " Helps keep a fire going ");
        wordDictionary.put("STOCKING", " Hung by fireplace ");
        wordDictionary.put("LIGHTS", " Decorate the tree with ");
        wordDictionary.put("COOKIES AND MILK", " Leave for Santa ");
        wordDictionary.put("ORNAMENTS", " Decorate the tree with ");
        wordDictionary.put("STORY BOOK", " Keeps Chrsitmas legends ");
        wordDictionary.put("CAROLERS", " Singing visitors ");
        wordDictionary.put("SNOWBALL FIGHT", " Fun sport in the snow ");
        wordDictionary.put("WRAPPING PAPER", " Decorate gifts with ");
        wordDictionary.put("BOW", " Decorate gifts with ");
        wordDictionary.put("FRUITCAKE", " Traditional Christmas Desert ");
        wordDictionary.put("SHOVEL", " To move dirt ");
        wordDictionary.put("CHIMNEY", " A part of the fireplace ");
        wordDictionary.put("GIVING", " Something you do during the holidays ");
        wordDictionary.put("SNOWMAN", " Make this outside ");
        wordDictionary.put("JINGLE BELLS", " Often used as decorating and making music ");
        wordDictionary.put("GINGERBREAD HOUSE", " Build this out of sweets ");
        wordDictionary.put("TRADITION", " Something you do annually ");
        wordDictionary.put("TINSEL", " Shiny decoration ");
        wordDictionary.put("ANGEL", " Has wings ");
        wordDictionary.put("BOOTS", " Worn to keep warm ");
        wordDictionary.put("CANDLE", " You light this ");
        wordDictionary.put("CHESTNUTS", " ...roasting on an open fire ");
        wordDictionary.put("FAMILY", " Who you spend the holiday's with ");
        wordDictionary.put("COLD", " The weather gets ");
        wordDictionary.put("DECORATIONS", " Displayed during the holidays ");
        wordDictionary.put("EVERGREEN", " A type of tree or scent ");
        wordDictionary.put("EGGNOG", " A holiday drink ");
        wordDictionary.put("GINGERBREAD", " A type of cookie ");
        wordDictionary.put("HOLIDAY", " When you celebrate ");
        wordDictionary.put("ICICLE", " Outside frozen ");
        wordDictionary.put("MUSIC", " Traditional way of celebrating ");
        wordDictionary.put("NUTCRACKER", " Wooden solider ");
        wordDictionary.put("PARADE", " Public tradition to celebrate ");
        wordDictionary.put("PEPPERMINT", " A scent or candy ");
        wordDictionary.put("PARTY", " A gathering for people ");
        wordDictionary.put("POINSETTIA", " A plant associated with Chrristmas ");
        wordDictionary.put("THE GRINCH", " Holiday killjoy ");
        wordDictionary.put("SNOW ANGEL", " Made in the snow ");
        wordDictionary.put("STAR", " In the sky or to top a tree ");
        wordDictionary.put("TREE TOPPER", " Used to decorate a tree ");
        wordDictionary.put("SWEATER", " Worn to keep warm ");
        wordDictionary.put("TURKEY", " Eaten during the holidays ");
        wordDictionary.put("VACATION", " Time spent away from work ");
        wordDictionary.put("CANDY CANE", " To eat or decorate with ");
        wordDictionary.put("POPCORN", " To eat or decorate with ");
        wordDictionary.put("BLIZZARD", " Winter storm ");
        wordDictionary.put("FELIZ NAVIDAD", " Holiday greeting ");
        wordDictionary.put("REUNION", " A get together ");
        wordDictionary.put("PARTRIDGE", " A holiday symbol ");
        wordDictionary.put("PINECONE", " Grown on evergreen trees ");
        wordDictionary.put("PIE", " A holiday desert ");
        wordDictionary.put("PLUM PUDDING", " A holiday desert ");
        wordDictionary.put("SEASON", " A time of year ");
        wordDictionary.put("WINTER", " A time of year ");
        //End Dictionary

        Object[] keys = wordDictionary.keySet().toArray();
        Object key = keys[new Random().nextInt(keys.length)];

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(wordDictionary.entrySet());
        Collections.shuffle(list);


        for (Map.Entry<String, String> entry : list) {
            finalArray[0] = entry.getKey();
            finalArray[1] = entry.getValue();

            // Returns an array with the word in the 0 index, and the hint at the 1 index.
            return finalArray;
        }
        return null;
    }

    /* This method will create the first placeholder. It will be a character array filled with dashes.*/
    public static char[] generatePlaceHolder(String wordToGuess) {
        char[] placeHolderArray = new char[wordToGuess.length()];

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == ' ') {
                placeHolderArray[i] = ' ';
            } else {
                placeHolderArray[i] = '-';
            }
        }
        return placeHolderArray;
    }

    /* This method will compare the current char array to the word to guess, and if the word to guess contains
       the letter being guessed, it will be placed in the current char array.*/
    public char[] checkGuess(String wordToGuess, char letterToGuess, char[] currentPlaceHolder) {
        // Variable to determine if the player had a wrong guess.
        boolean isWrong = true;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letterToGuess) {
                currentPlaceHolder[i] = letterToGuess;
                isWrong = false;
            }
        }

        if(isWrong){
            // If the guess is wrong, add one to the counter and adjust the image accordingly.
            counterForLoss++;
            checkStatus(counterForLoss);
        }
        return currentPlaceHolder;
    }

    /* This method takes the wrong guesses counter, and puts up the appropriate image of the hangman based on
    * the counter.*/
    private void checkStatus(int counter){
        switch(counter){
            case 1:
                startingHangman.setVisible(false);
                hangman1.setVisible(true);
                break;
            case 2:
                hangman1.setVisible(false);
                hangman2.setVisible(true);
                break;
            case 3:
                hangman2.setVisible(false);
                hangman3.setVisible(true);
                break;
            case 4:
                hangman3.setVisible(false);
                hangman4.setVisible(true);
                break;
            case 5:
                hangman4.setVisible(false);
                hangman5.setVisible(true);
                break;
            case 6:
                hangman5.setVisible(false);
                hangman6.setVisible(true);
                break;
            case 7:
                hangman6.setVisible(false);
                hangman7.setVisible(true);
                break;
            case 8:
                hangman7.setVisible(false);
                finalDeathImage.setVisible(true);
                break;


        }
    }


    /* This method takes the current placeholder, converts it to a string, and then displays it in the text box.*/
    private void displayWord(char[] currentPlaceHolder) {
        printedWord = new String(currentPlaceHolder);
        wordToGuessTextField.setText(printedWord);
    }


    @FXML
    private ImageView finalDeathImage;

    @FXML
    private ImageView hangman1;

    @FXML
    private ImageView hangman2;

    @FXML
    private ImageView hangman3;

    @FXML
    private ImageView hangman4;

    @FXML
    private ImageView hangman5;

    @FXML
    private ImageView hangman6;

    @FXML
    private ImageView hangman7;

    @FXML
    private ImageView startingHangman;

    @FXML
    private TextField wordToGuessTextField;

    @FXML
    private Button letterAButton;

    @FXML
    private Button letterBButton;

    @FXML
    private Button letterCButton;

    @FXML
    private Button letterDButton;

    @FXML
    private Button letterEButton;

    @FXML
    private Button letterFButton;

    @FXML
    private Button letterGButton;

    @FXML
    private Button letterHButton;

    @FXML
    private Button letterIButton;

    @FXML
    private Button letterJButton;

    @FXML
    private Button letterKButton;

    @FXML
    private Button letterLButton;

    @FXML
    private Button letterMButton;

    @FXML
    private Button letterNButton;

    @FXML
    private Button letterOButton;

    @FXML
    private Button letterPButton;

    @FXML
    private Button letterQButton;

    @FXML
    private Button letterRButton;

    @FXML
    private Button letterSButton;

    @FXML
    private Button letterTButton;

    @FXML
    private Button letterUButton;

    @FXML
    private Button letterVButton;

    @FXML
    private Button letterWButton;

    @FXML
    private Button letterXButton;

    @FXML
    private Button letterYButton;

    @FXML
    private Button letterZButton;

    @FXML
    void displayInstructionsOnPress(ActionEvent event) {

    }

    // Will display the hint when the hintButton is pressed.
    @FXML
    void giveHintOnPress(ActionEvent event) {
        hintTextField.setText(hint);
        hintTextField.setVisible(true);
    }

    @FXML
    private TextField hintTextField;

    /* For all alphabet action buttons, we called the checkGuess function and put in the word it is being compared to,
     * the current placeholder array, and the letter based on which button is pressed. We then set the current
     * placeholder to the new one that is created after the checkGuess function. We then call the displayWord function
     * to display the word in the text box. The letter is then set to invisible, so it disappears after a click.*/

    @FXML
    void letterAOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'A', currentPlaceHolder));
        letterAButton.setVisible(false);
    }


    @FXML
    void letterBOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'B', currentPlaceHolder));
        letterBButton.setVisible(false);
    }

    @FXML
    void letterCOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'C', currentPlaceHolder));
        letterCButton.setVisible(false);
    }

    @FXML
    void letterDOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'D', currentPlaceHolder));
        letterDButton.setVisible(false);
    }

    @FXML
    void letterEOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'E', currentPlaceHolder));
        letterEButton.setVisible(false);

    }

    @FXML
    void letterFOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'F', currentPlaceHolder));
        letterFButton.setVisible(false);
    }

    @FXML
    void letterGOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'G', currentPlaceHolder));
        letterGButton.setVisible(false);
    }

    @FXML
    void letterHOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'H', currentPlaceHolder));
        letterHButton.setVisible(false);
    }

    @FXML
    void letterIOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'I', currentPlaceHolder));
        letterIButton.setVisible(false);
    }

    @FXML
    void letterJOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'J', currentPlaceHolder));
        letterJButton.setVisible(false);
    }

    @FXML
    void letterKOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'K', currentPlaceHolder));
        letterKButton.setVisible(false);
    }

    @FXML
    void letterLOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'L', currentPlaceHolder));
        letterLButton.setVisible(false);
    }

    @FXML
    void letterMOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'M', currentPlaceHolder));
        letterMButton.setVisible(false);
    }

    @FXML
    void letterNOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'N', currentPlaceHolder));
        letterNButton.setVisible(false);
    }

    @FXML
    void letterOOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'O', currentPlaceHolder));
        letterOButton.setVisible(false);
    }

    @FXML
    void letterPOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'P', currentPlaceHolder));
        letterPButton.setVisible(false);
    }

    @FXML
    void letterQOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'Q', currentPlaceHolder));
        letterQButton.setVisible(false);
    }

    @FXML
    void letterROnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'R', currentPlaceHolder));
        letterRButton.setVisible(false);
    }

    @FXML
    void letterSOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'S', currentPlaceHolder));
        letterSButton.setVisible(false);
    }

    @FXML
    void letterTOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'T', currentPlaceHolder));
        letterTButton.setVisible(false);
    }

    @FXML
    void letterUOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'U', currentPlaceHolder));
        letterUButton.setVisible(false);
    }

    @FXML
    void letterVOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'V', currentPlaceHolder));
        letterVButton.setVisible(false);
    }

    @FXML
    void letterWOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'W', currentPlaceHolder));
        letterWButton.setVisible(false);
    }

    @FXML
    void letterXOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'X', currentPlaceHolder));
        letterXButton.setVisible(false);
    }

    @FXML
    void letterYOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'Y', currentPlaceHolder));
        letterYButton.setVisible(false);
    }

    @FXML
    void letterZOnPress(ActionEvent event) {
        displayWord(currentPlaceHolder = checkGuess(wordToGuess, 'Z', currentPlaceHolder));
        letterZButton.setVisible(false);
    }

    @FXML
    void newGameOnPress(ActionEvent event) {

    }

    public void initialize() {
        // Sets the first text field to show as an empty word.
        printedWord = new String(currentPlaceHolder);
        wordToGuessTextField.setText(printedWord);
        ;

    }


}
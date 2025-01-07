import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {
        Random randMachine = new Random();
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> listOfScores = new ArrayList<>();
        int i=0;
        while ( i <= 10){
        int rand_int = randMachine.nextInt(20);
            rand_int+=1;
            listOfScores.add(rand_int);
            i++;
        }
        return listOfScores;
    }
    public String   getRandomLetter() {
        ArrayList<String> listOfScores = new ArrayList<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    int i=0;
    while (i<=26){
        char rand_char =alphabet[randMachine.nextInt(alphabet.length)];
        listOfScores.add(String.valueOf(rand_char));
        i+=1;
        }
        int rand_int = randMachine.nextInt(25);
        String randomScore = listOfScores.get(rand_int);
        return randomScore;

    }
    public String   getPassword() {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    int i=0;
    String password="";
    while (i<8){
        char randChar = alphabet[randMachine.nextInt(alphabet.length)];
            password += randChar;
        i+=1;
        }
    return password;
    }
    public ArrayList<String>   getNewPasswordset() {
    ArrayList<String> listOfScores = new ArrayList<>();
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    System.out.println("Please enter number:");
    // int k = System.console().readLine();
    int k = Integer.parseInt(System.console().readLine());
    int x=0;
    while(x<k){
    String password="";
    int i=0;
    while (i<8){
        char randChar = alphabet[randMachine.nextInt(alphabet.length)];
            password += randChar;
        i+=1;
        }
    listOfScores.add(password);
    x+=1;
    }
    return listOfScores ;
    }
}

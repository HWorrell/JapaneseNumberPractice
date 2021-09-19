import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File config = new File("Config.ini");

        int maxNumber = -1;

        if(!config.exists()) {
            UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
        } else{
            try {
                Scanner scanner = new Scanner(config);
                while (scanner.hasNextLine()) {
                    String in = scanner.nextLine();
                    if (in.contains("FontSize")) {
                        in = in.replace("FontSize=[", "").replace("]", "");
                        int fontSize = Integer.parseInt(in);
                        UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, fontSize));
                    }
                    if (in.contains("MaxNumber")){
                        in = in.replace("MaxNumber=[", "").replace("]", "");
                        maxNumber = Integer.parseInt(in);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        Random rand = new Random();
        NumberParser numberParser = new NumberParser();

        boolean continuePractice = true;
        do{
            int practiceTerm = rand.nextInt(maxNumber);
            String practiceTermString = Integer.toString(practiceTerm);
            String jpnPracticeTermString = numberParser.parseNumber(practiceTermString);
            //System.out.println(practiceTerm + " " + jpnPracticeTermString);
            String answer = JOptionPane.showInputDialog(jpnPracticeTermString + " (00 to exit)");
            if (answer.equals("00")){
                continuePractice = false;
            } else if (answer.equals(practiceTermString)){
                JOptionPane.showMessageDialog(null, "Correct!");
            } else{
                JOptionPane.showMessageDialog(null, "You entered " + answer + "\r\n" +
                        "but the correct answer was " + practiceTermString);
            }
        } while(continuePractice);
    }
}

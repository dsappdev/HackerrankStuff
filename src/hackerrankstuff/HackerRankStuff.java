/*
 * To change this license header, choose License Headers scanner Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template scanner the editor.
 */
package hackerrankstuff;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Doug
 */
public class HackerRankStuff {
        static final Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) throws Exception {
        System.out.println("Enter a number from 1 to 100.\nIf your number is "
                + "odd or your number is even and in the range from 6 to 20 "
                + "the output should display Weird.\nIf your number is even "
                + "and in the range of 2 to 5 or is even and greater than 20 "
                + "the output should display Not Wierd.");
        weirdNotWeird();
        System.out.println();
        System.out.println("First, enter a whole number, then enter a decimal "
                + "number such as, 0.314159, and finally a short text message. "
                + "\nThe output will display your entreies in reverse order, "
                + "text message, deciaml, then whole number. ");                
        inAndOut();
        System.out.println();
        System.out.println("Enter a word of no more than 10 letters then add "
                + "a whole number of no more than 3 digits.\nThe output will "
                + "display your word justified to the left with your number"
                + "justified to the right. If you number is only one or two "
                + "digits it will have zeroes added in front of it.");
        outputFormat();
        System.out.println();
        System.out.println("Enter a single digit from 2 to 20 and a "
                + "multiplication table from 1 to 10 will be displayed "
                + "for that number.");        
        mathLoop();
        System.out.println();
        System.out.println("The letters a, b, and n will be used in the "
                + "series listed below\n"
                + "    (a + 2^0 * b), (a + 2^0 * b + 2^1 * b),...,"
                + "(a + 2^0 * b + 2^1 * b + 2^n * b)\n"
                + "The letter q will denote how many times the series will "
                + "be run. Therefore the user input will be:\n"
                + "  q - how many times the series will be executed.\n"
                + "  a and b - represent contants in the series.\n"
                + "  n - how long the series is for each value of q");
        mathFormulaLoop();
        System.out.println();
        System.out.println("This exercise informs the user as to which "
                + "primitive data type(s) the number they provide will fit "
                + "in.\nThis exercise will only focus on byte, short, int, "
                + "and long data types and the value ranges for each are "
                + "based on the minimum and maximum values provided by Oracle "
                + "at\nhttps://docs.oracle.com/javase/tutorial/java/"
                + "nutsandbolts/datatypes.html\nThe ranges are:\n"
                + "byte: -128 to 127\nshort: -32,768 to 32,767\n"
                + "int: -2^31 to -2^31 - 1\nlong: -2^63 to -2^63 - 1");
        whereDoesItFit();
//        endOfFileProblem();
    }
    
    static void weirdNotWeird() {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if((n % 2 != 0) || (n % 2 == 0 && n >= 6 && n <= 20 )) {
            System.out.println("Weird");
        } else if((n % 2 == 0) && ((n >= 2 && n <= 5) || (n > 20))) {
            System.out.println("Not Weird");
        }
    }
    
    static void inAndOut() {
        System.out.println("Enter a whole number:");
        int num = scanner.nextInt();
        System.out.println("Enter a decimal number:");
        double d = scanner.nextDouble();
        System.out.println("Enter a short text message:");
        scanner.nextLine(); // Added to consume the new line character that was not picked up by the nextDouble().
        String s = scanner.nextLine();
        
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + num);  
    }
    
    /**
     * Modified this one so the display would not have the clutter of user 
     * input in between each line of output.
     */
    static void outputFormat() {
        Scanner scanner = new Scanner(System.in);        
        String[] words = new String[3];
        int[] nums = new int[3];
        
        for(int i = 0; i < 3; i++) { 
            System.out.println("Enter a word:");
            words[i] = scanner.next(); 
            System.out.println("Enter a number:");
            nums[i] = scanner.nextInt();                        
        }
        System.out.println("================================");
        for(int i = 0; i < 3; i++) {
           System.out.printf("%-14s %03d %n", words[i], nums[i]); 
            // To get 15 spaces I had to change the offset to 14 
        }        
        System.out.println("================================");
    }
    
    static void mathLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number from 2 to 20: ");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }
    
    static void mathFormulaLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many times do you want the series to execute?");
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            System.out.println("Enter a value for a: ");
            int a = scanner.nextInt();
            System.out.println("Enter a value for b: ");
            int b = scanner.nextInt();
            System.out.println("Enter a value for n: ");
            int n = scanner.nextInt();
            int sum = 0;            
            for(int j = 0; j < n; j++) {
                sum = a;
                for(int k = 0; k <= j; k++) {
                    sum += Math.pow(2, k) * b;
                }
//                System.out.println("The series for " + a + ", " + b + ", " + n + " is:");
                System.out.print(sum + " ");
            }
            System.out.println("\n");
        }
    }
    
    static void whereDoesItFit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you want to check?");
        int t = scanner.nextInt();
        
        for(int i = 0; i < t; i++) {
            try {
               System.out.println("Enter a number:");
               long x = scanner.nextLong(); 
               System.out.println(x + " will fit in:");
               if(x >= -128 && x <= 127)System.out.println("* byte");
               if(x >= -32768 && x <= 32767)System.out.println("* short");
               if(x >= Math.pow(-2, 31) && x <= Math.pow(2, 31) - 1)System.out.println("* int");
               if(x >= Math.pow(-2, 63) && x <= Math.pow(2, 63) - 1)System.out.println("* long");
            } catch(Exception e) {
                System.out.println(scanner.next() + " does not fit anywhere.");
            }
        }
    }
    
    /**
     * I included a simple text file in the project. To run this method
     * the path to the file would need to be changed to match its location
     * on the host system.
     * @throws Exception 
     */
    static void endOfFileProblem() throws Exception {
        File txtFile = new File("<path-to-file-on-your-system>");
        Scanner scanner = new Scanner(txtFile);
        int count = 1;
        while(scanner.hasNextLine()) {
            System.out.println(count + " " +scanner.nextLine());
            count++;
        }
        scanner.close();
    }
    
}

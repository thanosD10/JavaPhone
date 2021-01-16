/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

import java.util.Scanner;

/**
 *
 * @author thanos
 */
public class Menu {

    public int printMenu() {
        //Print menu
        System.out.println("\n\nMAIN MENU:");
        System.out.println("_________________________________________\n");
        System.out.println("1. New Profile");
        System.out.println("2. New Contract");
        System.out.println("3. Delete Contract");
        System.out.println("4. Show Active Contracts and Discounts");
        System.out.println("5. Show Preference Statistics");
        System.out.println("6. Quit");
        System.out.println("_________________________________________");
        Scanner scan = new Scanner(System.in);
        int answer = 0;
        //get user answer
        do {
            System.out.println("Enter your action number:");
            answer = scan.nextInt();
        } while (answer != 1 && answer != 2 && answer != 3 && answer != 4 && answer != 5 && answer != 6);
        return answer;
    }

}

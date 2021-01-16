/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thanos
 */
public class it21963 {

    public static void main(String[] args) {
        
        //ArrayList for addresses of Profile type classes
        ArrayList<Profile> profilesList = new ArrayList<>();
        //unique Contracts system code
        int systemCode = 1;

        //Strt by adding some random examples
        StartExamples ex = new StartExamples();
        systemCode = ex.examples(profilesList, systemCode);

        System.out.println("\n | - WELCOME TO JAVAPHONE -  |");
        System.out.println("-------------------------------");

        int answer = 0;
        Scanner input = new Scanner(System.in);
        //When user chooses option 6 program ends
        while (answer != 6) {
            //Print main menu and get user answer
            Menu menu = new Menu();
            answer = menu.printMenu();

            if (answer == 1) {
                //Create new Profile
                AddProfile addProf = new AddProfile();
                addProf.newProfile(profilesList);
            } else if (answer == 2) {
                //Create new Contract
                AddContract addCon = new AddContract();
                addCon.newContract(profilesList, systemCode);
                //Increase unique system code
                systemCode += 1;
            } else if (answer == 3) {
                //Delete existing Contract
                DeleteContract deleteCon = new DeleteContract();
                deleteCon.DeleteExistingContract(profilesList);
            } else if (answer == 4) {
                //get AFM
                System.out.println("\nGive your AFM number:");
                int searchAFM = input.nextInt();

                //Print all Profile's(based on AFM) Contracts 
                PrintContract printCon = new PrintContract();
                int error = printCon.PrintAllContracts(profilesList, searchAFM);

                //Mobile and Home Contracts Lists are empty
                if (error == -999) {
                    System.out.println("\nNO ACTIVE CONTRACTS!");
                    return;
                //Profile based on AFM does not exist
                } else if (error == -1) {
                    System.out.println("\nA profile with this AFM does not exist!");
                    System.out.println("Try again with correct AFM or create a new profile.");
                } else {
                    //Print Profile's(based on AFM) Discounts
                    Discounts disc = new Discounts();
                    System.out.println("\nYour Discount is " + disc.getDiscounts(profilesList, searchAFM) + "%");
                }

            } else if (answer == 5) {
                //Print Statistics for Mobile and Home Contracts
                Statistics stats = new Statistics();
                stats.printMobileContractsStatistics(profilesList);
                stats.printHomeContractsStatistics(profilesList);
            }
        }
        //Program ended
        System.out.println("\nGOODBYE!");
    }

}

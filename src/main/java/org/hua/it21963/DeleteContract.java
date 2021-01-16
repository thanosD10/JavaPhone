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
public class DeleteContract {

    //Variable for storing every time current Profile's Mobile Contracts List
    private ArrayList<MobileContract> mobileContractsList = new ArrayList<>();
    //Variable for storing every time current Profile's Home Contracts List
    private ArrayList<HomeContract> homeContractsList = new ArrayList<>();

    public void DeleteExistingContract(ArrayList<Profile> profilesList) {
        Scanner input = new Scanner(System.in);
        
        //get AFM
        System.out.println("\nGive your AFM number:");
        int searchAFM = input.nextInt();

        //Print Profile's(based on AFM) all Contracts
        PrintContract printCon = new PrintContract();
        int profileIndex = printCon.PrintAllContracts(profilesList, searchAFM);

        //Mobile and Home Contracts Lists are empty
        if (profileIndex == -999) {
            System.out.println("\nNO ACTIVE CONTRACTS!");
        //Profile based on AFM does not exist
        } else if (profileIndex == -1) {
            System.out.println("\nA profile with this AFM does not exist!");
            System.out.println("Try again with correct AFM or create a new profile.");            
        } else {
            //get Mobile and Home Contract's lists
            mobileContractsList = profilesList.get(profileIndex).getMobileContractsList();
            homeContractsList = profilesList.get(profileIndex).getHomeContractList();
            
            //get Contract's unique system code
            System.out.println("Give System Code of contract you want to delete:");
            int sysCodeDelete = input.nextInt();

            //Delete Contract based on unique system code
            for (MobileContract mobCon : mobileContractsList) {
                if (mobCon.getSystemCode() == sysCodeDelete) {
                    mobileContractsList.remove(mobCon);
                    System.out.println("\nYour Mobile Contract with System Code:" + sysCodeDelete + " has been deleted!");
                    return;
                }
            }
            for (HomeContract homCon : homeContractsList) {
                if (homCon.getSystemCode() == sysCodeDelete) {
                    homeContractsList.remove(homCon);
                    System.out.println("\nYour Home Contract with System Code:" + sysCodeDelete + " has been deleted");
                    return;
                } else {
                    //Wrong system code
                    System.out.println("\nInvalid Contract System Code!");
                }
            }
        }
    }
    
}

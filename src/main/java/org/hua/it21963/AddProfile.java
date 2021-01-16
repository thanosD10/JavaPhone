/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author thanos
 */
public class AddProfile {

    //Create new Profile or find the already existed
    public int newProfile(ArrayList<Profile> profilesList) {
        //get user inputs
        Scanner input = new Scanner(System.in);

        System.out.println("\nALL INPUTS MUST NOT HAVE SPACE!");
        //get AFM
        System.out.println("Give your AFM number:");
        int tmpAFM = input.nextInt();
        //get ID
        System.out.println("Give your ID number:");
        String tmpID = input.next();

        //Check if AFM and ID is unique
        //if YES create a new profile
        //if NO get data from already existing profile
        int index = uniqueAFMandID(profilesList, tmpAFM, tmpID);
        if (index == -1) {
            //get address
            System.out.println("Give your address:");
            String tmpAddress = input.next();
            //get email
            System.out.println("Give your email:");
            String tmpEmail = input.next();

            //get working status
            int tmpWorkStatus = 0;
            int loop = 1;
            do {
                if (loop != 1) {
                    System.out.println("Invalid option! Try again!");
                }
                loop += 1;
                System.out.println("\nYour Working Status:");
                System.out.println("1. Private citizen");
                System.out.println("2. University student");
                System.out.println("3. Professional");
                System.out.println("Give number option:");
                tmpWorkStatus = input.nextInt();
            } while (tmpWorkStatus != 1 && tmpWorkStatus != 2 && tmpWorkStatus != 3);

            // Create instance of Random class 
            Random rand = new Random();

            // Generate a random 6-digit integer(code)
            int randomCode = rand.nextInt(900000) + 100000;

            //create a Profile with the given data
            Profile addProfile = new Profile(tmpAFM, randomCode, tmpAddress, tmpID, tmpWorkStatus, tmpEmail, 0);
            
            //store new Profile to profilesList
            profilesList.add(addProfile);
            //get new Profile's index
            index = profilesList.indexOf(addProfile);
        } else {
            //Profile already exists
            System.out.println("\n\nProfile already exists..\nWELCOME BACK!");
        }
        
        //Print Profile
        printProfile(profilesList, index);

        //return Profile's index
        return index;
    }

    //Check if AFM and ID is unique
    //if YES return -1
    //if NO return already existed Profile's index
    private int uniqueAFMandID(ArrayList<Profile> profilesList, int AFM, String ID) {

        //Pass through all Profile type Objects of profile's list
        for (Profile prof : profilesList) {
            if (prof.getAFM() == AFM || prof.getID().equals(ID)) {
                return profilesList.indexOf(prof);
            }
        }

        return -1;
    }

    //Print a Profile
    private void printProfile(ArrayList<Profile> profilesList, int index) {

        //Convert Working Status number option to String form
        int workingStatus = profilesList.get(index).getWorkStatus();
        String printWorkingStatus = "";
        if (workingStatus == 1) {
            printWorkingStatus = "Private citizen";
        } else if (workingStatus == 2) {
            printWorkingStatus = "University student";
        } else {
            printWorkingStatus = "Professional";
        }
        
        //Print one by one Profile's data
        System.out.println("\n--------------------------");
        System.out.println(" - YOUR PROFILE - \n");
        System.out.println("AFM: " + profilesList.get(index).getAFM());
        System.out.println("ID: " + profilesList.get(index).getID());
        System.out.println("Password: " + profilesList.get(index).getClientCode());
        System.out.println("Address: " + profilesList.get(index).getAddress());
        System.out.println("email: " + profilesList.get(index).getEmail());
        System.out.println("Working Status: " + printWorkingStatus);
        System.out.println("Discounts: " + profilesList.get(index).getDiscounts() + "%");
        System.out.println("--------------------------\n");

    }
    
}

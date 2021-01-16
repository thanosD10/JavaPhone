/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

import java.util.ArrayList;

/**
 *
 * @author thanos
 */
public class PrintContract {

    //Variable for storing every time current Profile's Mobile Contracts List
    private ArrayList<MobileContract> mobileContractsList = new ArrayList<>();
    //Variable for storing every time current Profile's Home Contracts List
    private ArrayList<HomeContract> homeContractsList = new ArrayList<>();

    //Print a Mobile Contrant
    public void printMobileContract(ArrayList<Profile> profilesList, int profileIndex, int contractIndex) {

        //get Profile's(based on index) Mobile Contracts lists
        mobileContractsList = profilesList.get(profileIndex).getMobileContractsList();

        //Convert Electronic Account number option to String form
        int electronicAccount = mobileContractsList.get(contractIndex).getElectronicAccount();
        String printElectronicAccount = "";
        if (electronicAccount == 1) {
            printElectronicAccount = "yes";
        } else {
            printElectronicAccount = "no";
        }

        //Convert Payment Method number option to String form
        int payMethod = mobileContractsList.get(contractIndex).getPaymentMethod();
        String printPayMethod = "";
        if (payMethod == 1) {
            printPayMethod = "Credit card";
        } else if (payMethod == 2) {
            printPayMethod = "Cash";
        } else {
            printPayMethod = "Bank account/card";
        }

        //Print one by one Mobile Contracts's data
        System.out.println("\n--------------------------");
        System.out.println(" - YOUR CONTRACT - \n");
        System.out.println("Type: Mobile Contract");
        System.out.println("Phone Number: " + mobileContractsList.get(contractIndex).getPhoneNum());
        System.out.println("System code:" + mobileContractsList.get(contractIndex).getSystemCode());
        System.out.println("Starting Date: " + mobileContractsList.get(contractIndex).getContractStartingDateDay() + "/" + mobileContractsList.get(contractIndex).getContractStartingDateMonth() + "/" + mobileContractsList.get(contractIndex).getContractStartingDateYear());
        System.out.println("Validity Period: " + mobileContractsList.get(contractIndex).getContractPeriod() + " months");
        System.out.println("Monthly Cost: " + mobileContractsList.get(contractIndex).getMonthlyCost() + "€");
        System.out.println("eAccount: " + printElectronicAccount);
        System.out.println("Payment Method: " + printPayMethod);

        System.out.println("- YOU GET:");
        System.out.println("Free calls: " + mobileContractsList.get(contractIndex).getFreeCallsMins() + "' (for Mobiles&Home numbers)");
        System.out.println("Free SMS: " + mobileContractsList.get(contractIndex).getFreeSMS() + "'");
        if (mobileContractsList.get(contractIndex).getInternet() == 1) {
            System.out.println("Free GB: " + mobileContractsList.get(contractIndex).getFreeGB() + "GB");
        }

        System.out.println("--------------------------\n");

    }

    //Print a Mobile Contrant
    public void printHomeContract(ArrayList<Profile> profilesList, int profileIndex, int contractIndex) {

        //get Profile's(based on index) Home Contracts lists
        homeContractsList = profilesList.get(profileIndex).getHomeContractList();

        //Convert Electronic Account number option to String form
        int electronicAccount = homeContractsList.get(contractIndex).getElectronicAccount();
        String printElectronicAccount = "";
        if (electronicAccount == 1) {
            printElectronicAccount = "yes";
        } else {
            printElectronicAccount = "no";
        }

        //Convert Payment Method number option to String form
        int payMethod = homeContractsList.get(contractIndex).getPaymentMethod();
        String printPayMethod = "";
        if (payMethod == 1) {
            printPayMethod = "Credit card";
        } else if (payMethod == 2) {
            printPayMethod = "Cash";
        } else {
            printPayMethod = "Bank account/card";
        }

        //Print one by one Home Contracts's data
        System.out.println("\n--------------------------");
        System.out.println(" - YOUR CONTRACT - \n");
        System.out.println("Type: Home Contract");
        System.out.println("Phone Number: " + homeContractsList.get(contractIndex).getPhoneNum());
        System.out.println("System code:" + homeContractsList.get(contractIndex).getSystemCode());
        System.out.println("Starting Date: " + homeContractsList.get(contractIndex).getContractStartingDateDay() + "/" + homeContractsList.get(contractIndex).getContractStartingDateMonth() + "/" + homeContractsList.get(contractIndex).getContractStartingDateYear());
        System.out.println("Validity Period: " + homeContractsList.get(contractIndex).getContractPeriod() + " months");
        System.out.println("Monthly Cost: " + homeContractsList.get(contractIndex).getMonthlyCost() + "€");
        System.out.println("eAccount: " + printElectronicAccount);
        System.out.println("Payment Method: " + printPayMethod);

        System.out.println("- YOU GET:");
        System.out.println("Free calls: " + homeContractsList.get(contractIndex).getFreeCallsMins() + "' (for Mobiles&Home numbers)");
        if (homeContractsList.get(contractIndex).getInternet() == 1) {
            System.out.println("Internet type: " + homeContractsList.get(contractIndex).getInternetName());
            System.out.println("Internet speed: " + homeContractsList.get(contractIndex).getInternetSpeed() + " Mbps");
        }

        System.out.println("--------------------------\n");

    }

    public int PrintAllContracts(ArrayList<Profile> profilesList, int searchAFM) {
        int countContracts = 1;
        int profileIndex = -1;
        //Pass through all data of profiles list
        for (Profile prof : profilesList) {
            //Find Profile with the same AFM
            if (prof.getAFM() == searchAFM) {
                //get Profile's index
                profileIndex = profilesList.indexOf(prof);
                
                //get Profile's(based on index) Mobile and Home Contracts lists
                mobileContractsList = profilesList.get(profileIndex).getMobileContractsList();
                homeContractsList = profilesList.get(profileIndex).getHomeContractList();

                //Both lists are empty
                //return an invalid number(-999)
                if (mobileContractsList.isEmpty() && homeContractsList.isEmpty()) {
                    return -999;
                }

                //Print all Profile's Contracts one by one in a form of a numbered list
                System.out.println("\n~~~~~~~~~~~~~~~~~ CONTRACTS LIST START ~~~~~~~~~~~~~~~~~");
                for (MobileContract mobCon : mobileContractsList) {
                    System.out.println("\nCONTRACT  #" + countContracts);
                    PrintContract printMob = new PrintContract();
                    printMob.printMobileContract(profilesList, profileIndex, mobileContractsList.indexOf(mobCon));
                    countContracts += 1;
                }
                for (HomeContract homCon : homeContractsList) {
                    System.out.println("\nCONTRACT  #" + countContracts);
                    PrintContract printMob = new PrintContract();
                    printMob.printHomeContract(profilesList, profileIndex, homeContractsList.indexOf(homCon));
                    countContracts += 1;
                }
                System.out.println("~~~~~~~~~~~~~~~~~ CONTRACTS LIST END ~~~~~~~~~~~~~~~~~~\n");

            }
        }
        //retuen Profile's index
        return profileIndex;
    }
}

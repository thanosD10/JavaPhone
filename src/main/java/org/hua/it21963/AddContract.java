/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author thanos
 */
public class AddContract {

    //Variable for storing every time current Profile's Mobile Contracts List
    private ArrayList<MobileContract> mobileContractsList = new ArrayList<>();
    //Variable for storing every time current Profile's Home Contracts List
    private ArrayList<HomeContract> homeContractsList = new ArrayList<>();

    //Create new Contracts
    public void newContract(ArrayList<Profile> profilesList, int systemCode) {
        AddProfile newProf = new AddProfile();
        int profileIndex = newProf.newProfile(profilesList);

        //get Profile's(based on index) Mobile and Home Contracts
        mobileContractsList = profilesList.get(profileIndex).getMobileContractsList();
        homeContractsList = profilesList.get(profileIndex).getHomeContractList();

        Scanner input = new Scanner(System.in);

        System.out.println("Creating new contract..");

        //get Contract choice
        int contractChoice = 0;
        int loop = 1;
        do {
            if (loop != 1) {
                System.out.println("Invalid option! Try again!");
            }
            loop += 1;
            System.out.println("\nSelect Contract type:");
            System.out.println("1. Mobile Contract");
            System.out.println("2. Home1 Contract");
            System.out.println("Give number option:");
            contractChoice = input.nextInt();
        } while (contractChoice != 1 && contractChoice != 2);

        //get internet choice
        int addInternet = 0;
        int loop2 = 1;
        do {
            if (loop2 != 1) {
                System.out.println("Invalid option! Try again!");
            }
            loop2 += 1;
            System.out.println("\nDo you want internet connection? 1=yes / 2=no:");
            addInternet = input.nextInt();
        } while (addInternet != 1 && addInternet != 2);

        //get phone number
        boolean validNum = false;
        String tmpNumber = "";
        do {
            System.out.println("\nGive your phone number:");
            tmpNumber = input.next();

            //check if number is valid
            validNum = validNumber(contractChoice, tmpNumber);
        } while (validNum == false);

        //get start Contract's date 
        boolean validDate = false;
        int tmpStartDay = 0;
        int tmpStartMonth = 0;
        int tmpStartYear = 0;
        int tmpPeriod = 0;
        do {
            System.out.println("Give contract's start date (in format e.g. Day:1 Month:10 Year:2021 -> 1/10/2021):");
            System.out.println("Day:");
            tmpStartDay = input.nextInt();
            System.out.println("Month:");
            tmpStartMonth = input.nextInt();
            System.out.println("Year:");
            tmpStartYear = input.nextInt();

            //get Contract's period(12 or 24)
            do {
                System.out.println("\nGive period of contract(12 or 24 months):");
                tmpPeriod = input.nextInt();
            } while (tmpPeriod != 12 && tmpPeriod != 24);
                
            if (contractChoice == 1) {
                //check if Mobile Contract's date is valid
                validDate = validMobileContractDate(profilesList, profileIndex, tmpNumber, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod);
            } else {
                //check if Home Contract's date is valid
                validDate = validHomeContractDate(profilesList, profileIndex, tmpNumber, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod);
            }
        } while (validDate == false);

        //get AFM
        int tmpAFM = profilesList.get(profileIndex).getAFM();

        //get random 6-digit code
        int tmpClientCode = profilesList.get(profileIndex).getClientCode();

        //get electronic account choice
        int eAccount = 0;
        int loop3 = 1;
        do {
            if (loop3 != 1) {
                System.out.println("Invalid option! Try again!");
            }
            loop3 += 1;
            System.out.println("\nYour account will be an eAccount? 1=yes / 2=no:");
            eAccount = input.nextInt();
        } while (eAccount != 1 && eAccount != 2);

        //get payment method
        int paymentChoice = 0;
        int loop4 = 1;
        do {
            if (loop4 != 1) {
                System.out.println("Invalid option! Try again!");
            }
            loop4 += 1;
            System.out.println("\nSelect payment method:");
            System.out.println("1. Credit card");
            System.out.println("2. Cash");
            System.out.println("3. Bank account/card");
            System.out.println("Give number option:");
            paymentChoice = input.nextInt();
        } while (paymentChoice != 1 && paymentChoice != 2 && paymentChoice != 3);

        //create a new Contract based on users choices
        int contractIndex = 0;
        if (contractChoice == 1) {
            if (tmpPeriod == 12) {
                if (addInternet == 1) {
                    MobileContract addContract = new MobileContract(10, 1500, systemCode, tmpNumber, tmpAFM, tmpClientCode, 1800, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 35, eAccount, paymentChoice, 1);
                    mobileContractsList.add(addContract);
                    contractIndex = mobileContractsList.indexOf(addContract);
                } else {
                    MobileContract addContract = new MobileContract(1300, systemCode, tmpNumber, tmpAFM, tmpClientCode, 1600, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 27, eAccount, paymentChoice, 2);
                    mobileContractsList.add(addContract);
                    contractIndex = mobileContractsList.indexOf(addContract);
                }
            } else {
                if (addInternet == 1) {
                    MobileContract addContract = new MobileContract(12, 1700, systemCode, tmpNumber, tmpAFM, tmpClientCode, 2000, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 30, eAccount, paymentChoice, 1);
                    mobileContractsList.add(addContract);
                    contractIndex = mobileContractsList.indexOf(addContract);
                } else {
                    MobileContract addContract = new MobileContract(1500, systemCode, tmpNumber, tmpAFM, tmpClientCode, 1800, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 25, eAccount, paymentChoice, 2);
                    mobileContractsList.add(addContract);
                    contractIndex = mobileContractsList.indexOf(addContract);
                }
            }
            //Print new created Mobile Contract
            PrintContract printMob = new PrintContract();
            printMob.printMobileContract(profilesList, profileIndex, contractIndex);

        } else {
            if (tmpPeriod == 12) {
                if (addInternet == 1) {
                    HomeContract addContract = new HomeContract(24, "ADSL", systemCode, tmpNumber, tmpAFM, tmpClientCode, 1500, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 24, eAccount, paymentChoice, 1);
                    homeContractsList.add(addContract);
                    contractIndex = homeContractsList.indexOf(addContract);
                } else {
                    HomeContract addContract = new HomeContract(systemCode, tmpNumber, tmpAFM, tmpClientCode, 1200, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 17, eAccount, paymentChoice, 2);
                    homeContractsList.add(addContract);
                    contractIndex = homeContractsList.indexOf(addContract);
                }
            } else {
                if (addInternet == 1) {
                    HomeContract addContract = new HomeContract(24, "VDSL", systemCode, tmpNumber, tmpAFM, tmpClientCode, 1600, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 21, eAccount, paymentChoice, 1);
                    homeContractsList.add(addContract);
                    contractIndex = homeContractsList.indexOf(addContract);
                } else {
                    HomeContract addContract = new HomeContract(systemCode, tmpNumber, tmpAFM, tmpClientCode, 1400, tmpStartDay, tmpStartMonth, tmpStartYear, tmpPeriod, 14, eAccount, paymentChoice, 2);
                    homeContractsList.add(addContract);
                    contractIndex = homeContractsList.indexOf(addContract);
                }
            }
            //Print new created Home Contract
            PrintContract printHom = new PrintContract();
            printHom.printHomeContract(profilesList, profileIndex, contractIndex);
        }

        //Update new COntract's Profile with the new Discounts
        Discounts disc = new Discounts();
        profilesList.get(profileIndex).setDiscounts(disc.getDiscounts(profilesList, tmpAFM));
    }

    //Check if phone number is valid
    private boolean validNumber(int contractChoice, String number) {
        //Mobile Contract:Number must NOT start with 2 
        if (contractChoice == 1) {
            if (number.charAt(0) != '2') {
                return true;
            }
        //Home Contract:Number must NOT start with 6
        } else {
            if (number.charAt(0) != '6') {
                return true;
            }
        }
        System.out.println("Wrong input! Try again!");
        return false;
    }

    //Check if Mobile Contract's date is valid
    private boolean validMobileContractDate(ArrayList<Profile> profilesList, int profileIndex, String number, int day, int month, int year, int period) {
        //get new Contract's end year
        int newConPeriodEndYear = year;
        if (period == 12) {
            newConPeriodEndYear += 1;
        } else {
            newConPeriodEndYear += 2;
        }

        //Pass through Mobile Contracts List
        for (MobileContract con : mobileContractsList) {
            //if given number is equal to an already existing number
            if (number.equals(con.getPhoneNum())) {

                //Create new Contract's starting date
                Calendar startDateNewCon = Calendar.getInstance();
                startDateNewCon.set(year, month, day);
                Date startDate1 = startDateNewCon.getTime();

                //Create new Contract's end date
                Calendar endDateNewCon = Calendar.getInstance();
                endDateNewCon.set(newConPeriodEndYear, month, day);
                Date endDate1 = endDateNewCon.getTime();

                //Create old Contract's starting date
                Calendar startDateOldCon = Calendar.getInstance();
                startDateOldCon.set(con.getContractStartingDateYear(), con.getContractStartingDateMonth() - 1, con.getContractStartingDateDay());
                Date startDate2 = startDateOldCon.getTime();

                //get old Contract's end year
                int oldConPeriodEndYear = con.getContractStartingDateYear();
                if (con.getContractPeriod() == 12) {
                    oldConPeriodEndYear += 1;
                } else {
                    oldConPeriodEndYear += 2;
                }
                //Create old Contract's end date
                Calendar endDateOldCon = Calendar.getInstance();
                endDateOldCon.set(oldConPeriodEndYear, con.getContractStartingDateMonth() - 1, con.getContractStartingDateDay());
                Date endDate2 = endDateOldCon.getTime();
                
                //Check if dates overlap
                if (startDate1.before(endDate2) && startDate2.before(endDate1)) {
                    System.out.println("There will ALREADY EXIST THE BELOW CONTRACT for this mobile phone number at that time period:");
                    PrintContract printMob = new PrintContract();
                    printMob.printMobileContract(profilesList, profileIndex, mobileContractsList.indexOf(con));
                    System.out.println("Try another date!\n");
                    return false;
                }
            }
        }
        return true;
    }

    //Check if Home Contract's date is valid
    private boolean validHomeContractDate(ArrayList<Profile> profilesList, int profileIndex, String number, int day, int month, int year, int period) {
        //get new Contract's end year
        int newConPeriodEndYear = year;
        if (period == 12) {
            newConPeriodEndYear += 1;
        } else {
            newConPeriodEndYear += 2;
        }

        //Pass through Home Contracts List
        for (HomeContract con : homeContractsList) {
            //if given number is equal to an already existing number
            if (number.equals(con.getPhoneNum())) {

                //Create new Contract's starting date
                Calendar startDateNewCon = Calendar.getInstance();
                startDateNewCon.set(year, month, day);
                Date startDate1 = startDateNewCon.getTime();

                //Create new Contract's end date
                Calendar endDateNewCon = Calendar.getInstance();
                endDateNewCon.set(newConPeriodEndYear, month, day);
                Date endDate1 = endDateNewCon.getTime();

                //Create old Contract's starting date
                Calendar startDateOldCon = Calendar.getInstance();
                startDateOldCon.set(con.getContractStartingDateYear(), con.getContractStartingDateMonth() - 1, con.getContractStartingDateDay());
                Date startDate2 = startDateOldCon.getTime();

                //get old Contract's end year
                int oldConPeriodEndYear = con.getContractStartingDateYear();
                if (con.getContractPeriod() == 12) {
                    oldConPeriodEndYear += 1;
                } else {
                    oldConPeriodEndYear += 2;
                }
                //Create old Contract's end date
                Calendar endDateOldCon = Calendar.getInstance();
                endDateOldCon.set(oldConPeriodEndYear, con.getContractStartingDateMonth() - 1, con.getContractStartingDateDay());
                Date endDate2 = endDateOldCon.getTime();

                //Check if dates overlap
                if (startDate1.before(endDate2) && startDate2.before(endDate1)) {
                    System.out.println("There will ALREADY EXIST THE BELOW CONTRACT for this home phone number at that time period:");
                    PrintContract printHom = new PrintContract();
                    printHom.printHomeContract(profilesList, profileIndex, homeContractsList.indexOf(con));
                    System.out.println("Try another date!\n");
                    return false;
                }
            }
        }
        return true;
    }

}

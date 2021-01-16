/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author thanos
 */
public class Discounts {

    private ArrayList<MobileContract> mobileContractsList = new ArrayList<>();
    private ArrayList<HomeContract> homeContractsList = new ArrayList<>();
    int index = 0;

    public int getDiscounts(ArrayList<Profile> profilesList, int AFM) {
        //get number of all active Contracts
        int activeContracts = countActiveContracts(profilesList, AFM);
        //Create active Contracts Discount
        int activeContractsDiscount = activeContracts * 5;
        //active Contracts Discount number can not be bigger than 15
        if (activeContractsDiscount > 15) {
            activeContractsDiscount = 15;
        }

        //Create Work Status Discount
        int workStatusDiscount = 0;
        if (profilesList.get(index).getWorkStatus() == 3) {
            workStatusDiscount = 10;
        } else if (profilesList.get(index).getWorkStatus() == 2) {
            workStatusDiscount = 15;
        }

        //Create Contracts Discount
        int contractsDiscount = 0;
        boolean payedWithCreditCardOnce = false;
        boolean payedWithBankAccOnce = false;
        boolean eAccountOnce = false;
        if (!mobileContractsList.isEmpty()) {
            for(MobileContract mobCon : mobileContractsList) {
                if (mobCon.getFreeCallsMins() > 1000) {
                    contractsDiscount = 11;
                }
                if (mobCon.getPaymentMethod() == 1) {
                    payedWithCreditCardOnce = true;
                }
                if (mobCon.getPaymentMethod() == 3) {
                    payedWithBankAccOnce = true;
                }
                if (mobCon.getElectronicAccount() == 1) {
                    eAccountOnce = true;
                }
            }
        }
        if(!homeContractsList.isEmpty()) {
            for(HomeContract homCon : homeContractsList) {
                if (homCon.getFreeCallsMins() > 1000) {
                    contractsDiscount = 8;
                }
                if (homCon.getPaymentMethod() == 1) {
                    payedWithCreditCardOnce = true;
                }
                if (homCon.getPaymentMethod() == 3) {
                    payedWithBankAccOnce = true;
                }  
                if (homCon.getElectronicAccount() == 1) {
                    eAccountOnce = true;
                }
            }
        }
        
        int payMethodDiscount = 0;
        if (payedWithCreditCardOnce == true || payedWithBankAccOnce == true) {
            payMethodDiscount = 5;
        }
        
        int eAccountDiscount = 0;
        if (eAccountOnce == true) {
            eAccountDiscount = 2;
        }
        
        //Count total Discount number
        int totalDiscount = activeContractsDiscount + workStatusDiscount + contractsDiscount + payMethodDiscount + eAccountDiscount;
        //Total Discount number can not be bigger than 45
        if (totalDiscount > 45) {
            totalDiscount = 45;
        }

        //return total Discount number
        return totalDiscount;
    }

    //Count number of active Contracts
    private int countActiveContracts(ArrayList<Profile> profilesList, int AFM) {
        int count = 0;
        //Pass through all data of profiles list
        for (Profile prof : profilesList) {
            //FInd Profile with the same AFM as the searched one
            if (prof.getAFM() == AFM) {
                //get Profile's index
                index = profilesList.indexOf(prof);
                //get Mobile and Home Contract's lists
                mobileContractsList = profilesList.get(index).getMobileContractsList();
                homeContractsList = profilesList.get(index).getHomeContractList();
            }
        }

        //If both lists are empty return 0
        if (mobileContractsList.isEmpty() && homeContractsList.isEmpty()) {
            return count;
        }

        for (MobileContract mobCon : mobileContractsList) {
            //Create Contract's starting date
            Calendar startDateCon = Calendar.getInstance();
            startDateCon.set(mobCon.getContractStartingDateYear(), mobCon.getContractStartingDateMonth() - 1, mobCon.getContractStartingDateDay());
            Date startDate = startDateCon.getTime();

            //get Contract's end year
            int endYearCon = mobCon.getContractStartingDateYear();
            if (mobCon.getContractPeriod() == 12) {
                endYearCon += 1;
            } else {
                endYearCon += 2;
            }

            //Create Contract's end date
            Calendar endDateCon = Calendar.getInstance();
            endDateCon.set(endYearCon, mobCon.getContractStartingDateMonth() - 1, mobCon.getContractStartingDateDay());
            Date endDate = endDateCon.getTime();

            //get current date
            Date currentDate = new Date();

            //Check if Contract's date is overlaping current date
            if (currentDate.after(startDate) && currentDate.before(endDate)) {
                //Increase active Contracts number
                count += 1;
            }
        }

        for (HomeContract homCon : homeContractsList) {
            //Create Contract's starting date
            Calendar startDateCon = Calendar.getInstance();
            startDateCon.set(homCon.getContractStartingDateYear(), homCon.getContractStartingDateMonth() - 1, homCon.getContractStartingDateDay());
            Date startDate = startDateCon.getTime();

            //get Contract's end year
            int endYearCon = homCon.getContractStartingDateYear();
            if (homCon.getContractPeriod() == 12) {
                endYearCon += 1;
            } else {
                endYearCon += 2;
            }

            //Create Contract's end date
            Calendar endDateCon = Calendar.getInstance();
            endDateCon.set(endYearCon, homCon.getContractStartingDateMonth() - 1, homCon.getContractStartingDateDay());
            Date endDate = endDateCon.getTime();

            //get current date
            Date currentDate = new Date();

            //Check if Contract's date is overlaping current date
            if (currentDate.after(startDate) && currentDate.before(endDate)) {
                //Increase active Contracts number
                count += 1;
            }
        }

        //return active Contracts number
        return count;
    }

}

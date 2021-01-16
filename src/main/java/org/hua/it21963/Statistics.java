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
public class Statistics {

    private ArrayList<MobileContract> mobileContractsList = new ArrayList<>();
    private ArrayList<HomeContract> homeContractsList = new ArrayList<>();

    public void printMobileContractsStatistics(ArrayList<Profile> profilesList) {

        int callsMax = -1;
        int callsMin = 99999;
        int calls = 0;
        int smsMax = -1;
        int smsMin = 99999;
        int sms = 0;
        boolean internetOnce = false;
        int gbMax = -1;
        int gbMin = 99999;
        int gb = 0;
        int countInternetCon = 0;
        int costMax = -1;
        int costMin = 99999;
        int cost = 0;
        int countCon = 0;
        for (Profile prof : profilesList) {
            //get Profile's index
            int profileIndex = profilesList.indexOf(prof);
            //get Profile's Mobile Contracts list
            mobileContractsList = profilesList.get(profileIndex).getMobileContractsList();

            //if Mobile Contracts list is not empty
            if (!mobileContractsList.isEmpty()) {
                for (MobileContract mobCon : mobileContractsList) {
                    //get calls max value
                    if (mobCon.getFreeCallsMins() > callsMax) {
                        callsMax = mobCon.getFreeCallsMins();
                    }
                    //get calls min value
                    if (mobCon.getFreeCallsMins() < callsMin) {
                        callsMin = mobCon.getFreeCallsMins();
                    }
                    //count all calls
                    calls += mobCon.getFreeCallsMins();

                    //get SMSes max value
                    if (mobCon.getFreeSMS() > smsMax) {
                        smsMax = mobCon.getFreeSMS();
                    }
                    //get SMSes min value
                    if (mobCon.getFreeSMS() < smsMin) {
                        smsMin = mobCon.getFreeSMS();
                    }
                    //count all SMSes
                    sms += mobCon.getFreeSMS();

                    //if user chose internet connection
                    if (mobCon.getInternet() == 1) {
                        internetOnce = true;
                        //get GB max value
                        if (mobCon.getFreeGB() > gbMax) {
                            gbMax = mobCon.getFreeGB();
                        }
                        //get GB min value
                        if (mobCon.getFreeGB() < gbMin) {
                            gbMin = mobCon.getFreeGB();
                        }
                        //count all GB
                        gb += mobCon.getFreeGB();
                        //count all Mobile Contracts with internet connection
                        countInternetCon += 1;
                    }

                    //get cost max value
                    if (mobCon.getMonthlyCost() > costMax) {
                        costMax = mobCon.getMonthlyCost();
                    }
                    //get cost min value
                    if (mobCon.getMonthlyCost() < costMin) {
                        costMin = mobCon.getMonthlyCost();
                    }
                    //count all costs
                    cost += mobCon.getMonthlyCost();

                    //count all Mobile Contracts
                    countCon += 1;
                }
            }
        }
        //count calls, SMSes, costs, GB mean values
        int callsMean = calls / countCon;
        int smsMean = sms / countCon;
        int costMean = cost / countCon;
        int gbMean = 0;
        if (internetOnce == true) {
            gbMean = gb / countInternetCon;
        }

        //Print one by one all above data
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.println("                - MOBILE CONTRACTS STATISTICS -  ");
        System.out.println("\nMaximum number of Free Minutes for Calls other users prefer: " + callsMax);
        System.out.println("Minimum number of Free Minutes for Calls other users prefer: " + callsMin);
        System.out.println("- Mean Value of Free Minutes for Calls other users prefer: " + callsMean);
        System.out.println("\nMaximum number of SMSes other users prefer: " + smsMax);
        System.out.println("Minimum number of SMSes other users prefer: " + smsMin);
        System.out.println("- Mean Value of SMSes other users prefer: " + smsMean);
        if (internetOnce == true) {
            System.out.println("\nMaximum number of GB other users prefer: " + gbMax);
            System.out.println("Minimum number of GB other users prefer: " + gbMin);
            System.out.println("- Mean Value of GB other users prefer: " + gbMean);
        }
        System.out.println("\nMaximum number of Monthly Cost other users prefer: " + costMax);
        System.out.println("Minimum number of Monthly Cost other users prefer: " + costMin);
        System.out.println("- Mean Value of Monthly Cost for Free Calls other users prefer: " + costMean);
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void printHomeContractsStatistics(ArrayList<Profile> profilesList) {

        int callsMax = -1;
        int callsMin = 99999;
        int calls = 0;
        int costMax = -1;
        int costMin = 99999;
        int cost = 0;
        int countCon = 0;
        for (Profile prof : profilesList) {
            //get Profile's index
            int profileIndex = profilesList.indexOf(prof);
            //get Profile's Mobile Contracts list
            homeContractsList = profilesList.get(profileIndex).getHomeContractList();

            //if Mobile Contracts list is not empty
            if (!homeContractsList.isEmpty()) {
                for (HomeContract homCon : homeContractsList) {
                    //get calls max value
                    if (homCon.getFreeCallsMins() > callsMax) {
                        callsMax = homCon.getFreeCallsMins();
                    }
                    //get calls min value
                    if (homCon.getFreeCallsMins() < callsMin) {
                        callsMin = homCon.getFreeCallsMins();
                    }
                    //count all calls
                    calls += homCon.getFreeCallsMins();

                    //get cost max value
                    if (homCon.getMonthlyCost() > costMax) {
                        costMax = homCon.getMonthlyCost();
                    }
                    //get cost min value
                    if (homCon.getMonthlyCost() < costMin) {
                        costMin = homCon.getMonthlyCost();
                    }
                    //count all costs
                    cost += homCon.getMonthlyCost();

                    //count all Home Contracts
                    countCon += 1;
                }
            }
        }
        //count calls mean value
        int callsMean = calls / countCon;
        //count costs mean values
        int costMean = cost / countCon;

        //Print one by one all above data
        System.out.println("\n                - HOME CONTRACTS STATISTICS -   ");
        System.out.println("\nMaximum number of Free Minutes for Calls other users prefer: " + callsMax);
        System.out.println("Minimum number of Free Minutes for Calls other users prefer: " + callsMin);
        System.out.println("- Mean Value of Free Minutes for Free Calls other users prefer: " + callsMean);
        System.out.println("\nMaximum number of Monthly Cost other users prefer: " + costMax);
        System.out.println("Minimum number of Monthly Cost other users prefer: " + costMin);
        System.out.println("- Mean Value of Monthly Cost for Free Calls other users prefer: " + costMean);
        System.out.println("---------------------------------------------------------------------------------");
    }
}

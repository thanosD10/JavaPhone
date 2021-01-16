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
public class StartExamples {

    public int examples(ArrayList<Profile> profilesList, int systemCode) {
        //Variable for storing every time current Profile's Mobile Contracts List
        ArrayList<MobileContract> mobConList = new ArrayList<>();
        //Variable for storing every time current Profile's Home Contracts List
        ArrayList<HomeContract> homConList = new ArrayList<>();

        //example #1
        //Create new Profile
        Profile prof1 = new Profile(1234, 163920, "Sofokleous24", "AK285130", 1, "chrisbou@gmail.com", 18);
        //Add new Profile to profiles list
        profilesList.add(prof1);
        //get new Profile's index
        int indexProf1 = profilesList.indexOf(prof1);
        //get new Profile's Mobile COntract's list
        mobConList = profilesList.get(indexProf1).getMobileContractsList();
        //Create new Mobile Contract
        MobileContract mobCon1 = new MobileContract(20, 1500, systemCode, "6940123456", 1234, 163920, 1800, 3, 3, 2021, 12, 35, 1, 3, 1);
        //Add new Mobile Contract tp Mobile Contracts list
        mobConList.add(mobCon1);
        //Increase unique system code
        systemCode += 1;
        //Create new Mobile Contract
        MobileContract mobCon2 = new MobileContract(1300, systemCode, "6940123456", 1234, 163920, 1600, 19, 10, 2022, 12, 27, 2, 2, 2);
        //Add new Mobile Contract tp Mobile Contracts list
        mobConList.add(mobCon2);
        //Increase unique system code
        systemCode += 1;

        //example #2
        Profile prof2 = new Profile(6789, 501982, "Xarokopou32", "AO129044", 2, "mariakk@yahoo.gr", 30);
        profilesList.add(prof2);
        int indexProf2 = profilesList.indexOf(prof2);
        mobConList = profilesList.get(indexProf2).getMobileContractsList();
        MobileContract mobCon3 = new MobileContract(12, 1700, systemCode, "6935132446", 6789, 501982, 2000, 27, 6, 2021, 24, 30, 1, 1, 1);
        mobConList.add(mobCon3);
        //Increase unique system code
        systemCode += 1;
        homConList = profilesList.get(indexProf2).getHomeContractList();
        HomeContract homCon1 = new HomeContract(24, "VDSL", systemCode, "2101234567", 6789, 501982, 1600, 15, 4, 2021, 24, 21, 2, 3, 1);
        homConList.add(homCon1);
        //Increase unique system code
        systemCode += 1;

        //example #3
        Profile prof3 = new Profile(1020, 342910, "Omhrou11", "AB295012", 3, "spyrosaman@gmail.com", 20);
        profilesList.add(prof3);
        int indexProf3 = profilesList.indexOf(prof3);
        homConList = profilesList.get(indexProf3).getHomeContractList();
        HomeContract homCon2 = new HomeContract(systemCode, "2632098765", 1020, 342910, 1200, 22, 2, 2022, 12, 17, 1, 2, 2);
        homConList.add(homCon2);
        //Increase unique system code
        systemCode += 1;

        //return increased unique system code
        return systemCode;
    }
}

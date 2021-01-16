/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

/**
 *
 * @author thanos
 */
public class HomeContract extends Contract {
    private int internetSpeed;
    private String internetTypeName;

    public HomeContract(int systemCode, String phoneNum, int AFM, int clientCode, int freeCallsMins, int contractStartingDateDay, int contractStartingDateMonth, int contractStartingDateYear, int contractPeriod, int monthlyCost, int electronicAccount, int paymentMethod, int internet) {
        super(systemCode, phoneNum, AFM, clientCode, freeCallsMins, contractStartingDateDay, contractStartingDateMonth, contractStartingDateYear, contractPeriod, monthlyCost, electronicAccount, paymentMethod, internet);
    }

    public HomeContract(int internetSpeed, String internetTypeName, int systemCode, String phoneNum, int AFM, int clientCode, int freeCallsMins, int contractStartingDateDay, int contractStartingDateMonth, int contractStartingDateYear, int contractPeriod, int monthlyCost, int electronicAccount, int paymentMethod, int internet) {
        super(systemCode, phoneNum, AFM, clientCode, freeCallsMins, contractStartingDateDay, contractStartingDateMonth, contractStartingDateYear, contractPeriod, monthlyCost, electronicAccount, paymentMethod, internet);
        this.internetSpeed = internetSpeed;
        this.internetTypeName = internetTypeName;
    }


    public void setInternetSpeed(int internetSpeed) {
        this.internetSpeed = internetSpeed;
    }

    public void setInternetName(String internetName) {
        this.internetTypeName = internetName;
    }

    
    public int getInternetSpeed() {
        return internetSpeed;
    }

    public String getInternetName() {
        return internetTypeName;
    }

}

/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

/**
 *
 * @author thanos
 */
public class MobileContract extends Contract {
    private int freeGB;
    private int freeSMS;

    public MobileContract(int freeSMS, int systemCode, String phoneNum, int AFM, int clientCode, int freeCallsMins, int contractStartingDateDay, int contractStartingDateMonth, int contractStartingDateYear, int contractPeriod, int monthlyCost, int electronicAccount, int paymentMethod, int internet) {
        super(systemCode, phoneNum, AFM, clientCode, freeCallsMins, contractStartingDateDay, contractStartingDateMonth, contractStartingDateYear, contractPeriod, monthlyCost, electronicAccount, paymentMethod, internet);
        this.freeSMS = freeSMS;
    }

    public MobileContract(int freeGB, int freeSMS, int systemCode, String phoneNum, int AFM, int clientCode, int freeCallsMins, int contractStartingDateDay, int contractStartingDateMonth, int contractStartingDateYear, int contractPeriod, int monthlyCost, int electronicAccount, int paymentMethod, int internet) {
        super(systemCode, phoneNum, AFM, clientCode, freeCallsMins, contractStartingDateDay, contractStartingDateMonth, contractStartingDateYear, contractPeriod, monthlyCost, electronicAccount, paymentMethod, internet);
        this.freeGB = freeGB;
        this.freeSMS = freeSMS;
    }
    

    public void setFreeGB(int freeGB) {
        this.freeGB = freeGB;
    }

    public void setFreeSMS(int freeSMS) {
        this.freeSMS = freeSMS;
    }

    public int getFreeGB() {
        return freeGB;
    }

    public int getFreeSMS() {
        return freeSMS;
    }
    
}

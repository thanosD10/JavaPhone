/**
 * This code is part of the JAVA exercise for the Object-Oriented Programming course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.it21963;

/**
 *
 * @author thanos
 */
public class Contract {
    private int systemCode;
    private String phoneNum;
    private int AFM;
    private int clientCode;
    private int freeCallsMins;
    private int contractStartingDateDay;
    private int contractStartingDateMonth;
    private int contractStartingDateYear;
    private int contractPeriod;
    private int monthlyCost;
    private int electronicAccount;
    private int paymentMethod;
    private int internet;
    
    public Contract() {
        this.systemCode = 0;
        this.phoneNum = "";
        this.AFM = 0;
        this.clientCode = 0;
        this.freeCallsMins = 0;
        this.contractStartingDateDay = 0;
        this.contractStartingDateMonth = 0;
        this.contractStartingDateYear = 0;
        this.contractPeriod = 0;
        this.monthlyCost = 0;
        this.electronicAccount = 0;
        this.paymentMethod = 0;
        this.internet = 0;
    }
    
    public Contract(int systemCode, String phoneNum, int AFM, int clientCode, int freeCallsMins, int contractStartingDateDay, int contractStartingDateMonth, int contractStartingDateYear, int contractPeriod, int monthlyCost, int electronicAccount, int paymentMethod, int internet) {
        this.systemCode = systemCode;
        this.phoneNum = phoneNum;
        this.AFM = AFM;
        this.clientCode = clientCode;
        this.freeCallsMins = freeCallsMins;
        this.contractStartingDateDay = contractStartingDateDay;
        this.contractStartingDateMonth = contractStartingDateMonth;
        this.contractStartingDateYear = contractStartingDateYear;
        this.contractPeriod = contractPeriod;
        this.monthlyCost = monthlyCost;
        this.electronicAccount = electronicAccount;
        this.paymentMethod = paymentMethod;
        this.internet = internet;
    }

    public void setSystemCode(int systemCode) {
        this.systemCode = systemCode;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }

    public void setFreeCallsMins(int freeCallsMins) {
        this.freeCallsMins = freeCallsMins;
    }

    public void setContractStartingDateDay(int contractStartingDateDay) {
        this.contractStartingDateDay = contractStartingDateDay;
    }

    public void setContractStartingDateMonth(int contractStartingDateMonth) {
        this.contractStartingDateMonth = contractStartingDateMonth;
    }

    public void setContractStartingDateYear(int contractStartingDateYear) {
        this.contractStartingDateYear = contractStartingDateYear;
    }

    public void setContractPeriod(int contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public void setMonthlyCost(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public void setElectronicAccount(int electronicAccount) {
        this.electronicAccount = electronicAccount;
    }
    
    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }
    
    
    public int getSystemCode() {
        return systemCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public int getAFM() {
        return AFM;
    }

    public int getClientCode() {
        return clientCode;
    }

    public int getFreeCallsMins() {
        return freeCallsMins;
    }

    public int getContractStartingDateDay() {
        return contractStartingDateDay;
    }

    public int getContractStartingDateMonth() {
        return contractStartingDateMonth;
    }

    public int getContractStartingDateYear() {
        return contractStartingDateYear;
    }

    public int getContractPeriod() {
        return contractPeriod;
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public int getElectronicAccount() {
        return electronicAccount;
    }
    
    public int getPaymentMethod() {
        return paymentMethod;
    }

    public int getInternet() {
        return internet;
    }
    
}

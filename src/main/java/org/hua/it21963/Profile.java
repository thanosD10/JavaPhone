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
public class Profile {

    private int AFM;
    private int clientCode;
    private String address;
    private String ID;
    private int workStatus;
    private String email;
    private int discounts;
    private ArrayList<MobileContract> mobileContractsList = new ArrayList<>();
    private ArrayList<HomeContract> homeContractsList = new ArrayList<>();

    public Profile() {
        this.AFM = 0;
        this.clientCode = 0;
        this.address = "-";
        this.ID = "-";
        this.workStatus = 0;
        this.email = "-";
        this.discounts = 0;
    }

    public Profile(int AFM, int clientCode, String address, String ID, int workStatus, String email, int discounts) {
        this.AFM = AFM;
        this.clientCode = clientCode;
        this.address = address;
        this.ID = ID;
        this.workStatus = workStatus;
        this.email = email;
        this.discounts = discounts;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setWorkStatus(int workStatus) {
        this.workStatus = workStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiscounts(int discounts) {
        this.discounts = discounts;
    }

    
    public int getAFM() {
        return AFM;
    }

    public int getClientCode() {
        return clientCode;
    }

    public String getAddress() {
        return address;
    }

    public String getID() {
        return ID;
    }

    public int getWorkStatus() {
        return workStatus;
    }

    public String getEmail() {
        return email;
    }

    public int getDiscounts() {
        return discounts;
    }

    public ArrayList<MobileContract> getMobileContractsList() {
        return mobileContractsList;
    }
    
    public ArrayList<HomeContract> getHomeContractList() {
        return homeContractsList;
    }

}

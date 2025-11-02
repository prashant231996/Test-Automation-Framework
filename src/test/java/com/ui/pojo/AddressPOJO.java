package com.ui.pojo;

public class AddressPOJO {

    private String companyName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String homePhoneNo;
    private String mobileNumber;
    private String otherInformation;
    private String addressAlis;
    private String state;

    public AddressPOJO(String companyName, String addressLine1, String addressLine2, String city, String postCode, String homePhoneNo, String mobileNumber, String otherInformation, String addressAlis, String state) {
        this.companyName = companyName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postCode = postCode;
        this.homePhoneNo = homePhoneNo;
        this.mobileNumber = mobileNumber;
        this.otherInformation = otherInformation;
        this.addressAlis = addressAlis;
        this.state = state;
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getHomePhoneNo() {
        return homePhoneNo;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public String getAddressAlis() {
        return addressAlis;
    }

    public String getState() {
        return state;
    }
}


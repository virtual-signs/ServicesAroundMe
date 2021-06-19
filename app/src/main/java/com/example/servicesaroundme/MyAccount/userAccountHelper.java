package com.example.servicesaroundme.MyAccount;

public class userAccountHelper {
    public String userAccountId, userAccountFirstName, userAccountMiddleName, userAccountLastName, userAccountProfileTitle, userAccountProfileDesc;
    public Boolean userAccountVerifiedUsingOTP, userAccountActiveStatus;
    public String userAccountType;

    //public String addressNickName,addressType, addressLine1, addressLine2, addressLine3, addressCity, addressCounty, addressCountry, addressPostcode, addressEmail, addressMobile, addressLandline, addressWebsite;


    public userAccountHelper() {
    }

    public userAccountHelper(String userAccountId,
                             String userAccountFirstName,
                             String userAccountMiddleName,
                             String userAccountLastName,
                             String userAccountProfileTitle,
                             String userAccountProfileDesc,
                             Boolean userAccountVerifiedUsingOTP,
                             Boolean userAccountActiveStatus,
                             String userAccountType) {
        this.userAccountId = userAccountId;
        this.userAccountFirstName = userAccountFirstName;
        this.userAccountMiddleName = userAccountMiddleName;
        this.userAccountLastName = userAccountLastName;
        this.userAccountProfileTitle = userAccountProfileTitle;
        this.userAccountProfileDesc = userAccountProfileDesc;
        this.userAccountVerifiedUsingOTP = userAccountVerifiedUsingOTP;
        this.userAccountActiveStatus = userAccountActiveStatus;
        this.userAccountType = userAccountType;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUserAccountFirstName() {
        return userAccountFirstName;
    }

    public void setUserAccountFirstName(String userAccountFirstName) {
        this.userAccountFirstName = userAccountFirstName;
    }

    public String getUserAccountMiddleName() {
        return userAccountMiddleName;
    }

    public void setUserAccountMiddleName(String userAccountMiddleName) {
        this.userAccountMiddleName = userAccountMiddleName;
    }

    public String getUserAccountLastName() {
        return userAccountLastName;
    }

    public void setUserAccountLastName(String userAccountLastName) {
        this.userAccountLastName = userAccountLastName;
    }

    public String getUserAccountProfileTitle() {
        return userAccountProfileTitle;
    }

    public void setUserAccountProfileTitle(String userAccountProfileTitle) {
        this.userAccountProfileTitle = userAccountProfileTitle;
    }

    public String getUserAccountProfileDesc() {
        return userAccountProfileDesc;
    }

    public void setUserAccountProfileDesc(String userAccountProfileDesc) {
        this.userAccountProfileDesc = userAccountProfileDesc;
    }

    public Boolean getUserAccountVerifiedUsingOTP() {
        return userAccountVerifiedUsingOTP;
    }

    public void setUserAccountVerifiedUsingOTP(Boolean userAccountVerifiedUsingOTP) {
        this.userAccountVerifiedUsingOTP = userAccountVerifiedUsingOTP;
    }

    public Boolean getUserAccountActiveStatus() {
        return userAccountActiveStatus;
    }

    public void setUserAccountActiveStatus(Boolean userAccountActiveStatus) {
        this.userAccountActiveStatus = userAccountActiveStatus;
    }

    public String getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }
    
}

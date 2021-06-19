package com.example.servicesaroundme.QuotesMgmt;

import java.util.Date;

public class requestsHelper {
    public String requestId, requestServiceId, requestPreferredProviderId_1,requestPreferredProviderId_2, requestPreferredProviderId_3, requestStatusId, requestApprovedQuoteId, requestApprovedOrderId, requestApprovedFeedbackId;
    public String requestTitle, requestDesc;
    public Boolean requestRequiredASAP;
    public Date requestPublishedDataTime, requestExpiryDateTime;

    public requestsHelper() {
    }

    public requestsHelper(String requestId,
                          String requestTitle,
                          String requestDesc,
                          Boolean requestRequiredASAP,
                          Date requestExpiryDateTime,
                          String requestServiceId,
                          String requestPreferredProviderId_1,
                          String requestPreferredProviderId_2,
                          String requestPreferredProviderId_3,
                          String requestStatusId,
                          String requestApprovedQuoteId,
                          String requestApprovedOrderId,
                          String requestApprovedFeedbackId) {
        this.requestId = requestId;
        this.requestTitle = requestTitle;
        this.requestDesc = requestDesc;
        this.requestRequiredASAP = requestRequiredASAP;
        this.requestExpiryDateTime = requestExpiryDateTime;
        this.requestServiceId = requestServiceId;
        this.requestPreferredProviderId_1 = requestPreferredProviderId_1;
        this.requestPreferredProviderId_2 = requestPreferredProviderId_2;
        this.requestPreferredProviderId_3 = requestPreferredProviderId_3;
        this.requestStatusId = requestStatusId;
        this.requestApprovedQuoteId = requestApprovedQuoteId;
        this.requestApprovedOrderId = requestApprovedOrderId;
        this.requestApprovedFeedbackId = requestApprovedFeedbackId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }

    public Boolean getRequestRequiredASAP() {
        return requestRequiredASAP;
    }

    public void setRequestRequiredASAP(Boolean requestRequiredASAP) {
        this.requestRequiredASAP = requestRequiredASAP;
    }

    public Date getRequestExpiryDateTime() {
        return requestExpiryDateTime;
    }

    public void setRequestExpiryDateTime(Date requestExpiryDateTime) {
        this.requestExpiryDateTime = requestExpiryDateTime;
    }

    public String getRequestServiceId() {
        return requestServiceId;
    }

    public void setRequestServiceId(String requestServiceId) {
        this.requestServiceId = requestServiceId;
    }

    public String getRequestPreferredProviderId_1() {
        return requestPreferredProviderId_1;
    }

    public void setRequestPreferredProviderId_1(String requestPreferredProviderId_1) {
        this.requestPreferredProviderId_1 = requestPreferredProviderId_1;
    }

    public String getRequestPreferredProviderId_2() {
        return requestPreferredProviderId_2;
    }

    public void setRequestPreferredProviderId_2(String requestPreferredProviderId_2) {
        this.requestPreferredProviderId_2 = requestPreferredProviderId_2;
    }

    public String getRequestPreferredProviderId_3() {
        return requestPreferredProviderId_3;
    }

    public void setRequestPreferredProviderId_3(String requestPreferredProviderId_3) {
        this.requestPreferredProviderId_3 = requestPreferredProviderId_3;
    }

    public String getRequestStatusId() {
        return requestStatusId;
    }

    public void setRequestStatusId(String requestStatusId) {
        this.requestStatusId = requestStatusId;
    }

    public String getRequestApprovedQuoteId() {
        return requestApprovedQuoteId;
    }

    public void setRequestApprovedQuoteId(String requestApprovedQuoteId) {
        this.requestApprovedQuoteId = requestApprovedQuoteId;
    }

    public String getRequestApprovedOrderId() {
        return requestApprovedOrderId;
    }

    public void setRequestApprovedOrderId(String requestApprovedOrderId) {
        this.requestApprovedOrderId = requestApprovedOrderId;
    }

    public String getRequestApprovedFeedbackId() {
        return requestApprovedFeedbackId;
    }

    public void setRequestApprovedFeedbackId(String requestApprovedFeedbackId) {
        this.requestApprovedFeedbackId = requestApprovedFeedbackId;
    }
}

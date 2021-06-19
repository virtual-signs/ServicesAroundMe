package com.example.servicesaroundme.QuotesMgmt;

import java.util.Date;

public class quotesHelper {

    public String quoteId, quoteRequestId, quoteStatusId;
    public String quoteInvoiceMessage, quoteAmountCurrency;
    public Double quoteInvoiceAmount;
    public Date quotePublishedDateTime, quoteExpiryDateTime;

    public quotesHelper() {
    }

    public quotesHelper(String quoteId,
                        String quoteRequestId,
                        String quoteStatusId,
                        String quoteInvoiceMessage,
                        String quoteAmountCurrency,
                        Double quoteInvoiceAmount,
                        Date quotePublishedDateTime,
                        Date quoteExpiryDateTime) {
        this.quoteId = quoteId;
        this.quoteRequestId = quoteRequestId;
        this.quoteStatusId = quoteStatusId;
        this.quoteInvoiceMessage = quoteInvoiceMessage;
        this.quoteAmountCurrency = quoteAmountCurrency;
        this.quoteInvoiceAmount = quoteInvoiceAmount;
        this.quotePublishedDateTime = quotePublishedDateTime;
        this.quoteExpiryDateTime = quoteExpiryDateTime;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuoteRequestId() {
        return quoteRequestId;
    }

    public void setQuoteRequestId(String quoteRequestId) {
        this.quoteRequestId = quoteRequestId;
    }

    public String getQuoteStatusId() {
        return quoteStatusId;
    }

    public void setQuoteStatusId(String quoteStatusId) {
        this.quoteStatusId = quoteStatusId;
    }

    public String getQuoteInvoiceMessage() {
        return quoteInvoiceMessage;
    }

    public void setQuoteInvoiceMessage(String quoteInvoiceMessage) {
        this.quoteInvoiceMessage = quoteInvoiceMessage;
    }

    public String getQuoteAmountCurrency() {
        return quoteAmountCurrency;
    }

    public void setQuoteAmountCurrency(String quoteAmountCurrency) {
        this.quoteAmountCurrency = quoteAmountCurrency;
    }

    public Double getQuoteInvoiceAmount() {
        return quoteInvoiceAmount;
    }

    public void setQuoteInvoiceAmount(Double quoteInvoiceAmount) {
        this.quoteInvoiceAmount = quoteInvoiceAmount;
    }

    public Date getQuotePublishedDateTime() {
        return quotePublishedDateTime;
    }

    public void setQuotePublishedDateTime(Date quotePublishedDateTime) {
        this.quotePublishedDateTime = quotePublishedDateTime;
    }

    public Date getQuoteExpiryDateTime() {
        return quoteExpiryDateTime;
    }

    public void setQuoteExpiryDateTime(Date quoteExpiryDateTime) {
        this.quoteExpiryDateTime = quoteExpiryDateTime;
    }
}

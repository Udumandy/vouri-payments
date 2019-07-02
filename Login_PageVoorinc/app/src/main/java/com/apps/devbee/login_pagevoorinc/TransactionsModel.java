package com.apps.devbee.login_pagevoorinc;

public class TransactionsModel {

    long transactionTime;
    float transactionAmount;
    String transactionSettlementCurrency;
    String transactionProcessingCurrency;
    short transactionStatus;
    String transactionSenderId;
    String transactionRecipientId;

    public TransactionsModel(float i) {
        this.transactionAmount = i;
    }

    @Override
    public boolean equals(Object tt){
        return this.transactionAmount == ((TransactionsModel)tt).getTransactionAmount();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    String transactionId;

    public long getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(long transactionTime) {
        this.transactionTime = transactionTime;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionSettlementCurrency() {
        return transactionSettlementCurrency;
    }

    public void setTransactionSettlementCurrency(String transactionSettlementCurrency) {
        this.transactionSettlementCurrency = transactionSettlementCurrency;
    }

    public String getTransactionProcessingCurrency() {
        return transactionProcessingCurrency;
    }

    public void setTransactionProcessingCurrency(String transactionProcessingCurrency) {
        this.transactionProcessingCurrency = transactionProcessingCurrency;
    }

    public short getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(short transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionSenderId() {
        return transactionSenderId;
    }

    public void setTransactionSenderId(String transactionSenderId) {
        this.transactionSenderId = transactionSenderId;
    }

    public String getTransactionRecipientId() {
        return transactionRecipientId;
    }

    public void setTransactionRecipientId(String transactionRecipientId) {
        this.transactionRecipientId = transactionRecipientId;
    }

    public TransactionsModel(long transactionTime, float transactionAmount, String transactionSettlementCurrency, short transactionStatus) {
        this.transactionTime = transactionTime;
        this.transactionAmount = transactionAmount;
        this.transactionSettlementCurrency = transactionSettlementCurrency;
        this.transactionStatus = transactionStatus;
    }
}

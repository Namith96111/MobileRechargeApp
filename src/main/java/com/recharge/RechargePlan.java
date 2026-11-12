
package com.recharge;

public class RechargePlan {

    private int planId;
    private String planName;
    private double amount;
    private int validity;

    public RechargePlan(int planId, String planName, double amount, int validity) {
        this.planId = planId;
        this.planName = planName;
        this.amount = amount;
        this.validity = validity;
    }

    public int getPlanId() {
        return planId;
    }

    public String getPlanName() {
        return planName;
    }

    public double getAmount() {
        return amount;
    }

    public int getValidity() {
        return validity;
    }
}

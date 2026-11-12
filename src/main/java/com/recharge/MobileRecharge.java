
package com.recharge;

import java.util.Scanner;

public class MobileRecharge {

    static RechargePlan[] plans = {
        new RechargePlan(1, "Basic Plan", 199, 28),
        new RechargePlan(2, "Standard Plan", 299, 56),
        new RechargePlan(3, "Premium Plan", 499, 84)
    };

    public static boolean validateMobile(String mobile) {
        return mobile != null && mobile.matches("[6-9][0-9]{9}");
    }

    public static RechargePlan selectPlan(int id) {
        for (RechargePlan plan : plans) {
            if (plan.getPlanId() == id) {
                return plan;
            }
        }
        return null;
    }

    public static double recharge(String mobile, int planId) {
        if (!validateMobile(mobile)) {
            return -1;
        }

        RechargePlan plan = selectPlan(planId);

        if (plan == null) {
            return -1;
        }

        return plan.getAmount();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter mobile number: ");
        String mobile = sc.nextLine();

        if (!validateMobile(mobile)) {
            System.out.println("Invalid mobile number!");
            return;
        }

        System.out.println("\nAvailable Recharge Plans:");

        for (RechargePlan plan : plans) {
            System.out.println(plan.getPlanId() + ". "
                    + plan.getPlanName() + " - Rs."
                    + plan.getAmount() + " - "
                    + plan.getValidity() + " days");
        }

        System.out.print("\nSelect plan: ");
        int choice = sc.nextInt();

        double amount = recharge(mobile, choice);

        if (amount > 0) {
            System.out.println("Recharge Successful!");
            System.out.println("Mobile: " + mobile);
            System.out.println("Amount: Rs." + amount);
        } else {
            System.out.println("Recharge Failed!");
        }

        sc.close();
    }
}

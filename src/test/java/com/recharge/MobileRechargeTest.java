
package com.recharge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MobileRechargeTest {

    @Test
    public void testValidMobileNumber() {
        assertTrue(MobileRecharge.validateMobile("9876543210"));
    }

    @Test
    public void testInvalidMobileNumber() {
        assertFalse(MobileRecharge.validateMobile("12345"));
    }

    @Test
    public void testAvailablePlans() {
        assertEquals(3, MobileRecharge.plans.length);
    }

    @Test
    public void testSelectPlan() {
        RechargePlan plan = MobileRecharge.selectPlan(1);
        assertNotNull(plan);
        assertEquals(199.0, plan.getAmount());
    }

    @Test
    public void testInvalidPlanSelection() {
        assertNull(MobileRecharge.selectPlan(10));
    }

    @Test
    public void testRechargeAmount() {
        assertEquals(199.0,
            MobileRecharge.recharge("9876543210", 1));
    }

    @Test
    public void testInvalidRecharge() {
        assertEquals(-1.0,
            MobileRecharge.recharge("12345", 1));
    }
}

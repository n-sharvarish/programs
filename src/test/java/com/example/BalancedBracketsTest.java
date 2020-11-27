package com.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BalancedBracketsTest {

    @BeforeClass
    public void setUp() {
        TestUtils.setUpMessage(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        TestUtils.tearDownMessage(this.getClass());
    }

    @Test
    public void testBalancedBrackets() {

        BalancedBrackets balancedBrackets = new BalancedBrackets();

        Assert.assertTrue(balancedBrackets.isBalanced("(){}[]"), "(){}[] should be balanced");

        Assert.assertTrue(balancedBrackets.isBalanced("({[]})"), "({[]}) should be balanced");

        Assert.assertTrue(balancedBrackets.isBalanced("{[()]}"), "{[()]} should be balanced");

        Assert.assertTrue(!balancedBrackets.isBalanced("(){}[]("), "(){}[]( should not be balanced");

        Assert.assertTrue(!balancedBrackets.isBalanced("(){}[]]"), "(){}[]] should not be balanced");

        Assert.assertTrue(!balancedBrackets.isBalanced("{{}[]()"), "{{}[]() should not be balanced");

        Assert.assertTrue(!balancedBrackets.isBalanced("){}[]()"), "){}[]() should not be balanced");

        Assert.assertTrue(!balancedBrackets.isBalanced("[](){{{}}}}"), "[](){{{}}}} should not be balanced");

        Assert.assertTrue(balancedBrackets.isBalanced("{{[()]}}[](({}[]))"), "{{[()]}}[](({}[])) should be balanced");
    }
}

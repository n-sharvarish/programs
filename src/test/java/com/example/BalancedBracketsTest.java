package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BalancedBracketsTest extends BaseTest {

    @Test
    public void testBalancedBrackets() {

        BalancedBrackets balancedBrackets = new BalancedBrackets();

        Assert.assertTrue(balancedBrackets.isBalanced("(){}[]"), "(){}[] should be balanced");
        System.out.println("(){}[] are balanced");

        System.out.println();
        Assert.assertTrue(balancedBrackets.isBalanced("({[]})"), "({[]}) should be balanced");
        System.out.println("({[]}) are balanced");

        System.out.println();
        Assert.assertTrue(balancedBrackets.isBalanced("{[()]}"), "{[()]} should be balanced");
        System.out.println("{[()]} are balanced");

        System.out.println();
        Assert.assertTrue(!balancedBrackets.isBalanced("(){}[]("), "(){}[]( should not be balanced");
        System.out.println("(){}[]( are not balanced");

        System.out.println();
        Assert.assertTrue(!balancedBrackets.isBalanced("(){}[]]"), "(){}[]] should not be balanced");
        System.out.println("(){}[]] are not balanced");

        System.out.println();
        Assert.assertTrue(!balancedBrackets.isBalanced("{{}[]()"), "{{}[]() should not be balanced");
        System.out.println("{{}[]() are not balanced");

        System.out.println();
        Assert.assertTrue(!balancedBrackets.isBalanced("){}[]()"), "){}[]() should not be balanced");
        System.out.println("){}[]() are not balanced");

        System.out.println();
        Assert.assertTrue(!balancedBrackets.isBalanced("[](){{{}}}}"), "[](){{{}}}} should not be balanced");
        System.out.println("[](){{{}}}} are not balanced");

        System.out.println();
        Assert.assertTrue(balancedBrackets.isBalanced("{{[()]}}[](({}[]))"), "{{[()]}}[](({}[])) should be balanced");
        System.out.println("{{[()]}}[](({}[])) are not balanced");
    }
}

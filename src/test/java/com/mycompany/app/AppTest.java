package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testEmptyArray()
    {
        ArrayList<String> array = new ArrayList<>();


    }

    public void testBigQuantity() {
        ArrayList<String> array = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> nArray = new ArrayList<>(Arrays.asList("2", "3", "4", "5"));
        int quantity = 5;
        ArrayList<String> result = App.generate(array, nArray, quantity, 2);
        assertEquals(null, result);

    }

    public void testNegativeQuantity(){
        ArrayList<String> array = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> nArray = new ArrayList<>(Arrays.asList("2", "3", "4", "5"));
        int quantity = -5;
        ArrayList<String> result = App.generate(array, nArray, quantity, 2);
        assertEquals(null, result);
    }

    public void testNumListHasNonDigitValue(){
        ArrayList<String> nArray = new ArrayList<>(Arrays.asList("2", "b", "4", "5"));
        boolean result = App.containsNonNumeric(nArray);
        assertEquals(true, result);
    }

    public void testWorkingAsExpected(){
        ArrayList<String> array = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> nArray = new ArrayList<>(Arrays.asList("2", "3", "4", "5"));
        ArrayList<String> result = App.generate(array, nArray, 3, 2);
        assertNotNull(result);
    }
}

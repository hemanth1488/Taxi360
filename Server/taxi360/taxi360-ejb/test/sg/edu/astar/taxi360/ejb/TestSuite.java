/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.astar.taxi360.ejb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Hemanth 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    RequestEJBTest.class,
    //CommonEJBTest.class,
    //PassengerEJBTest.class,
    DriverEJBTest.class
})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Test Suite Start.");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

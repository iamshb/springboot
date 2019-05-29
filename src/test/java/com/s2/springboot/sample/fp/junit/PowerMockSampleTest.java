package com.s2.springboot.sample.fp.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class PowerMockSampleTest {

    private PowerMockSample powerMockSample;

    @Before
    public void setUp() throws Exception {
        powerMockSample = new PowerMockSample();
    }

    @Test
    public void powerMockTest() throws Exception {
//        PowerMockSample mock = spy()
        Object obj = Whitebox.invokeMethod(powerMockSample, "powerMockTest", "TT");
        assertEquals("TT", obj);
    }
}
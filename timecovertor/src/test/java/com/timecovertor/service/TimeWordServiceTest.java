package com.timecovertor.service;

import com.timecovertor.vo.TimeVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.timecovertor.constants.ApplicationConstants.INVALID_TIME_RANGE;
import static org.junit.jupiter.api.Assertions.*;


/**
 * -----------------------------------------------------------------------------
 * File        : TimeWordServiceTest.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */
public class TimeWordServiceTest {

    @Autowired
    private TimeWordService timeWordService;

    @BeforeEach
    public void init(){
        timeWordService = new TimeWordServiceImpl();
    }


    @Test
    public void testTimeWordServiceShouldNotBeNull(){
        assertNotNull(timeWordService);
    }

    @Test
    public void testValidHourMinShouldCovertedSuccess(){
        String timeString = "2:10";
        TimeVO timeActual = timeWordService.retrieveHourMinuteFromInputString(timeString);
        assertNotNull(timeActual);
        assertEquals(2, timeActual.getHour());
        assertEquals(10, timeActual.getMinute());

    }


    @Test
    public void testInvalidTimeOutsideTimeRangeShouldThrowException(){
        String timeString = "35:50";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            timeWordService.retrieveHourMinuteFromInputString(timeString);
        });
        assertEquals(INVALID_TIME_RANGE, exception.getMessage());
    }

    //******Time conversion tests ****************/
    @Test
    public void testOneOClockShouldConvertSuccess() {

        String inputString = "01:00";
        String expectedString = "one o'clock";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);
    }

    @Test
    public void testMinutesBefore30MinShouldReturnMMPastHHSuccess() {

        String inputString = "02:05";
        String expectedString = "five past two";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);

    }

    @Test
    public void testHalfPastHourSuccess(){

        String inputString = "7:30";
        String expectedString = "half past seven";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);
    }

    @Test
    public void testQuarterPastHourSuccess(){

        String inputString = "4:15";
        String expectedString = "quarter past four";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);


    }

    @Test
    public void testQuarterToHourSuccess(){

        String inputString = "9:45";
        String expectedString = "quarter to ten";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);


    }

    @Test
    public void testMinutesAfter30MinShouldReturnMMPastHHSuccess() {

        String inputString = "11:55";
        String expectedString = "five to twelve";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);

    }

    @Test
    public void testMinutesAfter30FiveToTwelve() {

        String inputString = "11:55";
        String expectedString = "five to twelve";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);

    }

    @Test
    public void testMinutesAfter30TenToEleven() {

        String inputString = "10:50";
        String expectedString = "ten to eleven";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);

    }


    @Test
    public void testNoonSuccess() {

        String inputString = "12:00";
        String expectedString = "noon";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);

    }

    @Test
    public void testMidnightSuccess() {

        String inputString = "00:00";
        String expectedString = "midnight";
        String actualTime = timeWordService.toSpokenTime(inputString);
        assertNotNull(actualTime);
        assertEquals(actualTime, expectedString);

    }

    @Test
    public void testInvalidInoutOutsideTimeRangeShouldThrowException(){
        String timeString = "35:50";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            timeWordService.toSpokenTime(timeString);
        });
        assertEquals(INVALID_TIME_RANGE, exception.getMessage());
    }







}

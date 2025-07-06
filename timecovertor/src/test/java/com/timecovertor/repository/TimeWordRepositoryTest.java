package com.timecovertor.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * -----------------------------------------------------------------------------
 * File        : TimeWordRepositoryTest.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * Description : Unit tests for the TimeWordRepository class.
 * -----------------------------------------------------------------------------
 */


public class TimeWordRepositoryTest {

    private TimeWordRepository timeWordRepository;

    @BeforeEach
    public void init(){
        timeWordRepository = new TimeWordRepository();
    }

    @Test
    public void testTimeWordRepositoryIsNotEmpty(){
        assertNotNull(timeWordRepository);
    }

    @Test
    public void testAllKnownValuesShouldFetchStringRepresenationSuccess(){
        assertEquals("one", timeWordRepository.retrieveTimeFromString(1));
        assertEquals("o'clock", timeWordRepository.retrieveTimeFromString(0));
        assertEquals("ten", timeWordRepository.retrieveTimeFromString(10));
        assertEquals("nineteen", timeWordRepository.retrieveTimeFromString(19));
        assertEquals("half", timeWordRepository.retrieveTimeFromString(30));
    }

    @Test
    public void testUnknownValueShouldReturnValueItself(){
        assertEquals("31", timeWordRepository.retrieveTimeFromString(31));
        assertEquals("-1", timeWordRepository.retrieveTimeFromString(-1));

    }




}

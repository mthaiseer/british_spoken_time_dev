package com.timecovertor.strategy;

import com.timecovertor.vo.TimeVO;


/**
 * -----------------------------------------------------------------------------
 * File        : TimeSpeechStrategy.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */
public interface TimeSpeechStrategy {
    String toSpeech(TimeVO timeVO);
}
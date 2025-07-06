package com.timecovertor.strategy;

import com.timecovertor.constants.ApplicationConstants;
import com.timecovertor.vo.TimeVO;

/**
 * -----------------------------------------------------------------------------
 * File        : NoonStrategy.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */
public class NoonStrategy implements TimeSpeechStrategy {

    @Override
    public String toSpeech(TimeVO timeVO) {
        return ApplicationConstants.NOON;
    }
}

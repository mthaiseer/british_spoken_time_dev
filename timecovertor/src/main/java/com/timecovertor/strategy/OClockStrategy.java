package com.timecovertor.strategy;

import com.timecovertor.repository.TimeWordRepository;
import com.timecovertor.vo.TimeVO;

/**
 * -----------------------------------------------------------------------------
 * File        : OClockStrategy.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */
public class OClockStrategy  implements TimeSpeechStrategy {

    private final TimeWordRepository repo;
    public OClockStrategy(TimeWordRepository repo) {
        this.repo = repo;
    }
    @Override
    public String toSpeech(TimeVO timeVO) {
        int hour = timeVO.getHour();
        int spokenHour = hour % 12 == 0 ? 12 : hour % 12;
        String hourWord = repo.retrieveTimeFromString(spokenHour);
        return hourWord + " o'clock";
    }

}

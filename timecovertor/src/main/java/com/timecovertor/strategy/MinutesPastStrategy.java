package com.timecovertor.strategy;

import com.timecovertor.repository.TimeWordRepository;
import com.timecovertor.vo.TimeVO;


/**
 * -----------------------------------------------------------------------------
 * File        : MinutesPastStrategy.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */

public class MinutesPastStrategy  implements TimeSpeechStrategy {

    private final TimeWordRepository repo;
    public MinutesPastStrategy(TimeWordRepository repo) {
        this.repo = repo;
    }

    @Override
    public String toSpeech(TimeVO timeVO) {
        int hour = timeVO.getHour();
        int minute = timeVO.getMinute();

        int spokenHour = hour % 12 == 0 ? 12 : hour % 12;
        String hourWord = repo.retrieveTimeFromString(spokenHour);

        if (minute == 15) return "quarter past " + hourWord;
        if (minute == 30) return "half past " + hourWord;
        String minWord = repo.retrieveTimeFromString(minute);
        return minWord + " past " + hourWord;
    }
}

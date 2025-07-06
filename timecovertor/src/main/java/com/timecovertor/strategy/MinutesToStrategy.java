package com.timecovertor.strategy;

import com.timecovertor.repository.TimeWordRepository;
import com.timecovertor.vo.TimeVO;


/**
 * -----------------------------------------------------------------------------
 * File        : MinutesToStrategy.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */


public class MinutesToStrategy  implements TimeSpeechStrategy  {

    private final TimeWordRepository repo;
    public MinutesToStrategy(TimeWordRepository repo) {
        this.repo = repo;
    }

    @Override
    public String toSpeech(TimeVO timeVO) {
        int hour = timeVO.getHour();
        int minute = timeVO.getMinute();

        int minutesTo = 60 - minute;
        String minWord = repo.retrieveTimeFromString(minutesTo);

        int nextHour = (hour + 1) % 24;
        String nextHourWord = (nextHour == 0) ? repo.retrieveTimeFromString(12)
                : nextHour == 12 ? "twelve"
                : repo.retrieveTimeFromString(nextHour % 12);

        if (minutesTo == 15) return "quarter to " + nextHourWord;
        return minWord + " to " + nextHourWord;
    }
}

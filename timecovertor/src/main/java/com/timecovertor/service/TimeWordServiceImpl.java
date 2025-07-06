package com.timecovertor.service;


import com.timecovertor.repository.TimeWordRepository;
import com.timecovertor.strategy.*;
import com.timecovertor.vo.TimeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.timecovertor.constants.ApplicationConstants.INVALID_TIME_RANGE;



/**
 * -----------------------------------------------------------------------------
 * File        : TimeWordServiceImpl.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */
public class TimeWordServiceImpl implements TimeWordService {

    Logger logger = LoggerFactory.getLogger("TimeWordServiceImpl");

    private final TimeWordRepository timeWordRepository = new TimeWordRepository();
    @Override
    public TimeVO retrieveHourMinuteFromInputString(String timeString) {

        try{
            LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("H:mm"));
            int hour = time.getHour();
            int minute = time.getMinute();

            logger.info("Hour received {}", hour);
            logger.info("Minutes received {}", minute);

            TimeVO timeBuild = new TimeVO();
            timeBuild.setHour(hour);
            timeBuild.setMinute(minute);
            return timeBuild;

        }catch (DateTimeParseException dateTimeParseException){
            //TODO make custom exception
            throw new RuntimeException(INVALID_TIME_RANGE);

        }


    }


    public String toSpokenTime(String timeStr) {
        TimeVO timeVO = retrieveHourMinuteFromInputString(timeStr);
        TimeSpeechStrategy strategy = selectStrategy(timeVO);
        return strategy.toSpeech(timeVO);
    }

    private TimeSpeechStrategy  selectStrategy(TimeVO timeVO) {
        int hour = timeVO.getHour();
        int minute = timeVO.getMinute();

        if (isNoon(hour, minute)) return new NoonStrategy();
        if (isMidnight(hour, minute)) return new MidnightStrategy();
        if (minute == 0) return new OClockStrategy(timeWordRepository);
        if (minute <= 30) return new MinutesPastStrategy(timeWordRepository);
        return new MinutesToStrategy(timeWordRepository);
    }

    private static boolean isMinutesLessThan30(int minute) {
        return minute <= 30;
    }

    private static boolean isMidnight(int hour, int minute) {
        return hour == 0 && minute == 0;
    }

    private static boolean isNoon(int hour, int minute) {
        return hour == 12 && minute == 0;
    }
}

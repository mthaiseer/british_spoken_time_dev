package com.timecovertor.service;

import com.timecovertor.vo.TimeVO;


/**
 * -----------------------------------------------------------------------------
 * File        : TimeWordService.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */

public interface TimeWordService {

    public TimeVO retrieveHourMinuteFromInputString(String timeString);
    public String toSpokenTime(String timeStr);
}

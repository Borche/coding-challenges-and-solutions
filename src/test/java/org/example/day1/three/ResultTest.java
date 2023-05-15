package org.example.day1.three;

import org.example.hackerrank.day1.three.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void lawl() {
        String r1 = Result.timeConversion("12:01:00PM");
        String r2 = Result.timeConversion("12:01:00AM");
        String r3 = Result.timeConversion("07:05:45PM");

        Assertions.assertAll(
                () -> assertEquals("12:01:00", r1),
                () -> assertEquals("00:01:00", r2),
                () -> assertEquals("19:05:45", r3)
        );
    }
}
package com.nowcoder.community;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class basicTests {

    @Test
    public void DateTests() {
        int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;
//        System.out.println(new Date(System.currentTimeMillis() + REMEMBER_EXPIRED_SECONDS * 1000));
        System.out.println(LocalDateTime.now());
    }
}

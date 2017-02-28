package com.hucet.mail.security.provider;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by taesu on 2017-03-01.
 */
public class Utils {
    private static final int EXPIRATION_HOUR = 24;

    public static Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, EXPIRATION_HOUR);
        return cal.getTime();
    }
}

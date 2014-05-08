package org.springframework.samples.webflow.ajax;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    public String getCurrentDate() {
        String date = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSz\n" ).format( new Date() ); //$NON-NLS-1$

        return date;
    }
}

package com.songhee.demo.common.utils;

import com.songhee.demo.common.code.DefaultValues;

import com.songhee.demo.common.code.ErrorCode;
import com.songhee.demo.common.error.exception.BusinessException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;
import java.util.TimeZone;

public class DateTimeUtil {


  public static String convert_ISO_8601(Timestamp timestamp, String timeZoneName) {
    if(timestamp == null)
      return "";
    SimpleDateFormat df = new SimpleDateFormat(DefaultValues.DATE_FORMAT_ISO_8601);
    Date date = new Date(timestamp.toInstant().toEpochMilli());
    df.setTimeZone(TimeZone.getTimeZone(timeZoneName));
    return df.format(date);
  }

  public static Timestamp convert_date(String timeISO8601) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(DefaultValues.DATE_FORMAT_ISO_8601);
    dateFormat.setTimeZone(TimeZone.getTimeZone(DefaultValues.TIME_ZONE_UTC));
    Date date;
    try {
      date = (Date) dateFormat.parse(timeISO8601);
    } catch (ParseException e) {
      throw new BusinessException(ErrorCode.NO_CONVERT_TO_TIMESTAMP);
    }
    return new Timestamp(date.getTime());
  }

}

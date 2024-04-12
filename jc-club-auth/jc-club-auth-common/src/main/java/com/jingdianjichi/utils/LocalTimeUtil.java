package com.jingdianjichi.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeUtil {

    public static LocalDateTime getLocalTime(){
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();

//        // 创建DateTimeFormatter对象，定义日期和时间的格式
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        // 使用formatter对currentTime进行格式化
//        LocalDateTime formattedTime = LocalDateTime.parse(currentTime.format(formatter));

        return currentTime;
    }
}

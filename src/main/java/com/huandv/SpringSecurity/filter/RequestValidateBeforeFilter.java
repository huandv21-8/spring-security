package com.huandv.SpringSecurity.filter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/27/2024 3:16 PM
 * @Author: crist
 */
public class RequestValidateBeforeFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}

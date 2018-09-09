package com.thoughtmechanix.organization.utils;

import org.springframework.http.HttpHeaders;

public class UserContext {
    private UserContext() {
    }

    private static final String CORRELATION_ID = "tmx-correlation-id";

    private static final ThreadLocal<String> correlationId = new ThreadLocal<>();


    public static String getCorrelationId() {
        return correlationId.get();
    }

    public static void setCorrelationId(String cid) {
        correlationId.set(cid);
    }


    public static HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CORRELATION_ID, getCorrelationId());

        return httpHeaders;
    }
}

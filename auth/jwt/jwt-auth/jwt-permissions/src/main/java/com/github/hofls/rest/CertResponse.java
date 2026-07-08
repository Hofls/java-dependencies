package com.github.hofls.rest;

import java.util.List;
import java.util.Map;

public class CertResponse {

    public List<Map<String, Object>> keys;

    public CertResponse(List<Map<String, Object>> keys) {
        this.keys = keys;
    }
}

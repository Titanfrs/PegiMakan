package com.titanfrs.kulineran.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoModel {
    private String result;
    private List<ItemRestoModel> item = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ItemRestoModel> getItem() {
        return item;
    }

    public void setItem(List<ItemRestoModel> item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
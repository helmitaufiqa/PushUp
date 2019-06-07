package com.example.testapp.model;

import java.util.List;

public class ModelValue {
    String value;
    String message;
    List<ModelMahasiswa> result;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ModelMahasiswa> getResult() {
        return result;
    }

    public void setResult(List<ModelMahasiswa> result) {
        this.result = result;
    }
}

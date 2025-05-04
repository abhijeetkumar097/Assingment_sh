package com.example.Assignment.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Severity {
    LOW,
    MEDIUM,
    HIGH;

    @JsonCreator
    public static Severity fromString(String value) {
        if(value != null) {
            value = value.toUpperCase();

            switch (value) {
                case "LOW": return LOW;
                case "MEDIUM": return MEDIUM;
                case "HIGH": return HIGH;
                default: return null;
            }
        }
        return null;
    }
}

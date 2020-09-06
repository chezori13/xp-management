package com.platform.cloud.xpmanagement.model.basetype;

public enum ExperienceType {
    EARN("Earn"), PENALTY("Penalty");

    private String value;

    ExperienceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static ExperienceType fromString(String text) {
        if(null==text){
            return null;
        }

        switch (text.toUpperCase()) {
            case "EARN":
                return ExperienceType.EARN;
            case "PENALTY":
                return ExperienceType.PENALTY;
            default:
                throw new RuntimeException(String.format("Invalid ExperienceType: %s", text));

        }
    }
}
package com.vittach.enums;

/**
 * Created by VITTACH on 22.10.2016.
 */
public enum DiagnosisEnum {
    gripp("вирус"),
    angina("вирус"),
    appendicitis("воспаление");

    private final String name;

    @Override
    public String toString() {
        return name;
    }

    DiagnosisEnum(String n) {
        this.name=n;
    }
}

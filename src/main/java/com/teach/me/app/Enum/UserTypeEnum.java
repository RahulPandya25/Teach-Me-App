package com.teach.me.app.Enum;

public enum UserTypeEnum {
    TUTOR(0), STUDENT(1);

    private int index;
    UserTypeEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

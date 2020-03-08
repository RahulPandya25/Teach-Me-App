package com.teach.me.app.Enum;

public enum OptionEnum {

    OPTION_1(1), OPTION_2(2), OPTION_3(3), OPTION_4(4);

    private int index;

    OptionEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

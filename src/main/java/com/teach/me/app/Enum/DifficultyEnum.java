package com.teach.me.app.Enum;

public enum DifficultyEnum {
    EASY(0), MEDIUM(1), HARD(2);

    private int index;

    DifficultyEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

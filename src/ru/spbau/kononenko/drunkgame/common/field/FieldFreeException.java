package ru.spbau.kononenko.drunkgame.common.field;

public class FieldFreeException extends RuntimeException {
    public FieldFreeException(String str) {
        super("Can't remove object from an empty cell: " + str);
    }
}

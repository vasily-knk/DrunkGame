package ru.spbau.kononenko.drunkgame.common.field;

public class FieldOutOfRangeException extends RuntimeException {
	public FieldOutOfRangeException(String str) {
		super("Out of range: " + str);
	}
}

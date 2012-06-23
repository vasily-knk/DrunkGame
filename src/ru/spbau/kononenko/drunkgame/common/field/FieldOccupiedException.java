package ru.spbau.kononenko.drunkgame.common.field;

public class FieldOccupiedException extends RuntimeException {
	public FieldOccupiedException(String str) {
		super("Can't set object. Cell is occupied : " + str);
	}
}

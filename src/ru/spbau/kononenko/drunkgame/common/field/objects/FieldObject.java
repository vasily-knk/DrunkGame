package ru.spbau.kononenko.drunkgame.common.field.objects;

import ru.spbau.kononenko.drunkgame.common.field.Coord;

public interface FieldObject {
    public boolean getProperty(FieldObjectProperty property);
    public char getChar();
    void onRemove(Coord coord);
    void onPlace(Coord coord);
}

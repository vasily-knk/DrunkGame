package ru.spbau.kononenko.drunkgame.common.field.objects;

import ru.spbau.kononenko.drunkgame.common.field.Coord;

public abstract class StaticFieldObject implements FieldObject{

    @Override
    public void onRemove(Coord coord) {
    }

    @Override
    public void onPlace(Coord coord) {
    }
}

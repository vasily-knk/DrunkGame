package ru.spbau.kononenko.drunkgame.common.actors;

import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;

public interface SelfAware {
    Coord getCoord();
    Field getField();
}

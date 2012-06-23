package ru.spbau.kononenko.drunkgame.common.algorithms.pathfinders;

import ru.spbau.kononenko.drunkgame.common.algorithms.filters.FilterInterface;
import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.common.field.objects.FieldObject;

public interface PathFinder {
    Coord getNext(Field field, Coord src,
                  FilterInterface<Coord> dstFilter,
                  FilterInterface<FieldObject> ignore);
}

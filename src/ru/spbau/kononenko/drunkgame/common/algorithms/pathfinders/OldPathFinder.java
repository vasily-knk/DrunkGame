package ru.spbau.kononenko.drunkgame.common.algorithms.pathfinders;

import ru.spbau.kononenko.drunkgame.common.algorithms.filters.FilterInterface;
import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.common.field.objects.FieldObject;

import java.util.List;

public interface OldPathFinder {
    List<Coord> getPath(final Field field, final Coord src, final Coord dst, final FilterInterface<FieldObject> ignore);
}

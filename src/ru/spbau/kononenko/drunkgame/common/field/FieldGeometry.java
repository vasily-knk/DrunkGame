package ru.spbau.kononenko.drunkgame.common.field;

import java.util.List;

public interface FieldGeometry {
    public List<Coord> getAdjacent(Coord coord);
    public boolean isInside(Coord coord);
}

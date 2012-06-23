package ru.spbau.kononenko.drunkgame.common.field;

import ru.spbau.kononenko.drunkgame.common.field.objects.FieldObject;

public abstract class Field implements FieldGeometry {
    public abstract FieldObject getObject(Coord coord);

    protected void objectSettingCore(Coord coord, FieldObject object) {
        if (getObject(coord) != null)
            throw new FieldOccupiedException(coord.toString());
        object.onPlace(coord);
    }

    protected void objectRemovingCore(Coord coord) {
        FieldObject object = getObject(coord);
        if (object == null)
            throw new FieldFreeException(coord.toString());
        object.onRemove(coord);
    }

    public void moveObject(Coord src, Coord dst) {
        if (src.equals(dst))
            return;

        FieldObject o = getObject(src);
        setObject(dst, o);
        removeObject(src);
    }

    public abstract void draw();
    public abstract void setObject(Coord coord, FieldObject object);
    public abstract void removeObject(Coord coord);
}

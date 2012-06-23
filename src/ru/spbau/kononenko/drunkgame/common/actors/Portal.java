package ru.spbau.kononenko.drunkgame.common.actors;

import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.game.DynamicManager;

public abstract class Portal implements DynamicObject {
    protected final Field field;
    protected final Coord coord;
    protected final DynamicManager dynamicControl;

    public Portal(Field field, Coord coord, DynamicManager dynamicControl) {
        this.field = field;
        this.coord = coord;      
        this.dynamicControl = dynamicControl; 
    }

    public boolean canSpawn() {
        return field.getObject(coord) == null;
    }

    public void spawn (Actor object) {
        dynamicControl.addObject(object);
    }

    public boolean isDead() {
        return false;
    }
}

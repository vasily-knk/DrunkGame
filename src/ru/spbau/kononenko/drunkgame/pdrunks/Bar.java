package ru.spbau.kononenko.drunkgame.pdrunks;

import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.game.DynamicManager;
import ru.spbau.kononenko.drunkgame.common.actors.Portal;

public class Bar extends Portal {
    private final int spawnFrequency;
    private int timeElapsed = 0;
    
    public Bar(Field field, Coord coord, DynamicManager dynamicControl, int spawnFrequency) {
        super(field, coord, dynamicControl);
        this.spawnFrequency = spawnFrequency;
    }

    @Override
    public void update() {
        if (timeElapsed >= spawnFrequency) {
            if (canSpawn())
                spawn(new Drunk(field, coord));
            timeElapsed = 0;
        }
        ++timeElapsed;
    }

    @Override
    public boolean isActive() {
        return true;
    }
}

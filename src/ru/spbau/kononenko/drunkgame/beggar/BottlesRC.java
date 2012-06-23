package ru.spbau.kononenko.drunkgame.beggar;

import ru.spbau.kononenko.drunkgame.common.actors.Portal;
import ru.spbau.kononenko.drunkgame.common.actors.ReturnReportInterface;
import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.game.DynamicManager;

public class BottlesRC extends Portal {
    private int respawnTime;
    boolean beggarIsOut = false;
    int timeElapsed = 0;

    public BottlesRC(Field field, Coord coord, DynamicManager dynamicControl, int respawnTime) {
        super(field, coord, dynamicControl);
        this.respawnTime = respawnTime;
    }

    @Override
    public void update() {
        if (timeElapsed == respawnTime) {
            if (canSpawn()) {
                spawnBeggar();
                timeElapsed = 0;
            } else
                timeElapsed = respawnTime - 1;
        }
        ++timeElapsed;
    }

    private void spawnBeggar() {
        ReturnReportInterface onReturn = new ReturnReportInterface() {
            @Override
            public void report() {
                beggarIsOut = false;
            }
        };
        spawn(new Beggar(field, coord, onReturn));
        beggarIsOut = true;
    }

    @Override
    public boolean isActive() {
        return !beggarIsOut;
    }
}

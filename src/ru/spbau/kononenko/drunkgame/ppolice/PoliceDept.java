package ru.spbau.kononenko.drunkgame.ppolice;

import ru.spbau.kononenko.drunkgame.common.actors.ReturnReportInterface;
import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.game.DynamicManager;
import ru.spbau.kononenko.drunkgame.common.actors.Portal;
import ru.spbau.kononenko.drunkgame.ppolice.arrestable.Arrestable;
import ru.spbau.kononenko.drunkgame.ppolice.policeman.Policeman;
import ru.spbau.kononenko.drunkgame.ppolice.reporters.ArrestableReporter;

import java.util.LinkedList;
import java.util.List;

public class PoliceDept extends Portal {
    List<ArrestableReporter> reporters = new LinkedList<ArrestableReporter>();
    boolean policemanIsOut = false;

    public PoliceDept(Field field, Coord coord, DynamicManager dynamicControl) {
        super(field, coord, dynamicControl);
    }

    public void addSearcher(ArrestableReporter reporter) {
        reporters.add(reporter);
    }

    @Override
    public void update() {
        for (ArrestableReporter reporter : reporters) {
            Arrestable res = reporter.search();
            if (res != null) {
                tryToSendPoliceman(res);
                break;
            }
        }
    }

    private void tryToSendPoliceman(Arrestable target) {
        if (canSpawn()) {
            ReturnReportInterface onReturn = new ReturnReportInterface() {
                @Override
                public void report() {
                    policemanIsOut = false;
                }
            };
            spawn(new Policeman(field, coord, onReturn, target));
            policemanIsOut = true;
        }
    }

    @Override
    public boolean isActive() {
        return !policemanIsOut;
    }

}

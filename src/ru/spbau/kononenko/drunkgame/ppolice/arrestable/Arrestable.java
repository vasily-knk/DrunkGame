package ru.spbau.kononenko.drunkgame.ppolice.arrestable;

import ru.spbau.kononenko.drunkgame.common.actors.SelfAware;
import ru.spbau.kononenko.drunkgame.common.field.objects.FieldObject;
import ru.spbau.kononenko.drunkgame.ppolice.policeman.Policeman;

public interface Arrestable extends FieldObject, SelfAware {
    void arrest(Policeman policeman);
}

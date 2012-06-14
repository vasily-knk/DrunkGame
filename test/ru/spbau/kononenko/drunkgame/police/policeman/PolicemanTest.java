package ru.spbau.kononenko.drunkgame.police.policeman;


import org.junit.Before;
import org.junit.Test;
import ru.spbau.kononenko.drunkgame.common.actors.ReturnReportInterface;
import ru.spbau.kononenko.drunkgame.common.field.field_itself.Coord;
import ru.spbau.kononenko.drunkgame.common.field.field_itself.Field;
import ru.spbau.kononenko.drunkgame.drunks.Drunk;
import ru.spbau.kononenko.drunkgame.rect_field.RectField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class PolicemanTest {
    private Field field;

    final Coord startCoord = new Coord(5, 5);
    final Coord adjCoord = new Coord(5, 6);
    final ReturnReportInterface onReturn = new ReturnReportInterface() {
        @Override
        public void report() {

        }
    };

    @Before
    public void setUp() throws Exception {
        field = spy(new RectField(10, 10));

        List<Coord> mockAdj = new ArrayList<Coord>();
        mockAdj.add(adjCoord);

        when(field.getAdjacent(startCoord)).thenReturn(mockAdj);
    }
    
    @Test
    public void arrestAndReturn() {
        Drunk mockDrunk = spy(new Drunk(field, adjCoord));
        mockDrunk.fallAsleep();
        Policeman policeman = new Policeman(field, startCoord, onReturn, mockDrunk);
        policeman.update();
        verify(mockDrunk).arrest(policeman);
    }
    
}

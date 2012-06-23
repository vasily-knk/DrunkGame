package ru.spbau.kononenko.drunkgame.ppolice.policeman;


import org.junit.Before;
import org.junit.Test;
import ru.spbau.kononenko.drunkgame.common.actors.ReturnReportInterface;
import ru.spbau.kononenko.drunkgame.common.field.Coord;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.pdrunks.Drunk;
import ru.spbau.kononenko.drunkgame.pdrunks.Pillar;
import ru.spbau.kononenko.drunkgame.rect_field.RectField;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class PolicemanTest {
    private Field field;

    final Coord startCoord = new Coord(5, 5);
    final Coord adjCoord = new Coord(5, 6);
    final Coord adjCoord2 = new Coord(6, 6);
    final ReturnReportInterface onReturn = new ReturnReportInterface() {
        @Override
        public void report() {

        }
    };

    @Before
    public void setUp() throws Exception {
        field = spy(new RectField(10, 10));

        when(field.getAdjacent(startCoord)).thenReturn(Arrays.asList(adjCoord));
        when(field.getAdjacent(adjCoord)).thenReturn(Arrays.asList(startCoord, adjCoord2));
        when(field.getAdjacent(adjCoord2)).thenReturn(Arrays.asList(adjCoord));
    }
    
    @Test
    public void arrestAndReturn() {
        Drunk drunk = new Drunk(field, adjCoord);
        drunk.fallAsleep();
        Policeman policeman = new Policeman(field, startCoord, onReturn, drunk);

        // Drunk arrested
        policeman.update();
        assertNull(field.getObject(adjCoord));

        // Policeman returned
        policeman.update();
        assertNull(field.getObject(startCoord));
    }
    
    @Test
    public void blocked() {
        Drunk drunk = new Drunk(field, adjCoord2);
        drunk.fallAsleep();
        Policeman policeman = new Policeman(field, startCoord, onReturn, drunk);

        //block policeman
        field.setObject(adjCoord, new Pillar());
        policeman.update();

        assertEquals(field.getObject(startCoord), policeman);
    }

    @Test
    public void hasPath() {
        Drunk drunk = new Drunk(field, adjCoord2);
        drunk.fallAsleep();
        Policeman policeman = new Policeman(field, startCoord, onReturn, drunk);

        policeman.update();

        assertEquals(field.getObject(adjCoord), policeman);
        assertNull(field.getObject(startCoord));
    }

}

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
import static org.junit.Assert.assertNull;
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
    public void hasPath() {
        Coord startCoord1 = new Coord(0, 0);
        Field field1 = new RectField(10, 10);
        Drunk drunk = new Drunk(field, new Coord(9, 9));
        Policeman policeman = new Policeman(field, startCoord1, onReturn, drunk);
        policeman.update();
        assertNull(field.getObject(startCoord1));
        
    }
    
}

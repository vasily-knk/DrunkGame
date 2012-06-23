package ru.spbau.kononenko.drunkgame.common.actors;

import org.junit.Before;
import ru.spbau.kononenko.drunkgame.common.field.Field;
import ru.spbau.kononenko.drunkgame.game.DynamicManager;
import ru.spbau.kononenko.drunkgame.rect_field.RectField;

import static org.mockito.Mockito.mock;

public class PortalTest {
    Field field = new RectField(1, 1);
    Portal portal;
    DynamicManager game;
    
    @Before
    public void setUp() throws Exception {
        //game = mock(DynamicControl.class);
        //portal = spy(new)
    }
}

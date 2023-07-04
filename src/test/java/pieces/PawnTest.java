package pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    @Test
    void testCreate() {
        assertCreatePawn(Pawn.WHITE);
        assertCreatePawn(Pawn.BLACK);
    }

    void assertCreatePawn(String color) {
        Pawn whitePawn = new Pawn(color);
        assertEquals(color, whitePawn.getColor());
    }
    @Test
    void testCreateWithDefault() {
        final String white = "white";
        Pawn pawn = new Pawn();
        assertEquals(white, pawn.getColor());
    }
}
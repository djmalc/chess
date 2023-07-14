

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ chess.BoardTest.class, 
	chess.GameTest.class,
	pieces.PieceTest.class,
	pieces.KingTest.class,
	pieces.QueenTest.class,
	languagetests.CharacterTest.class,
	util.RangeTest.class})
public class AllTests {

}

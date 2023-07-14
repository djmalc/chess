package languagetests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class CharacterTest {
	@Test
	public void testWhiteSpace() {
		assertTrue(Character.isWhitespace('\n'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
		assertTrue(Character.isWhitespace('\f'));
		assertTrue(Character.isWhitespace('\r'));
		assertFalse(Character.isWhitespace('A'));
		assertFalse(Character.isWhitespace('I'));
	}
	
	public void testIdentifierCharacters() {
		assertTrue(Character.isJavaIdentifierStart('a'));
		assertFalse(Character.isJavaIdentifierStart('^'));
		assertFalse(Character.isJavaIdentifierStart('1'));
		assertTrue(Character.isJavaIdentifierPart('a'));
		assertFalse(Character.isJavaIdentifierPart('^'));
		assertTrue(Character.isJavaIdentifierPart('1'));
	}
}

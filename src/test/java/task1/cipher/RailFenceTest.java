package task1.cipher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RailFenceTest {

	private RailFence railFence;
	
	@BeforeEach
	void setUp() {
		railFence = new RailFence();
	}
	
	@Test
	void givenString_whenEncede_thenEncode() {
		String expected = "WECRLTEERDSOEEFEAOCAIVDEN";
		
		String actual = railFence.encode("WEAREDISCOVEREDFLEEATONCE", 3);
		
		assertEquals(expected, actual);
	}

	@Test
	void givenString_whenDecode_thenDecode() {
		String expected = "WEAREDISCOVEREDFLEEATONCE";
		
		String actual = railFence.decode("WECRLTEERDSOEEFEAOCAIVDEN", 3);
		
		assertEquals(expected, actual);
	}
}

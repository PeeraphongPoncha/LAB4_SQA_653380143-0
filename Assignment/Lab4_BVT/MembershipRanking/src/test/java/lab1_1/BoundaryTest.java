package lab1_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.Ranking;

import static org.junit.jupiter.api.Assertions.*;

public class BoundaryTest {
	
	Ranking ranking;
	
	@BeforeEach
	void setUp() {
		ranking = new Ranking();
	}
	@DisplayName("Rank Tests")
	@ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
	@CsvSource({
	    "01,0,15,500,Standard",
	    "02,1,15,500,Standard",
	    "03,50000,15,500,Gold",
	    "04,99999,15,500,Gold",
	    "05,100000,15,500,Gold",
	    "06,50000,0,500,Standard",
	    "07,50000,1,500,Silver",
	    "08,50000,30,500,Gold",
	    "09,50000,31,500,Gold",
	    "10,50000,15,0,Standard",
	    "11,50000,15,1,Standard",
	    "12,50000,15,999,Gold",
	    "13,50000,15,1000,Gold"
	})

	void testMembership(String tcNum, int purchaseTotal, int frequency, int pointCollected, String expected) {
		String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expected,actual);
				
	}
	

}
	
	
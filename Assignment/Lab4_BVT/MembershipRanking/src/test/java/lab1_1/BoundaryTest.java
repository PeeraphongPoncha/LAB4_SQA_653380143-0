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
	@DisplayName("Silver Rank Tests")
	@ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
	@CsvSource({
		// Silver
        "01,10000, 1, 300, Silver",
        "02,10001, 1, 300, Silver",
        "03,30000, 1, 300, Silver",
        "04,49999, 1, 300, Silver",
        "05,50000, 1, 300, Silver",
        "06,30000, 2, 300, Silver",
        "07,30000, 1, 100, Silver",
        "08,30000, 1, 101, Silver",
        "09,30000, 1, 499, Silver",
        "10,30000, 1, 500, Silver",
	})
	
	void testSilverMembership(String tcNum, int purchaseTotal, int frequency, int pointCollected, String expected) {
		String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expected,actual);
				
	}
	
	@DisplayName("Gold Rank Tests")
	@ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
	@CsvSource({
        // Gold
        "11,50000, 4, 750, Gold",
        "12,50001, 4, 750, Gold",
        "13,75000, 4, 750, Gold",
        "14,99999, 4, 750, Gold",
        "15,100000, 4, 750, Gold",
        "16,75000, 3, 750, Gold",
        "17,75000, 5, 750, Gold",
        "18,75000, 4, 500, Gold",
        "19,75000, 4, 501, Gold",
        "20,75000, 4, 999, Gold",
        "21,75000, 4, 1000, Gold",
	})
	
	void testGoldMembership(String tcNum , int purchaseTotal, int frequency, int pointCollected, String expected) {
		String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expected,actual);
				
	}
	
	@DisplayName("Platinum Rank Tests")
	@ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
	@CsvSource({
        // Platinum
        "22,100001, 8, 5000, Platinum",
        "23,100002, 8, 5000, Platinum",
        "24,500000, 8, 5000, Platinum",
        "25,999999, 8, 5000, Platinum",
        "26,1000000, 8, 5000, Platinum",
        "27,500000, 6, 5000, Platinum",
        "28,500000, 7, 5000, Platinum",
        "29,500000, 9, 5000, Platinum",
        "30,500000, 10, 5000, Platinum",
        "31,500000, 8, 1000, Platinum",
        "32,500000, 8, 1001, Platinum",
        "33,500000, 8, 9999, Platinum",
        "34,500000, 8, 10000, Platinum"
	})
	
	void testPlatinumMembership(String tcNum, int purchaseTotal, int frequency, int pointCollected, String expected) {
		String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expected,actual);
				
	}

}
	
	
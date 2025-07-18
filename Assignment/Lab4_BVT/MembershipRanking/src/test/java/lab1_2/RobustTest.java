package lab1_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.Ranking;

import static org.junit.jupiter.api.Assertions.*;

public class RobustTest {

    Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    @DisplayName("Silver Rank Tests")
    @ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
    @CsvSource({
        "02,10000, 1, 300, Silver",
        "03,10001, 1, 300, Silver",
        "04,30000, 1, 300, Silver",
        "05,49999, 1, 300, Silver",
        "06,50000, 1, 300, Silver",
        "09,30000, 2, 300, Silver",
        "12,30000, 1, 100, Silver",
        "13,30000, 1, 101, Silver",
        "14,30000, 1, 499, Silver",
        "15,30000, 1, 500, Silver",
    })
    void testSilverMembership(String tcNum, int purchaseTotal, int frequency, int pointCollected, String expected) {
        String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expected, actual);
    }

    @DisplayName("Gold Rank Tests")
    @ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
    @CsvSource({
        "18,50000, 4, 750, Gold",
        "19,50001, 4, 750, Gold",
        "20,75000, 4, 750, Gold",
        "21,99999, 4, 750, Gold",
        "22,100000, 4, 750, Gold",
        "25,75000, 3, 750, Gold",
        "26,75000, 5, 750, Gold",
        "29,75000, 4, 500, Gold",
        "30,75000, 4, 501, Gold",
        "31,75000, 4, 999, Gold",
        "32,75000, 4, 1000, Gold",
    })
    void testGoldMembership(String tcNum , int purchaseTotal, int frequency, int pointCollected, String expected) {
        String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expected, actual);
    }

    @DisplayName("Platinum Rank Tests")
    @ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
    @CsvSource({
        "35,100001, 8, 5000, Platinum",
        "36,100002, 8, 5000, Platinum",
        "37,500000, 8, 5000, Platinum",
        "38,999999, 8, 5000, Platinum",
        "39,1000000, 8, 5000, Platinum",
        "42,500000, 6, 5000, Platinum",
        "43,500000, 7, 5000, Platinum",
        "44,500000, 9, 5000, Platinum",
        "45,500000, 10, 5000, Platinum",
        "48,500000, 8, 1000, Platinum",
        "49,500000, 8, 1001, Platinum",
        "50,500000, 8, 9999, Platinum",
        "51,500000, 8, 10000, Platinum"
    })
    void testPlatinumMembership(String tcNum, int purchaseTotal, int frequency, int pointCollected, String expected) {
        String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expected, actual);
    }

    @DisplayName("Invalid Rank Tests")
    @ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
    @CsvSource({
        "01,9999, 1, 300, Standard",
        "07,50001, 1, 300, Standard",
        "08,30000, 0, 300, Standard",
        "10,30000, 3, 300, Standard",
        "11,30000, 1, 99, Standard",
        "16,30000, 1, 501, Standard",
        "17,49999, 4, 750, Standard",
        "23,100001, 4, 750, Standard",
        "24,75000, 2, 750, Standard",
        "27,75000, 6, 750, Standard",
        "28,75000, 4, 499, Standard",
        "33,75000, 4, 1001, Standard",
        "34,100000, 8, 5000, Standard",
        "40,1000001, 8, 5000, Standard",
        "41,500000, 5, 5000, Standard",
        "46,500000, 11, 5000, Standard",
        "47,500000, 8, 999, Standard",
        "52,500000, 8, 10001, Standard"
    })
    void testInvalidMembership(String tcNum, int purchaseTotal, int frequency, int pointCollected, String expected) {
        String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expected, actual);
    }
}

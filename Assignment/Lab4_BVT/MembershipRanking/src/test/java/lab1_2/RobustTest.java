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

    @DisplayName("Robustness Rank Tests")
    @ParameterizedTest(name = "TC{0} => purchaseTotal={1}, frequency={2}, pointCollected={3}, expected={4}")
    @CsvSource({
        "01,-1,15,500,Standard",
        "02,0,15,500,Standard",
        "03,1,15,500,Standard",
        "04,50000,15,500,Gold",
        "05,99999,15,500,Gold",
        "06,100000,15,500,Gold",
        "07,100001,15,500,Gold",
        "08,50000,-1,500,Standard",
        "09,50000,0,500,Standard",
        "10,50000,1,500,Standard",
        "11,50000,30,500,Gold",
        "12,50000,31,500,Gold",
        "13,50000,32,500,Gold",
        "14,50000,15,-1,Standard",
        "15,50000,15,0,Standard",
        "16,50000,15,1,Standard",
        "17,50000,15,999,Gold",
        "18,50000,15,1000,Gold",
        "19,50000,15,1001,Gold"
    })

    void testRobustMembership(String tcNum, int purchaseTotal, int frequency, int pointCollected, String expected) {
        String actual = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expected, actual);
    }

}

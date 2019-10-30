package ohtuesimerkki;


import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void constructorCreatesListWithPlayers() {
        assertEquals(4, readerStub.getPlayers().get(0).getGoals());
    }

    @Test
    public void playerSearchReturnsCorrectPlayer() {
        String name = readerStub.getPlayers().get(2).getName();
        assertEquals(name, stats.search("Kurri").getName());
    }

    @Test
    public void playerSearchReturnsNullWhenNoPlayerIsFound() {
        assertNull(stats.search("Selänne"));
    }

    @Test
    public void returnPlayersOfTeam() {
        ArrayList<Player> expected = new ArrayList<>();
        expected.add(new Player("Semenko", "EDM", 4, 12));
        expected.add(new Player("Kurri", "EDM", 37, 53));
        expected.add(new Player("Gretzky", "EDM", 35, 89));
        assertEquals(expected.get(0).getName(), stats.team("EDM").get(0).getName());
        assertEquals(expected.get(1).getName(), stats.team("EDM").get(1).getName());
        assertEquals(expected.get(2).getName(), stats.team("EDM").get(2).getName());
    }
@Test
    public void topScorersReturnsCorrectly() {

        assertEquals(45,stats.topScorers(4).get(1).getGoals());
    }
    


}

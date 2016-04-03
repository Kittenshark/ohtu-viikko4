
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void haettuNimiLöytyy(){
        Player player = stats.search("Semenko");
        
        assertEquals(player.getName(), "Semenko");
    }
    
    @Test
    public void haettuTuntematonNimiEiLöydy(){
        Player player = stats.search("Muumipeikko");
        
        assertNull(player);
    }
    
    @Test
    public void teamListsRightMembers() {
        List<Player> list = stats.team("EDM");
        
        List<Player> list2 = new ArrayList<Player>();
        list2.add(stats.search(("Semenko")));
        list2.add(stats.search("Kurri"));
        list2.add(stats.search("Gretzky"));
        
        assertEquals(list, list2);
    }
    
    @Test
    public void parhaatPelaajatListaaOikein() {
        List<Player> list = stats.topScorers(2);
        ArrayList<Player> list2 = new ArrayList<Player>();
        list2.add(stats.search("Gretzky"));
        list2.add(stats.search("Lemieux"));
        list2.add(stats.search("Yzerman"));

        
        assertEquals(list, list2);
        
    }
}

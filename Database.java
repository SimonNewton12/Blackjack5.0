package osborn.andrew.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Database
{
    private static List<Player> players;

    public Database()
    {
        players = new ArrayList<>();
    }

    /**
     * addPlayer(Player player) adds new player to the List<Player> players
     *
     * @param player Player object to be added to List<Player> players
     */
    public static void addPlayer(Player player)
    {
        players.add(player);
    }
}

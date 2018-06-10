package CGSolutions.PlayersWebService.API.Player.PlayerComparators;

import CGSolutions.PlayersWebService.API.Player.Player;

import java.util.Comparator;

/**
 * A comparator for players objects which compare them by
 * their ID
 */
public class IdComparator implements Comparator<Player> {

    /**
     * Compare the players by their ID
     * @param o1 player1
     * @param o2 player2
     * @return an int which represents their order
     */
    @Override
    public int compare(Player o1, Player o2) {
         return (int) (o1.getId()-o2.getId());
    }
}

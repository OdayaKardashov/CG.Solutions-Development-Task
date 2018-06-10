package CGSolutions.PlayersWebService.API.Player.PlayerComparators;

import CGSolutions.PlayersWebService.API.Player.Player;

import java.util.Comparator;

/**
 * A comparator for players objects which compare them by
 * their Name
 */
public class NameComparator implements Comparator<Player> {

    /**
     * Compare the players by their name
     * @param o1 player1
     * @param o2 player2
     * @return an int which represents their order
     */
    @Override
    public int compare(Player o1, Player o2) {
        int compareValue=o1.getName().compareToIgnoreCase(o2.getName());

        if(compareValue!=0){
            return compareValue;
        }

        // names are equal - compare by ID
        return (int) (o1.getId()-o2.getId());
    }
}

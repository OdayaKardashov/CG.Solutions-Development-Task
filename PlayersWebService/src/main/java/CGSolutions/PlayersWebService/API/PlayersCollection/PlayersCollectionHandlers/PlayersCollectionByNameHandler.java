package CGSolutions.PlayersWebService.API.PlayersCollection.PlayersCollectionHandlers;

import CGSolutions.PlayersWebService.API.Player.Player;
import CGSolutions.PlayersWebService.API.Player.PlayerComparators.NameComparator;

import java.util.Collection;
import java.util.TreeSet;

import static CGSolutions.PlayersWebService.API.ConstantParameters.NAME_SORTING_PARAM_STRING;


/**
 * A concrete implementation of a PlayersCollection handler
 * which saves the players in a sorted collection by their name
 */
public class PlayersCollectionByNameHandler extends PlayersCollectionHandler {
    protected TreeSet<Player> playerByNameTreeSet;


    /**
     * Constructor
     */
    public PlayersCollectionByNameHandler() {
        super();

        // create a new TreeSet which will keep the players
        // sorted by their name
        playerByNameTreeSet=new TreeSet<>(new NameComparator());
    }


    /**
     * Insert the given player into the players collection
     * All handlers should add this player to their collection
     * @param player the new player to insert
     */
    @Override
    public void addPlayerHandler(Player player) {
        // add new player to current TreeSet
        playerByNameTreeSet.add(player);

        if(successor!=null){
            // there are more handlers - trigger them to add this player as well
            successor.addPlayerHandler(player);
        }

    }

    /**
     * Get a collection of all the players sorted by the given sorting parameter.
     * Only one handler should response to this request - the one which contains
     * a collection which is sorted by the given sortingParameter
     * @param sortingParameter the sorting parameter
     * @return a collection of all the players sorted by the given sorting parameter
     */
    @Override
    public Collection<Player> getSortedPlayersHandler(String sortingParameter) {
        if(sortingParameter.equals(NAME_SORTING_PARAM_STRING)){
            // the sorting param is by name - return current TreeSet
            return playerByNameTreeSet;
        }else if(successor!=null){
            // sorting param not by name - pass the request to the next handler
            return successor.getSortedPlayersHandler(sortingParameter);
        }else{
            // no more handlers - return current TreeSet
            return playerByNameTreeSet;
        }
    }
}

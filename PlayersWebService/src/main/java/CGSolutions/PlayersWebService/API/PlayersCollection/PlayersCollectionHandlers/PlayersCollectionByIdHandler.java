package CGSolutions.PlayersWebService.API.PlayersCollection.PlayersCollectionHandlers;

import CGSolutions.PlayersWebService.API.Player.Player;
import CGSolutions.PlayersWebService.API.Player.PlayerComparators.IdComparator;

import java.util.*;

import static CGSolutions.PlayersWebService.API.ConstantParameters.ID_SORTING_PARAM_STRING;


/**
 * A concrete implementation of a PlayersCollection handler
 * which saves the players in a sorted collection by their ID
 */
public class PlayersCollectionByIdHandler extends PlayersCollectionHandler {
    protected TreeSet<Player> playerByIdTreeSet;

    /**
     * Constructor
     */
    public PlayersCollectionByIdHandler() {
        super();

        // create a new TreeSet which will keep the players
        // sorted by their ID
        playerByIdTreeSet=new TreeSet<>(new IdComparator());
    }


    /**
     * Insert the given player into the players collection
     * All handlers should add this player to their collection
     * @param player the new player to insert
     */
    @Override
    public void addPlayerHandler(Player player) {
        // add new player to current TreeSet
        playerByIdTreeSet.add(player);

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
        if(sortingParameter.equals(ID_SORTING_PARAM_STRING)){
            // the sorting param is by id - return current TreeSet
            return playerByIdTreeSet;
        }else if(successor!=null){
            // sorting param not by id - pass the request to the next handler
            return successor.getSortedPlayersHandler(sortingParameter);
        }else{
            // no more handlers - return current TreeSet
            return playerByIdTreeSet;
        }
    }
}

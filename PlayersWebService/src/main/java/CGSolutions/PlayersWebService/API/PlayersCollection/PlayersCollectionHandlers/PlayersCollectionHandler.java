package CGSolutions.PlayersWebService.API.PlayersCollection.PlayersCollectionHandlers;

import CGSolutions.PlayersWebService.API.Player.Player;

import java.util.Collection;


/**
 * An abstract base class for all the concrete implementations
 * of PlayersCollection handlers in the chain-of-responsibility
 * design pattern.
 */
public abstract class PlayersCollectionHandler {

    protected PlayersCollectionHandler successor;

    public PlayersCollectionHandler() {
        this.successor = null;
    }

    /**
     * Set the next handler in the chain of handlers
     * @param successor
     */
    public void setSuccessor(PlayersCollectionHandler successor){
        this.successor = successor;
    }

    /**
     * Insert the given player into the players collection
     * All handlers should add this player to their collection
     * @param player the new player to insert
     */
    public abstract void addPlayerHandler(Player player);

    /**
     * Get a collection of all the players sorted by the given sorting parameter.
     * Only one handler should response to this request - the one which contains
     * a collection which is sorted by the given sortingParameter
     * @param sortingParameter the sorting parameter
     * @return a collection of all the players sorted by the given sorting parameter
     */
    public abstract Collection<Player> getSortedPlayersHandler(String sortingParameter);

}

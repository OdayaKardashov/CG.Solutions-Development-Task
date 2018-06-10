package CGSolutions.PlayersWebService.API.PlayersCollection;

import CGSolutions.PlayersWebService.API.Player.Player;
import CGSolutions.PlayersWebService.API.PlayersCollection.PlayersCollectionHandlers.PlayersCollectionByIdHandler;
import CGSolutions.PlayersWebService.API.PlayersCollection.PlayersCollectionHandlers.PlayersCollectionByNameHandler;
import CGSolutions.PlayersWebService.API.PlayersCollection.PlayersCollectionHandlers.PlayersCollectionHandler;

import java.util.Collection;


/**
 * A singelton class which maintains and store all of the players
 * (through the different PlayersCollectionHandlers classes - chain-of-responsibilities
 *  design pattern)
 */
public class PlayersCollection implements IPlayersCollection {
    private static PlayersCollection ourInstance = new PlayersCollection();
    private PlayersCollectionHandler playersCollectionHandler;

    /**
     * Get the singelton instance
     * @return the singelton instance
     */
    public static PlayersCollection getInstance() {
        return ourInstance;
    }

    /**
     * Constructor - build the chain of players collections handlers
     */
    private PlayersCollection() {

        // build the handlers (which store the actual data)
        PlayersCollectionHandler playerCollectionIdHandler = new PlayersCollectionByIdHandler();
        PlayersCollectionHandler playerCollectionNameHandler = new PlayersCollectionByNameHandler();

        // connect them by a chain
        playerCollectionIdHandler.setSuccessor(playerCollectionNameHandler);
        this.playersCollectionHandler=playerCollectionIdHandler;
    }

    /**
     * Insert the given player into the players collection
     * @param player the new player to insert
     */
    @Override
    public void addPlayer(Player player) {
        this.playersCollectionHandler.addPlayerHandler(player);
    }


    /**
     * Get a collection of all the players sorted by the given sorting parameter.
     * @param sortingParameter the sorting parameter
     * @return a collection of all the players sorted by the given sorting parameter
     */
    @Override
    public Collection<Player> getSortedPlayers(String sortingParameter) {
        return this.playersCollectionHandler.getSortedPlayersHandler(sortingParameter);
    }



}

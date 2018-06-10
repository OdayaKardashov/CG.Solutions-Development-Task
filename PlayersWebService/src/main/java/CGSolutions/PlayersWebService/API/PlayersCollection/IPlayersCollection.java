package CGSolutions.PlayersWebService.API.PlayersCollection;

import CGSolutions.PlayersWebService.API.Player.Player;

import java.util.Collection;

/**
 * An interface that exposes a simple API for managing the players (add & get)
 */
public interface IPlayersCollection {

    /**
     * Insert the given player into the players collection
     * @param player the new player to insert
     */
    void addPlayer(Player player);

    /**
     * Get a collection of all the players sorted by the given sorting parameter.
     * @param sortingParameter the sorting parameter
     * @return a collection of all the players sorted by the given sorting parameter
     */
    Collection<Player> getSortedPlayers(String sortingParameter);

}

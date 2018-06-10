package CGSolutions.PlayersWebService.Resources;


import CGSolutions.PlayersWebService.API.PlayersCollection.IPlayersCollection;
import CGSolutions.PlayersWebService.API.Player.Player;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.NonEmptyStringParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A resource (an endpoint with a URI) in our web service
 * which allows to create new players and store them in the memory
 */
@Path("/create-player")
@Produces(MediaType.APPLICATION_JSON)
public class CreatePlayerResource {
    private final IPlayersCollection playersCollection;
    private final String defaultName;
    private final AtomicLong playerIDCounter;

    /**
     * Constructor
     * @param playersCollection
     * @param defaultName
     */
    public CreatePlayerResource(IPlayersCollection playersCollection, String defaultName) {
        this.playersCollection=playersCollection;
        this.defaultName = defaultName;
        this.playerIDCounter = new AtomicLong();
    }

    /**
     * Insert the given player into the players collection
     * @param name the name given in the request for the new player
     */
    @GET
    @Timed
    public void addPlayer(@QueryParam("name") NonEmptyStringParam name) {
        // create the new player with the current ID counter.
        // If there is no given name - use the default one.
        Player player = new Player(playerIDCounter.incrementAndGet(),name.get().orElse(defaultName));

        // add this player to the memory (the collection)
        playersCollection.addPlayer(player);
    }
}
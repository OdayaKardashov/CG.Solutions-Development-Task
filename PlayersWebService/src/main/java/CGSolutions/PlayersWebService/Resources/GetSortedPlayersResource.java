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
import java.util.Collection;


/**
 * A resource (an endpoint with a URI) in our web service
 * which allows to get all of the players in the memory sorted
 * by a given parameter
 */
@Path("/get-players")
@Produces(MediaType.APPLICATION_JSON)
public class GetSortedPlayersResource {
    private final IPlayersCollection playersCollection;
    private final String defaultSortingParam;

    /**
     * Constructor
     * @param playersCollection
     * @param defaultSortingParam
     */
    public GetSortedPlayersResource(IPlayersCollection playersCollection, String defaultSortingParam) {
        this.playersCollection=playersCollection;
        this.defaultSortingParam = defaultSortingParam;
    }


    /**
     * Get a collection of all the players sorted by the given sorting parameter.
     * @param sortingParam default sorting parameter
     * @return
     */
    @GET
    @Timed
    public Collection<Player> getPlayers(@QueryParam("sort") NonEmptyStringParam sortingParam) {
        // return a collection of the players sorted by the "sort" param.
        // If no value given - use the default sorting param
        return playersCollection.getSortedPlayers(sortingParam.get().orElse(defaultSortingParam));
    }


}
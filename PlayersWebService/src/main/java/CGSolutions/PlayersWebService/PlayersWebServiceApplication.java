package CGSolutions.PlayersWebService;

import CGSolutions.PlayersWebService.API.PlayersCollection.IPlayersCollection;
import CGSolutions.PlayersWebService.API.PlayersCollection.PlayersCollection;
import CGSolutions.PlayersWebService.Resources.CreatePlayerResource;
import CGSolutions.PlayersWebService.Resources.GetSortedPlayersResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * This class is the starting point of our web application.
 * It initiate all the needed objects and triggers the execution of
 * the web service
 */
public class PlayersWebServiceApplication extends Application<PlayersWebServiceConfiguration> {

    /**
     * The main function. It creates an instance of this class
     * and triggers the run method.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new PlayersWebServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "Players Web Service";
    }

    @Override
    public void initialize(Bootstrap<PlayersWebServiceConfiguration> bootstrap) {
    }

    /**
     * This function registers our resources classes to the environment
     * @param configuration
     * @param environment
     */
    @Override
    public void run(PlayersWebServiceConfiguration configuration,
                    Environment environment) {


        // register the create player resource
        final CreatePlayerResource createPlayerResource = new CreatePlayerResource(PlayersCollection.getInstance(), configuration.getDefaultName());
        environment.jersey().register(createPlayerResource);

        // register the get sorted players resource
        final GetSortedPlayersResource getSortedPlayersResource = new GetSortedPlayersResource(PlayersCollection.getInstance(), configuration.getDefaultSortingParam());
        environment.jersey().register(getSortedPlayersResource);




    }

}
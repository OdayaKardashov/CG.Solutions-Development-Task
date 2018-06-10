package CGSolutions.PlayersWebService;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class contains all the configuration data
 * which are pulled from the YAML file
 */
public class PlayersWebServiceConfiguration extends Configuration {

    @NotEmpty
    private String defaultName;

    @NotEmpty
    private String defaultSortingParam;



    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public String getDefaultSortingParam() {
        return defaultSortingParam;
    }

    @JsonProperty
    public void setDefaultSortingParam(String defaultSortingParam) {
        this.defaultSortingParam = defaultSortingParam;
    }
}
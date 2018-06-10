package CGSolutions.PlayersWebService.API.Player;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A simple POJO class which represents
 * a player
 */
public class Player {
    private long id;
    private String name;

    /**
     * Empty constructor for Jackson deserialization
     */
    public Player() { }

    public Player(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }


}
package ProgrammingWithClasses.AggregationAndComposition.Task3_State;

import java.util.ArrayList;
import java.util.List;

public class State {
    private String name;
    private City capitalCity;
    private List<Region> regions;


    public State(String name, City capitalCity) {
        this.name = name;
        this.capitalCity = capitalCity;
        regions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(City capitalCity) {
        this.capitalCity = capitalCity;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "State: " +
                "name = " + name +
                ", capitalCity = " + capitalCity +
                ", regions = " + regions;
    }
}

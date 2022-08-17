package programming_with_classes.aggregation_and_composition.task3_state;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private City regionCity;
    private State state;
    private List<District> districts;

    public Region(City regionCity, State state) {
        this.regionCity = regionCity;
        this.state = state;
        this.state.getRegions().add(this);
        districts = new ArrayList<>();
    }

    public City getRegionCity() {
        return regionCity;
    }

    public void setRegionCity(City regionCity) {
        this.regionCity = regionCity;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Region: " +
                "regionCity = " + regionCity +
                ", districts = " + districts;
    }
}

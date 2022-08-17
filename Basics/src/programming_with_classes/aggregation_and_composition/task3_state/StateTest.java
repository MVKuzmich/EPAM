package programming_with_classes.aggregation_and_composition.task3_state;

import java.util.stream.Collectors;

public class StateTest {

    public static void main(String[] args) {
        State state = new State("Belarus", new City("Minsk"));
        Region gomelRegion = new Region(new City("Gomel"), state);
        Region brestRegion = new Region(new City("Brest"), state);
        Region grodnoRegion = new Region(new City("Grodno"), state);

        District district1 = new District(new City("Mozyr"), 152.0, gomelRegion);
        District district2 = new District(new City("Zhlobin"), 135.0, gomelRegion);
        District district3 = new District(new City("Rechitsa"), 173.0, gomelRegion);
        District district4 = new District(new City("Kobryn"), 113.0, brestRegion);
        District district5 = new District(new City("Pinsk"), 134.0, brestRegion);
        District district6 = new District(new City("Bereza"), 89.0, brestRegion);
        District district7 = new District(new City("Lida"), 153.0, grodnoRegion);
        District district8 = new District(new City("Slonim"), 101.0, grodnoRegion);
        District district9 = new District(new City("Ostrovets"), 121.0, grodnoRegion);

        System.out.printf("The capital of state: %s\n", state.getCapitalCity());
        System.out.printf("The count of regions: %d\n", state.getRegions().size());
        System.out.printf("The state square: %f sq.km\n", state.getRegions().stream()
                .flatMap(region -> region.getDistricts().stream())
                .mapToDouble(District::getSquare).sum());
        System.out.printf("List of regions' city: %s\n", state.getRegions().stream()
                .map(Region::getRegionCity)
                .map(City::getName)
                .collect(Collectors.joining(", ")));
        System.out.printf("List of districts' city: %s\n", state.getRegions().stream()
                .flatMap(region -> region.getDistricts().stream())
                .map(District::getDistrictCity)
                .map(City::getName)
                .collect(Collectors.joining(", ")));
    }
}

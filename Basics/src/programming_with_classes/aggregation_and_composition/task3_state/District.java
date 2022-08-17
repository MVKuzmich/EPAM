package programming_with_classes.aggregation_and_composition.task3_state;

public class District {
    private City districtCity;
    private double square;
    private Region region;

    public District(City districtCity, double square, Region region) {
        this.districtCity = districtCity;
        this.square = square;
        this.region = region;
        this.region.getDistricts().add(this);
    }

    public City getDistrictCity() {
        return districtCity;
    }

    public void setDistrictCity(City districtCity) {
        this.districtCity = districtCity;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "District: " +
                "districtCity = " + districtCity +
                ", square = " + square;
    }
}

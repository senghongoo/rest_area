package kr.co.sist.user.restarea;

public class ExtraFacilitiesDTO {

    private String facility_code;
    private String facility_name;
    private String facility_img;
    private String facility_phrase;
    private int rest_area_code;

    public ExtraFacilitiesDTO() {
    }

    public ExtraFacilitiesDTO(String facility_code, String facility_name, String facility_img,
            String facility_phrase, int rest_area_code) {
        this.facility_code = facility_code;
        this.facility_name = facility_name;
        this.facility_img = facility_img;
        this.facility_phrase = facility_phrase;
        this.rest_area_code = rest_area_code;
    }

    public String getFacility_code() {
        return facility_code;
    }

    public void setFacility_code(String facility_code) {
        this.facility_code = facility_code;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getFacility_img() {
        return facility_img;
    }

    public void setFacility_img(String facility_img) {
        this.facility_img = facility_img;
    }

    public String getFacility_phrase() {
        return facility_phrase;
    }

    public void setFacility_phrase(String facility_phrase) {
        this.facility_phrase = facility_phrase;
    }

    public int getRest_area_code() {
        return rest_area_code;
    }

    public void setRest_area_code(int rest_area_code) {
        this.rest_area_code = rest_area_code;
    }

}

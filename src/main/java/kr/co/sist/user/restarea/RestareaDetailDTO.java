package kr.co.sist.user.restarea;

import java.util.Date;

public class RestareaDetailDTO {

    private int rest_area_code;
    private String rest_area_name;
    private String title_img;
    private String title_phrase;
    private String address;
    private double latitude;
    private double longtitude;
    private String rest_area_tel;
    private String gas_station_tel;
    private String famous_food;
    private String parking_scale;
    private String line;
    private Date add_date;
    private Date update_date;

    public RestareaDetailDTO() {
    }

    public RestareaDetailDTO(int rest_area_code, String rest_area_name, String title_img, String title_phrase,
            String address, double latitude, double longtitude, String rest_area_tel, String gas_station_tel,
            String famous_food, String parking_scale, String line, Date add_date, Date update_date) {
        this.rest_area_code = rest_area_code;
        this.rest_area_name = rest_area_name;
        this.title_img = title_img;
        this.title_phrase = title_phrase;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.rest_area_tel = rest_area_tel;
        this.gas_station_tel = gas_station_tel;
        this.famous_food = famous_food;
        this.parking_scale = parking_scale;
        this.line = line;
        this.add_date = add_date;
        this.update_date = update_date;
    }

    public int getRest_area_code() {
        return rest_area_code;
    }

    public void setRest_area_code(int rest_area_code) {
        this.rest_area_code = rest_area_code;
    }

    public String getRest_area_name() {
        return rest_area_name;
    }

    public void setRest_area_name(String rest_area_name) {
        this.rest_area_name = rest_area_name;
    }

    public String getTitle_img() {
        return title_img;
    }

    public void setTitle_img(String title_img) {
        this.title_img = title_img;
    }

    public String getTitle_phrase() {
        return title_phrase;
    }

    public void setTitle_phrase(String title_phrase) {
        this.title_phrase = title_phrase;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getRest_area_tel() {
        return rest_area_tel;
    }

    public void setRest_area_tel(String rest_area_tel) {
        this.rest_area_tel = rest_area_tel;
    }

    public String getGas_station_tel() {
        return gas_station_tel;
    }

    public void setGas_station_tel(String gas_station_tel) {
        this.gas_station_tel = gas_station_tel;
    }

    public String getFamous_food() {
        return famous_food;
    }

    public void setFamous_food(String famous_food) {
        this.famous_food = famous_food;
    }

    public String getParking_scale() {
        return parking_scale;
    }

    public void setParking_scale(String parking_scale) {
        this.parking_scale = parking_scale;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

}

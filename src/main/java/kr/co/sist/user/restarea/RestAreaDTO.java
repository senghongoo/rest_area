package kr.co.sist.user.restarea;

public class RestAreaDTO {
	private int restAreaCode;
	private String restAreaName, line, tel, sleepingRoom, showerRoom, restHub, nursingRoom, pharmacy, agricultureMarket,
			carWash, carRepair;
	public RestAreaDTO() {
		super();
	}
	public RestAreaDTO(int restAreaCode, String restAreaName, String line, String tel, String sleepingRoom,
			String showerRoom, String restHub, String nursingRoom, String pharmacy, String agricultureMarket,
			String carWash, String carRepair) {
		super();
		this.restAreaCode = restAreaCode;
		this.restAreaName = restAreaName;
		this.line = line;
		this.tel = tel;
		this.sleepingRoom = sleepingRoom;
		this.showerRoom = showerRoom;
		this.restHub = restHub;
		this.nursingRoom = nursingRoom;
		this.pharmacy = pharmacy;
		this.agricultureMarket = agricultureMarket;
		this.carWash = carWash;
		this.carRepair = carRepair;
	}
	public int getRestAreaCode() {
		return restAreaCode;
	}
	public void setRestAreaCode(int restAreaCode) {
		this.restAreaCode = restAreaCode;
	}
	public String getRestAreaName() {
		return restAreaName;
	}
	public void setRestAreaName(String restAreaName) {
		this.restAreaName = restAreaName;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSleepingRoom() {
		return sleepingRoom;
	}
	public void setSleepingRoom(String sleepingRoom) {
		this.sleepingRoom = sleepingRoom;
	}
	public String getShowerRoom() {
		return showerRoom;
	}
	public void setShowerRoom(String showerRoom) {
		this.showerRoom = showerRoom;
	}
	public String getRestHub() {
		return restHub;
	}
	public void setRestHub(String restHub) {
		this.restHub = restHub;
	}
	public String getNursingRoom() {
		return nursingRoom;
	}
	public void setNursingRoom(String nursingRoom) {
		this.nursingRoom = nursingRoom;
	}
	public String getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	public String getAgricultureMarket() {
		return agricultureMarket;
	}
	public void setAgricultureMarket(String agricultureMarket) {
		this.agricultureMarket = agricultureMarket;
	}
	public String getCarWash() {
		return carWash;
	}
	public void setCarWash(String carWash) {
		this.carWash = carWash;
	}
	public String getCarRepair() {
		return carRepair;
	}
	public void setCarRepair(String carRepair) {
		this.carRepair = carRepair;
	}
	@Override
	public String toString() {
		return "RestAreaDTO [restAreaCode=" + restAreaCode + ", restAreaName=" + restAreaName + ", line=" + line
				+ ", tel=" + tel + ", sleepingRoom=" + sleepingRoom + ", showerRoom=" + showerRoom + ", restHub="
				+ restHub + ", nursingRoom=" + nursingRoom + ", pharmacy=" + pharmacy + ", agricultureMarket="
				+ agricultureMarket + ", carWash=" + carWash + ", carRepair=" + carRepair + "]";
	}
	
}

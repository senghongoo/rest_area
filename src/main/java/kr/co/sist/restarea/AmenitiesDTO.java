package kr.co.sist.restarea;

public class AmenitiesDTO {

	private int restareaCode;
	private String sleepingRoom, showerRoom, restHub, nursingRoom, pharmacy, agricultureMarket, carWash, carRepair;

	public AmenitiesDTO() {
		super();
	}

	public AmenitiesDTO(int restareaCode, String sleepingRoom, String showerRoom, String restHub, String nursingRoom,
			String pharmacy, String agricultureMarket, String carWash, String carRepair) {
		super();
		this.restareaCode = restareaCode;
		this.sleepingRoom = sleepingRoom;
		this.showerRoom = showerRoom;
		this.restHub = restHub;
		this.nursingRoom = nursingRoom;
		this.pharmacy = pharmacy;
		this.agricultureMarket = agricultureMarket;
		this.carWash = carWash;
		this.carRepair = carRepair;
	}

	public int getRestareaCode() {
		return restareaCode;
	}

	public void setRestareaCode(int restareaCode) {
		this.restareaCode = restareaCode;
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
		return "AmenitiesDTO [restareaCode=" + restareaCode + ", sleepingRoom=" + sleepingRoom + ", showerRoom="
				+ showerRoom + ", restHub=" + restHub + ", nursingRoom=" + nursingRoom + ", pharmacy=" + pharmacy
				+ ", agricultureMarket=" + agricultureMarket + ", carWash=" + carWash + ", carRepair=" + carRepair
				+ "]";
	}

}// class

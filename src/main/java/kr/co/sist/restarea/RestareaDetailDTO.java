package kr.co.sist.restarea;

public class RestareaDetailDTO {

	private int restareaCode;
	private String name, line, img, phrase, address, restareaTel, gasstationTel, food, scale;
	private double latitude, longitude;

	public RestareaDetailDTO() {
		super();
	}

	public RestareaDetailDTO(int restareaCode, String name, String line, String img, String phrase, String address,
			String restareaTel, String gasstationTel, String food, String scale, double latitude, double longitude) {
		super();
		this.restareaCode = restareaCode;
		this.name = name;
		this.line = line;
		this.img = img;
		this.phrase = phrase;
		this.address = address;
		this.restareaTel = restareaTel;
		this.gasstationTel = gasstationTel;
		this.food = food;
		this.scale = scale;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getRestareaCode() {
		return restareaCode;
	}

	public void setRestareaCode(int restareaCode) {
		this.restareaCode = restareaCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRestareaTel() {
		return restareaTel;
	}

	public void setRestareaTel(String restareaTel) {
		this.restareaTel = restareaTel;
	}

	public String getGasstationTel() {
		return gasstationTel;
	}

	public void setGasstationTel(String gasstationTel) {
		this.gasstationTel = gasstationTel;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "RestareaDetailDTO [restareaCode=" + restareaCode + ", name=" + name + ", line=" + line + ", img=" + img
				+ ", phrase=" + phrase + ", address=" + address + ", restareaTel=" + restareaTel + ", gasstationTel="
				+ gasstationTel + ", food=" + food + ", scale=" + scale + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}// class

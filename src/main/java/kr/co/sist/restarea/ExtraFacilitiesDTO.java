package kr.co.sist.restarea;

public class ExtraFacilitiesDTO {

	private int restareaCode;
	private String facilityCode, name, img, phrase;

	public ExtraFacilitiesDTO() {
		super();
	}

	public ExtraFacilitiesDTO(int restareaCode, String facilityCode, String name, String img, String phrase) {
		super();
		this.restareaCode = restareaCode;
		this.facilityCode = facilityCode;
		this.name = name;
		this.img = img;
		this.phrase = phrase;
	}

	public int getRestareaCode() {
		return restareaCode;
	}

	public void setRestareaCode(int restareaCode) {
		this.restareaCode = restareaCode;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "ExtraFacilitiesDTO [restareaCode=" + restareaCode + ", facilityCode=" + facilityCode + ", name=" + name
				+ ", img=" + img + ", phrase=" + phrase + "]";
	}

}// class

package vn.quanghuy.cinemaschedulev1.bean;

public class Cinema {

	private String cinemaName;
	private String address;
	private String ggMap;
	private int phoneNumber;
	private short id;

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGgMap() {
		return ggMap;
	}

	public void setGgMap(String ggMap) {
		this.ggMap = ggMap;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cinema [cinemaName=" + cinemaName + ", address=" + address + ", ggMap=" + ggMap + ", phoneNumber="
				+ phoneNumber + ", id=" + id + "]";
	}

}

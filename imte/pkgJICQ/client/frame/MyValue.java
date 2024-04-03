package pkgJICQ.client.frame;

public class MyValue {
	private String ID;

	private String name;

	private String picID;

	private String underWrite;

	private String IP;

	private String showID;

	private int status;

	public MyValue(String ID, String name, String picID, String underWrite,
			String IP, String showID, int status) {
		this.ID = ID;
		this.name = name;
		this.picID = picID;
		this.underWrite = underWrite;
		this.IP = IP;
		this.showID = showID;
		this.status = status;
	}

	public String getID() {
		return ID;
	}

	public String getname() {
		return name;
	}

	public String getpicID() {
		return picID;
	}

	public String getIP() {
		return IP;
	}

	public String getUnderWrite() {
		return underWrite;
	}

	public String getShowID() {
		return showID;
	}

	public int getStatus() {
		return status;
	}

	public String toString() {
		return name + "(" + ID + ")" + underWrite;
	}
}
package pkgJICQ.client.frame;

public class Person {
	private String ID;

	private String name;

	private String picID;

	private String underWrite;

	private int friendType;

	private String IP;

	private String showID;

	private int status;

	public Person(String ID, String name, String picID, String underWrite,
			int friendType, String IP, String showID, int status) {
		this.ID = ID;
		this.name = name;
		this.picID = picID;
		this.underWrite = underWrite;
		this.friendType = friendType;
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

	public int getfriendType() {
		return friendType;
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
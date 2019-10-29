package william.beans;

public class SchFaceInfor {
	private String inforID;
	private String title;
	private String content;
	private String author;
	private String showTime;
	private String insertTime;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInforID() {
		return inforID;
	}
	public void setInforID(String inforID) {
		this.inforID = inforID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	@Override
	public String toString() {
		return "SchFaceInfor [author=" + author + ", content=" + content
				+ ", inforID=" + inforID + ", insertTime=" + insertTime
				+ ", name=" + name + ", showTime=" + showTime + ", title="
				+ title + "]";
	}
}

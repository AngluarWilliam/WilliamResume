package william.dao;

public interface NewsInfoDao {
	public Object getNewInformation(String currentPage,String pageSize);
	public Object getNewsContent(String id);
	public Object getNew();
}

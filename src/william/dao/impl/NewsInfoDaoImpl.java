package william.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import william.beans.SchFaceInfor;
import william.dao.NewsInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("newsInfoDao")
public class NewsInfoDaoImpl implements NewsInfoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Object getNewInformation(String currentPage,String pageSize) {
		int start = (Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize);
		int limit = Integer.parseInt(pageSize)*Integer.parseInt(currentPage);
		
		String sql = "select * from " +
				"(select A.*,rownum rn from " +
				"(select t1.inforid,t1.title,t1.content,t1.author,t1.showtime,t1.inserttime,t1.readprov,t1.showscope,t1.isaudited,t1.ispassed,t1.reason,t1.xymhtitlepath,t1.taskid,t1.tbtype,t1.bmtztype,t2.mhinfortype " +
				"from t_schfaceinfor t1,t_mhinfortype t2 where t1.isaudited = '1' and t1.inforid = t2.inforid(+) and t2.mhinfortype = 'xyxw' order by t1.inserttime desc) A) " +
				"where rn > "+start+" and rn <= "+limit+"";
		RowMapper<SchFaceInfor> rowMapper = new BeanPropertyRowMapper<SchFaceInfor>(SchFaceInfor.class);
		List<SchFaceInfor> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	public Object getNewsContent(String id) {
		String sql = "select t1.inforid,t1.title,t1.content,t1.author,t1.showtime,t1.inserttime,t1.readprov,t1.showscope,t1.isaudited,t1.ispassed,t1.reason,t1.xymhtitlepath,t1.taskid,t1.tbtype,t1.bmtztype,t2.name " +
				"from t_schfaceinfor t1,t_user t2 " +
				"where t1.author = t2.job_number(+) and t1.inforid = ?";
		RowMapper<SchFaceInfor> rowMapper = new BeanPropertyRowMapper<SchFaceInfor>(SchFaceInfor.class);
		SchFaceInfor list = jdbcTemplate.queryForObject(sql, rowMapper,id);
		return list;
	}

	public Object getNew() {
		String sql = "select count(*) from sug_suggestion";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
		return null;
	}



}

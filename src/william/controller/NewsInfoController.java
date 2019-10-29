package william.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import william.dao.NewsInfoDao;


@Controller
@RequestMapping("/newInformation")
public class NewsInfoController {

	@Autowired
	private NewsInfoDao newsInfoDao;
	
	@RequestMapping(params = "method=getNewInformation")
	@ResponseBody
	public Object getNewInformation(@RequestParam("currentPage") String currentPage,
			@RequestParam("pageSize") String pageSize) {
		return newsInfoDao.getNewInformation(currentPage,pageSize);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Object getNewsContent(@PathVariable("id") String id) {
		return newsInfoDao.getNewsContent(id);
	}
	
	@RequestMapping(params = "method=getNew")
	@ResponseBody
	public Object getNew() {
		return newsInfoDao.getNew();
	}
}

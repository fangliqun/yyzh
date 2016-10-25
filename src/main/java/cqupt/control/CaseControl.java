package cqupt.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import cqupt.domain.Case;
import cqupt.exception.CaseException;
import cqupt.service.CaseService;
import cqupt.utils.GsonUtils;

@Controller
@RequestMapping("/case")
public class CaseControl {
	@Resource(name="caseServiceImp")//Autowired
	private CaseService caseService;
	@RequestMapping(value="/selectCaseByPage",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String selectCaseByPage(@RequestParam("page")int page){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		try {
			List<Case> list=caseService.selectCase(page);
			if(!list.isEmpty()){
				return GsonUtils.EntityToJson(list).toString();
			}else{
				jsonObject.addProperty("msg", "查询case失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
}

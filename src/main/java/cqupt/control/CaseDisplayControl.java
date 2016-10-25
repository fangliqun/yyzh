package cqupt.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import cqupt.domain.CaseDisplay;
import cqupt.domain.SpCase;
import cqupt.exception.CaseDisplayException;
import cqupt.exception.SpCaseException;
import cqupt.service.CaseDisplayService;
import cqupt.utils.GsonUtils;

@Controller
@RequestMapping("/caseDisplay")
public class CaseDisplayControl {
	@Autowired
	private CaseDisplayService caseDisplayService;
	
	@RequestMapping(value="/selectCaseDisplayById",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String selectSpCaseByCaseId(@RequestParam("id")int id){//这儿就是case表的id，一个接一个往下传
		JsonObject jsonObject=GsonUtils.getJsonObject();
		try {
			List<CaseDisplay> list=caseDisplayService.selectCaseDisPlayByCaseId(id);
			if(!list.isEmpty()){
				return GsonUtils.EntityToJson(list).toString();
			}else{
				jsonObject.addProperty("msg", "查询CaseDisplay失败");
				return jsonObject.toString();
			}
		} catch (CaseDisplayException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
}

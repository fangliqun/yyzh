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
import cqupt.domain.SpCase;
import cqupt.exception.CaseException;
import cqupt.exception.SpCaseException;
import cqupt.service.SpCaseService;
import cqupt.utils.GsonUtils;

@Controller
@RequestMapping("/spCase")
public class SpCaseControl {
	@Resource(name="spCaseServiceImp")
	private SpCaseService spCaseService;
	
	@RequestMapping(value="/selectSpCaseById",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String selectSpCaseByCaseId(@RequestParam("id")int id){//这儿就是case表的id，一个接一个往下传
		JsonObject jsonObject=GsonUtils.getJsonObject();
		try {
			SpCase spCase=spCaseService.spCaseByCaseId(id);
			if(spCase!=null){
				return GsonUtils.EntityToJson(spCase).toString();
			}else{
				jsonObject.addProperty("msg", "查询spCase失败");
				return jsonObject.toString();
			}
		} catch (SpCaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
}

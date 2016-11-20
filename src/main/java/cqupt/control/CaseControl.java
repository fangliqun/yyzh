package cqupt.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import cqupt.domain.Case;
import cqupt.exception.CaseException;
import cqupt.service.CaseService;
import cqupt.utils.GsonUtils;

@Controller
@RequestMapping("/case")
public class CaseControl {
	//@Resource(name="caseServiceImp")
	@Autowired
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
	
	@RequestMapping(value="/delete",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String delete(@RequestParam("id")int id){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		try {
			int i=caseService.delete(id);
			if(i!=0){
				jsonObject.addProperty("msg", "删除成功");
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "删除失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/selectSbContentById",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String selectSbContentById(@RequestParam("id")int id){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		try {
			String s=caseService.selectSbContentById(id);
			if(s!=null){
				jsonObject.addProperty("msg",s);
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "查询sbContent失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/insertCaseContent",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String insertCaseContent(@RequestParam("case")String s){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		Case case_=GsonUtils.getEntity(s,Case.class);
		String time=System.currentTimeMillis()+"";
		case_.setTime(time);
		try {
			int i=caseService.insertCase(case_);
			if(i!=0){
				Case c=caseService.selectCaseInfo(case_.getTitle());
				jsonObject.addProperty("id", c.getId());
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "添加失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	@RequestMapping(value="/insertCaseContent_",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String insertCaseContent_(@RequestParam("case")String s){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		Case case_=GsonUtils.getEntity(s,Case.class);
		String time=System.currentTimeMillis()+"";
		case_.setTime(time);
		try {
			int i=caseService.insertCase(case_);
			if(i!=0){
				Case c=caseService.selectCaseInfo(case_.getTitle());
				jsonObject.addProperty("id", c.getId());
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "添加失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	
	@RequestMapping(value="/insertCaseContent1",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String insertCaseContent1(@RequestParam("title")String s){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		Case case_=new Case();
		case_.setTitle(s);
		String time=System.currentTimeMillis()+"";
		case_.setTime(time);
		try {
			int i=caseService.insertCase(case_);
			if(i!=0){
				Case c=caseService.selectCaseInfo(case_.getTitle());
				jsonObject.addProperty("id", c.getId());
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "添加失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/selectAllCaseName",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String selectAllCaseName(){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		try {
			List<String> list=caseService.selectAllCaseName();
			if(!list.isEmpty()){
				return GsonUtils.EntityToJson(list).toString();
			}else{
				jsonObject.addProperty("msg", "查询所有casename失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/selectCaseInfo",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String selectCaseInfo(@RequestParam("title")String title){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		try {
			Case case_=caseService.selectCaseInfo(title);
			if(case_!=null){
				return GsonUtils.EntityToJson(case_).toString();
			}else{
				jsonObject.addProperty("msg", "查询所有caseinfo失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/update",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String update(@RequestParam("case")String s){
		System.out.println(s);
		JsonObject jsonObject=GsonUtils.getJsonObject();
		Case case_=GsonUtils.getEntity(s,Case.class);
		try {
			int i=caseService.update(case_);
			if(i!=0){
				jsonObject.addProperty("msg", "更新成功");
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "更新失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/updateSbContent",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String updateSbContent(@RequestParam("id")int id,@RequestParam("sbcontent")String sbcontent){
		JsonObject jsonObject=GsonUtils.getJsonObject();
//		Case case_=GsonUtils.getEntity(s,Case.class);
		Case case_=new Case();
		case_.setId(id);
		case_.setSbcontent(sbcontent);
		try {
			int i=caseService.update(case_);
			if(i!=0){
				jsonObject.addProperty("msg", "更新成功");
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "更新失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/update1",produces="application/json;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String update1(@RequestParam("id")int id,@RequestParam("sbcontent")String sbcontent){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		Case case_=new Case();
		case_.setId(id);
		case_.setSbcontent(sbcontent);
		try {
			int i=caseService.update(case_);
			if(i!=0){
				jsonObject.addProperty("msg", "更新成功");
				return jsonObject.toString();
			}else{
				jsonObject.addProperty("msg", "更新失败");
				return jsonObject.toString();
			}
		} catch (CaseException e) {
			jsonObject.addProperty("msg", e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/uploadCaseContentPicture",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String uploadCaseContentPicture(HttpServletRequest request,
			@RequestParam("picture")MultipartFile picture,
			@RequestParam("id")int id//需要id,因为图片需要
			){
		JsonObject jsonObject=GsonUtils.getJsonObject();
		String time =System.currentTimeMillis()+"";
		Case case_=new Case();
		//int id=1;
		case_.setId(id);
		try {
			 if (picture!=null) {
		         String fileNamePicture = picture.getOriginalFilename();
		         
		         List<Object> fileTypes=new ArrayList<Object>();
				 fileTypes.add("jpg");
				 fileTypes.add("jpeg");  
				 fileTypes.add("bmp");  
				 fileTypes.add("gif");
				            
			     String fp = fileNamePicture.substring(fileNamePicture.lastIndexOf(".")+1);  
			     fp = fp.toLowerCase();  
			     
			     String filePathb="C:/yyzh//case//"+id+"//"+time+"."+fp;
		         String filePath1 = "http://localhost:8080/yyzh/upload/case/"+id+"/"+time+"."+fp;
			     
//			     String filePathb="D:\\TomCat\\apache-tomcat-7.0.64\\webapps\\yyzh\\case\\"+id+"\\"+time+"."+fp;
//		         String filePath1 = "http://localhost:8080/yyzh/case/"+id+"/"+time+"."+fp;
				             
			     if(fileTypes.contains(fp)){
			            	FileUtils.copyInputStreamToFile(picture.getInputStream(), new File(filePathb));
			     }else{
				         jsonObject.addProperty("msg","图片格式不对");
				         return jsonObject.toString(); 
			     }
			     case_.setUrl(filePath1);
			     int i=caseService.update(case_);
			     if(i==1){
			    	 jsonObject.addProperty("msg","上传成功");
			         return jsonObject.toString(); 
			    }else{
			    	 jsonObject.addProperty("msg","上传失败");
			         return jsonObject.toString(); 
			    }
			}else{
				jsonObject.addProperty("msg","isEmpty");
				return jsonObject.toString(); 
			}
		} catch (IllegalStateException e) {
			jsonObject.addProperty("msg",e.getMessage());
			return jsonObject.toString();
		} catch (IOException e) {
			jsonObject.addProperty("msg",e.getMessage());
			return jsonObject.toString();
		} catch (CaseException e) {
			jsonObject.addProperty("msg",e.getMessage());
			return jsonObject.toString();
		}
	}
	
	@RequestMapping(value="/uploadCaseSbContentPicture",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String uploadCaseSbContentPicture(HttpServletRequest request,
			@RequestParam("picture")MultipartFile picture,
			@RequestParam("id")int id//需要id,因为图片需要
			){
			//int id=2;
		JsonObject jsonObject=GsonUtils.getJsonObject();
		String time =System.currentTimeMillis()+"";
		System.out.println(id);
		try {
			 if (picture!=null) {
		         String fileNamePicture = picture.getOriginalFilename();
		         
		         List<Object> fileTypes=new ArrayList<Object>();
				 fileTypes.add("jpg");
				 fileTypes.add("jpeg");  
				 fileTypes.add("bmp");  
				 fileTypes.add("gif");
				            
			     String fp = fileNamePicture.substring(fileNamePicture.lastIndexOf(".")+1);  
			     fp = fp.toLowerCase();  
			     
			     
			     String filePathb="C:\\yyzh\\case\\"+id+"\\"+time+"."+fp;
		         String filePath1 = "http://localhost:8080/yyzh/upload/case/"+id+"/"+time+"."+fp;
//			     String filePathb="D:\\TomCat\\apache-tomcat-7.0.64\\webapps\\yyzh\\case\\"+id+"\\"+time+"."+fp;
//		         String filePath1 = "http://localhost:8080/yyzh/case/"+id+"/"+time+"."+fp;
				             
			     if(fileTypes.contains(fp)){
			            	FileUtils.copyInputStreamToFile(picture.getInputStream(), new File(filePathb));
			     }else{
				         jsonObject.addProperty("msg","图片格式不对");
				         return jsonObject.toString(); 
			     }
				 jsonObject.addProperty("url",filePath1);
				 return jsonObject.toString(); 
			}else{
				jsonObject.addProperty("msg","isEmpty");
				return jsonObject.toString(); 
			}
		} catch (IllegalStateException e) {
			jsonObject.addProperty("msg",e.getMessage());
			return jsonObject.toString();
		} catch (IOException e) {
			jsonObject.addProperty("msg",e.getMessage());
			return jsonObject.toString();
		}
	}
	

@RequestMapping(value="/uploadCaseContentPicture1",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
@ResponseBody
public String uploadCaseContentPicture1(HttpServletRequest request,
		@RequestParam("picture")MultipartFile picture,
//		@RequestParam("id")int id//需要id,因为图片需要
		@RequestParam("title")String title,
		@RequestParam("username")String username
		){
	JsonObject jsonObject=GsonUtils.getJsonObject();
	Case case_=new Case();
	case_.setTitle(title);
	case_.setUsername(username);
	String time=System.currentTimeMillis()+"";
	case_.setTime(time);
	int id=0;
	try {
		int i=caseService.insertCase(case_);
		if(i!=0){
			Case c=caseService.selectCaseInfo(case_.getTitle());
			id=c.getId();
		}
		if (picture!=null) {
	         String fileNamePicture = picture.getOriginalFilename();
	         
	         List<Object> fileTypes=new ArrayList<Object>();
			 fileTypes.add("jpg");
			 fileTypes.add("jpeg");  
			 fileTypes.add("bmp");  
			 fileTypes.add("gif");
			            
		     String fp = fileNamePicture.substring(fileNamePicture.lastIndexOf(".")+1);  
		     fp = fp.toLowerCase();  
		     
		     String filePathb="C:/yyzh//case//"+id+"//"+time+"."+fp;
	         String filePath1 = "http://localhost:8080/yyzh/upload/case/"+id+"/"+time+"."+fp;
		     
//		     String filePathb="D:\\TomCat\\apache-tomcat-7.0.64\\webapps\\yyzh\\case\\"+id+"\\"+time+"."+fp;
//	         String filePath1 = "http://localhost:8080/yyzh/case/"+id+"/"+time+"."+fp;
			             
		     if(fileTypes.contains(fp)){
		            	FileUtils.copyInputStreamToFile(picture.getInputStream(), new File(filePathb));
		     }else{
			         jsonObject.addProperty("msg","图片格式不对");
			         return jsonObject.toString(); 
		     }
		     Case case__=new Case();
		     case__.setId(id);
		     case__.setUrl(filePath1);
		     int j=caseService.update(case__);
		     if(j!=0){
		    	 jsonObject.addProperty("id",id);
		         return jsonObject.toString(); 
		    }else{
		    	 jsonObject.addProperty("msg","上传失败");
		         return jsonObject.toString(); 
		    }
		}else{
			jsonObject.addProperty("msg","isEmpty");
			return jsonObject.toString(); 
		}
	} catch (IllegalStateException e) {
		jsonObject.addProperty("msg",e.getMessage());
		return jsonObject.toString();
	} catch (IOException e) {
		jsonObject.addProperty("msg",e.getMessage());
		return jsonObject.toString();
	} catch (CaseException e) {
		jsonObject.addProperty("msg",e.getMessage());
		return jsonObject.toString();
	}
}
}
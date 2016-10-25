package cqupt.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqupt.dao.CaseMapper;
import cqupt.domain.Case;
import cqupt.exception.CaseException;
import cqupt.service.CaseService;
@Service
public class CaseServiceImp implements CaseService {
	@Autowired
	//@Resource(name="caseMapper")
	private CaseMapper caseMapper;
	public List<Case> selectCase(int page) throws CaseException {
		page=(page-1)*12;
		try {
     		return caseMapper.selectCaseByPage(page);
//			List<Case> list=caseMapper.selectCaseByPage(page);
//			System.out.println(list.isEmpty());
//			return list;
		} catch (Exception e) {
			throw new CaseException("查询分页case失败");
		}
	}

}

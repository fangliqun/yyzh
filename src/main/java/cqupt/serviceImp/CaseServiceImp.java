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
public class CaseServiceImp implements CaseService {//@Resource(name="caseMapper")
	@Autowired
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

	public int insertCase(Case case_) throws CaseException {
		try {
			return caseMapper.insert(case_);
		} catch (Exception e) {
			throw new CaseException("上传case失败");
		}
	}

	public List<String> selectAllCaseName() throws CaseException {
		try {
			return caseMapper.selectAllCaseName();
		} catch (Exception e) {
			throw new CaseException("查询所有casename失败");
		}
	}

	public Case selectCaseInfo(String title) throws CaseException {
		try {
			return caseMapper.selectCaseInfo(title);
		} catch (Exception e) {
			throw new CaseException("查询所有caseinfo失败");
		}
	}

	public int update(Case case_) throws CaseException {
		try {
			return caseMapper.update(case_);
		} catch (Exception e) {
			throw new CaseException("更新case失败");
		}
	}

	public String selectSbContentById(int id) throws CaseException {
		try {
			return caseMapper.selectSbContentById(id);
		} catch (Exception e) {
			throw new CaseException("查询sbContent失败");
		}
	}

	public int delete(int id) throws CaseException {
		try {
			return caseMapper.delete(id);
		} catch (Exception e) {
			throw new CaseException("删除失败");
		}
	}

}

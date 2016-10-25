package cqupt.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqupt.dao.CaseDisplayMapper;
import cqupt.domain.CaseDisplay;
import cqupt.exception.CaseDisplayException;
import cqupt.service.CaseDisplayService;
@Service
public class CaseDisplayServiceImp implements CaseDisplayService {
	@Autowired
	private CaseDisplayMapper caseDispalyMapper;
	public List<CaseDisplay> selectCaseDisPlayByCaseId(int caseId) throws CaseDisplayException {
		try {
			return caseDispalyMapper.selectByPrimaryKey(caseId);
		} catch (Exception e) {
			throw new CaseDisplayException("查询caseDisplay错误");
		}
	}

}

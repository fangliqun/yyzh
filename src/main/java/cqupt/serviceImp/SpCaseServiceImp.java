package cqupt.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqupt.dao.SpCaseMapper;
import cqupt.domain.SpCase;
import cqupt.exception.SpCaseException;
import cqupt.service.SpCaseService;
@Service
public class SpCaseServiceImp implements SpCaseService {
	@Autowired
	private SpCaseMapper spCaseMapper;
	public SpCase spCaseByCaseId(int spCaseId) throws SpCaseException {
		try {
			return spCaseMapper.selectByPrimaryKey(spCaseId);
		} catch (Exception e) {
			throw new SpCaseException("查找spcase失败");
		}
	}

}

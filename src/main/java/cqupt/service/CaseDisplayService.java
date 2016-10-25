package cqupt.service;

import java.util.List;

import cqupt.domain.CaseDisplay;
import cqupt.exception.CaseDisplayException;

public interface CaseDisplayService {
	public List<CaseDisplay> selectCaseDisPlayByCaseId(int caseId/*一个接一个表*/) throws CaseDisplayException;
}

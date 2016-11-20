package cqupt.service;

import java.util.List;

import cqupt.domain.Case;
import cqupt.exception.CaseException;

public interface CaseService {
	public List<Case> selectCase(int page) throws CaseException;
	
	public int insertCase(Case case_)throws CaseException;
	
	public List<String> selectAllCaseName()throws CaseException;
	
	public Case selectCaseInfo(String title)throws CaseException;
	
	public int update(Case case_)throws CaseException;
	
	public String selectSbContentById(int id)throws CaseException;
	
	public int delete(int id)throws CaseException;
}

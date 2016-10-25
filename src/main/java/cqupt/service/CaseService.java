package cqupt.service;

import java.util.List;

import cqupt.domain.Case;
import cqupt.exception.CaseException;

public interface CaseService {
	public List<Case> selectCase(int page) throws CaseException;
}

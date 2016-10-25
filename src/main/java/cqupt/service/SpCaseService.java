package cqupt.service;

import cqupt.domain.SpCase;
import cqupt.exception.SpCaseException;

public interface SpCaseService {
	public SpCase spCaseByCaseId(int spCaseId) throws SpCaseException;
}

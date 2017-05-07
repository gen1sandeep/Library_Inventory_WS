package com.thoughtworks.library.inventory.service;

import javax.inject.Inject;

import com.thoughtworks.library.inventory.common.exception.IncorrectRequestDataException;
import com.thoughtworks.library.inventory.dbaccess.ProcurementDAO;
import com.thoughtworks.library.inventory.model.BookProcurementInfo;

public class ProcurementServiceImpl implements ProcurementService {

	private ProcurementDAO procurementDAO;

	@Inject
	public ProcurementServiceImpl(ProcurementDAO procurementDAO) {
		this.procurementDAO = procurementDAO;
	}

	@Override
	public long procureBook(BookProcurementInfo inputVO) {

		// perform validations
		if (inputVO == null || inputVO.getIsbn().length() <= 0) {
			throw new IncorrectRequestDataException("Request Data is Invalid. ISBN cannot be empty");
		}else if(inputVO.getIsbn()==null ||  inputVO.getIsbn().matches("^[a-zA-Z]*$")){
				throw new IncorrectRequestDataException("ISBN::["+inputVO.getIsbn()+"] is not valid. Request rejected.");			
		}else if(inputVO.getBookStatus() == null ||  inputVO.getBookStatus().length()>1){
			throw new IncorrectRequestDataException("ISBN::["+inputVO.getBookStatus()+"] is not valid. Request rejected.");
		}
		
		long bookId = procurementDAO.insertRecord(inputVO);
		
		return bookId;
	}

}

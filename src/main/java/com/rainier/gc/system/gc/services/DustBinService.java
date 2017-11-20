package com.rainier.gc.system.gc.services;

import com.rainier.gc.system.gc.exception.ServiceException;
import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.services.generic.GenericEntityService;

public interface DustBinService extends GenericEntityService<Long, DustBin>{

	DustBin findBinByBarCode(String barCode);

	boolean saveOrUpdate(DustBin dustBin,String typeOfBarcode) throws ServiceException;
}


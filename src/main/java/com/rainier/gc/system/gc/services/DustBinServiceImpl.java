package com.rainier.gc.system.gc.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.rainier.gc.system.gc.exception.ServiceException;
import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.repositories.DustBinRepository;
import com.rainier.gc.system.gc.services.generic.GenericrEntityServiceImpl;
import com.rainier.gc.system.gc.utils.BarcodeGeneratorUtil;

@Service
public class DustBinServiceImpl extends GenericrEntityServiceImpl<Long, DustBin> implements DustBinService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DustBinServiceImpl.class);

	private DustBinRepository binRepository;

	@Autowired
	public DustBinServiceImpl(DustBinRepository repository) {
		super(repository);
		binRepository = repository;
	}

	@Override
	@Transactional
	public DustBin findBinByBarCode(String barCode) {
		return binRepository.findByBarCode(barCode);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRES_NEW,rollbackFor=ServiceException.class)
	public boolean saveOrUpdate(DustBin dustBin,String typeOfBarcode) throws ServiceException
	{
		try
		{
			this.save(dustBin);

			String barCodeNum=BarcodeGeneratorUtil.uniqueNumberGeneration(String.valueOf(dustBin.getId()),typeOfBarcode,"");

			String basePath="C:\\Users\\erapami\\Desktop\\Projects\\GCSS\\";
			
			String barCodeImageName=BarcodeGeneratorUtil.createFileName(basePath,barCodeNum,typeOfBarcode);

			BitMatrix bitMatrix=BarcodeGeneratorUtil.generateBarCode(barCodeNum,typeOfBarcode);

			BarcodeGeneratorUtil.writeGeneratedBarToFileSystem(bitMatrix,barCodeNum,barCodeImageName,typeOfBarcode);
			
			DustBin updateBinDetails=this.getById(dustBin.getId());
			updateBinDetails.setBarCode(barCodeNum);
			updateBinDetails.setBarCodeImage(basePath);
			this.update(updateBinDetails);
		}
		catch(Exception e)
		{
			throw new ServiceException("Failed to generate barcode!!!");
		}
		return true;
	}
}
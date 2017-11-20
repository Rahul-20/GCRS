package com.rainier.gc.system.gc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.common.BitMatrix;
import com.rainier.gc.system.gc.exception.ServiceException;
import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.repositories.TruckRepository;
import com.rainier.gc.system.gc.services.generic.GenericrEntityServiceImpl;
import com.rainier.gc.system.gc.utils.BarcodeGeneratorUtil;

@Service
@Transactional
public class TruckServiceImpl extends GenericrEntityServiceImpl<Long, Truck> implements TruckService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private TruckRepository truckRepository;

	@Autowired
	public TruckServiceImpl(TruckRepository repository) {
		super(repository);
		truckRepository = repository;
	}

	@Override
	public Truck findTruckByBarCode(String barCode) {
		return truckRepository.findByBarCode(barCode);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRES_NEW,rollbackFor=ServiceException.class)
	public boolean saveOrUpdate(Truck truck, String typeOfBarcode,String truckNum) throws ServiceException {
		try
		{
			this.save(truck);

			String barCodeNum=BarcodeGeneratorUtil.uniqueNumberGeneration(String.valueOf(truck.getId()),typeOfBarcode,truckNum);

			String basePath="C:\\Users\\erapami\\Desktop\\Projects\\GCSS\\";
			
			String barCodeImageName=BarcodeGeneratorUtil.createFileName(basePath,barCodeNum,typeOfBarcode);

			BitMatrix bitMatrix=BarcodeGeneratorUtil.generateBarCode(barCodeNum,typeOfBarcode);

			BarcodeGeneratorUtil.writeGeneratedBarToFileSystem(bitMatrix,barCodeNum,barCodeImageName,typeOfBarcode);
			
			Truck updateTruckDetails=this.getById(truck.getId());
			updateTruckDetails.setBarCode(barCodeNum);
			updateTruckDetails.setBarCodeImage(basePath);
			this.update(updateTruckDetails);
		}
		catch(Exception e)
		{
			throw new ServiceException("Failed to generate barcode!!!");
		}
		return true;
	}
}
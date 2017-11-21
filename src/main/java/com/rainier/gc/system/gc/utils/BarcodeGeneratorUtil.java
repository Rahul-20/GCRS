package com.rainier.gc.system.gc.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class BarcodeGeneratorUtil 
{
	public static String generateBarcode(String barcodeNum,String typeOfBarcode) throws IOException, WriterException
	{
		String basePath="/opt/gcs/img/";
		String barCodeImageName=createFileName(basePath,barcodeNum,typeOfBarcode);
		BitMatrix bitMatrix=BarcodeGeneratorUtil.createBarCode(barcodeNum,typeOfBarcode);
		BarcodeGeneratorUtil.writeGeneratedBarToFileSystem(bitMatrix,barcodeNum,barCodeImageName,typeOfBarcode);
		return basePath+barCodeImageName;
	}

	public static String uniqueNumberGeneration(String id,String typeOfBarcode,String truckNum)
	{
		if(typeOfBarcode.equalsIgnoreCase("Truck"))
		{
			String uniqueNum="TK"+id+"00000"+truckNum;
			return uniqueNum;
		}
		else if(typeOfBarcode.equalsIgnoreCase("Bin"))
		{
			String uniqueNum="BN00000"+id;
			return uniqueNum;
		}
		return "";
	}

	public static String createFileName(String basePath,String barCodeNum,String type)
	{
		String fileName="BC_"+barCodeNum+"_"+type;
		return basePath+type+"//"+fileName+".png";
	}

	public static BitMatrix createBarCode(String barCodeNum,String type) throws IOException, WriterException
	{
		BitMatrix bitMatrix = new Code128Writer().encode(barCodeNum, BarcodeFormat.CODE_128, 150, 80);
		return bitMatrix;
	}

	public static void writeGeneratedBarToFileSystem(BitMatrix bitMatrix,String barCodeNum,String fileName,String type) throws IOException
	{
		OutputStream out=null;
		try
		{
			out=new FileOutputStream(new File(fileName));
			MatrixToImageWriter.writeToStream(bitMatrix,"png",out);
		}
		finally
		{
			if(null!=out)
			{
				out.close();
			}
		}
	}

	/*public static void readBarCodeUsingZxing() throws NotFoundException, ChecksumException, FormatException, IOException
	{
		InputStream barCodeInputStream = new FileInputStream(new File("C:\\Users\\erapami\\Desktop\\Projects\\GCSS\\BC_AU11100000AP09BJ8068_Truck.png"));
		BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

		LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		Map<DecodeHintType, Object> tmpHintsMap = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
		tmpHintsMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
		tmpHintsMap.put(DecodeHintType.POSSIBLE_FORMATS,EnumSet.allOf(BarcodeFormat.class));
		tmpHintsMap.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);

		Reader reader = new MultiFormatReader();
		Result result = reader.decode(bitmap,tmpHintsMap);
		System.out.println("Barcode text is " + result.getText());
	}
	 */


	/*
	public static Code128Bean barCodeProperties()
	{
		Code128Bean barcode128Bean = new Code128Bean();
		barcode128Bean.setBarHeight(10);
		return barcode128Bean;
	}

	public static void generateBarCodeUsingBarCodeFourJ(String barCodeString,String type) throws IOException
	{
		String barCodeImgName=createFileName(barCodeString,type);

		Code128Bean code128Bean=barCodeProperties();

		writeTheGeneratedBarCodeUsingBarCodeFourJToDestPath(code128Bean,barCodeString,barCodeImgName);
	}

	public static void writeTheGeneratedBarCodeUsingBarCodeFourJToDestPath(Code128Bean code128Bean,String barCodeString,String fileName) throws IOException
	{
		OutputStream out=new FileOutputStream(new File("C:\\Users\\erapami\\Desktop\\Projects\\GCSS\\"+fileName+".png"));
		BitmapCanvasProvider provider=new BitmapCanvasProvider(out,"image/x-png",200,BufferedImage.TYPE_BYTE_BINARY, false,0);
		code128Bean.generateBarcode(provider,barCodeString);
		provider.finish();	
	}*/
}
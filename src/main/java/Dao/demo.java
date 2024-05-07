package Dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import java.io.File;
import java.text.SimpleDateFormat;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

public class demo {
	public static final Logger logger=LogManager.getLogger(demo.class);
	public static AllInOne all;
	public static void main(String[] args) {
		String filePath="C:\\Users\\user\\eclipse-workspace\\log4j";
		File file = new File(filePath);
		if(file.exists())
		{
			String absolutePath=file.getAbsolutePath();
			System.out.println("檔案存在,完整路徑為:"+absolutePath+System.getProperty("java.version"));
		}
		else
		{
			System.out.println("檔案或目錄不存在");
		}
		logger.debug("This is a debug message");
		all=new AllInOne("");
		System.out.println(getAioCheckOutAll());
		
	}
	
	public static String getAioCheckOutAll()
	{
		AioCheckOutALL aio=new AioCheckOutALL();
		aio.setMerchantTradeNo("testcompany0004");
		aio.setMerchantTradeDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date()));
		aio.setTotalAmount("1000");
		aio.setTradeDesc("test");
		aio.setItemName("item");
		aio.setReturnURL("http://211.23.128.214:5000");
		aio.setNeedExtraPaidInfo("N");
		String form=all.aioCheckOut(aio, null);
		return form;
	}
	
}
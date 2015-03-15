package com.ndsoft.cms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 格式化日期显示字符串
	 * @param date 
	 * 		格式化目标日期
	 * @param format 
	 * 		格式化字符串(yyyy-MM-dd)
	 * @return 
	 * 		格式化日期显示结果
	 */
	public static String format(Date date,String format){
		 SimpleDateFormat sdf = new SimpleDateFormat(format);
		 return sdf.format(date);
	}
}

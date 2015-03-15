package com.ndsoft.cms.util;

public class StringUtil {
	
	/**
	 * 判断字符串是否为null或空
	 * @param str 
	 * 		目标字符串
	 * @return 
	 * 		判断结果
	 */
	public static boolean isNullOrEmpty(String str){
		if(str == null || str.length() == 0)return true;
		return false;
	}
	
	public static String format(String str,String ... args) {  
        if(str == null || "".equals(str)) return "";  
        if(args.length == 0) return str;  
        String result = str;  
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\{(\\d+)\\}");  
        java.util.regex.Matcher m = p.matcher(str);  
        while(m.find()) {  
            int index = Integer.parseInt(m.group(1));  
            if(index<args.length) 
            	result=result.replace(m.group(),args[index].toString());  
                
        }  
        return result;  
    }  
	
	public static String join(String [] args) {
		if(args == null || args.length == 0)return "";
		String result = "";
		Object [] arrays = args;
		int collSize = arrays.length;
		for (int i = 0; i < collSize; i++) {
			if (i == collSize - 1) result += arrays[i];
			else result += arrays[i] + ","; 
		}
		return result;
	}
}

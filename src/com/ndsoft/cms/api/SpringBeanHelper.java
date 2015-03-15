package com.ndsoft.cms.api;

/**
 * Spring容器帮助类，用户获取容器内实例对象
 * @author LiangZheHao
 *
 */
public class SpringBeanHelper {
	
	public static String format(String str,Object ... args) {  
        if(str==null||"".equals(str))  
            return "";  
        if(args.length==0) {  
            return str;  
        }  
        String result=str;  
  
        //这里的作用是只匹配{}里面是数字的子字符串  
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\{(\\d+)\\}");  
        java.util.regex.Matcher m = p.matcher(str);  
        while(m.find()) {  
            //获取{}里面的数字作为匹配组的下标取值  
            int index=Integer.parseInt(m.group(1));  
  
            //这里得考虑数组越界问题，{1000}也能取到值么？？  
            if(index<args.length) {  
  
                //替换，以{}数字为下标，在参数数组中取值  
                result=result.replace(m.group(),args[index].toString());  
            }  
        }  
        return result;  
    }  
	
	
	public static String join(Object [] args) {
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

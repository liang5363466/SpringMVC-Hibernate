package com.ndsoft.cms.api;

/**操作结果类型定义*/
public class ResultType {
	
	/**操作成功*/
	public static final Integer Success = 0;
	
	/**操作取消或操作没引发任何变化*/
	public static final Integer NoChanged = 1;
	
	/**参数错误*/
	public static final Integer ParamError  = 2;
	
	/**指定参数的数据不存在*/
	public static final Integer QueryNull  = 3;
	
	/**权限不足*/
	public static final Integer PurviewLack  = 4;
	
	/**非法操作*/
	public static final Integer IllegalOperation  = 5;
	
	/**警告*/
	public static final Integer Warning  = 6;
	
	/**操作引发错误*/
	public static final Integer Error  = 7;
}

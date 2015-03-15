package com.ndsoft.cms.api;

import java.util.List;

import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;

public class DataTableHelper {
	
	/**
	 * 将DataTable转换为JSON字符串
	 * @param dt 
	 * 		DataTable对象
	 * @return
	 * 		JSON字符串
	 */
	public static StringBuilder toJsonString(DataTable dt){
		if(dt == null || dt.getRows().size() == 0)return null;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		List<TableRow> rows = dt.getRows();
		for (int r = 0,rowCount = rows.size(); r < rowCount; r++) {
			sb.append("{");
			for (int c = 0,colCount = dt.getColumnDescriptions().size(); c < colCount; c++) {
				sb.append(dt.getColumnDescription(c).getId()).append(":").append(dt.getValue(r, c)).append(",");
			}
			sb.deleteCharAt(sb.length()-1) ;
			sb.append("},");
		}
		sb.deleteCharAt(sb.length()-1) ;
		sb.append("]");
		return sb;
	} 
	
	
}

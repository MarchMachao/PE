package cn.vito.coding.check.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对String类型操作的工具类
 * 
 * @author baijw12
 *
 */
public class StringUtils {

	/**
	 * 判断字符串是否是null,'null',""中的一个
	 * 
	 * @return 是返回true,不是返回false
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 || str.equals("null");
	}
	
	/**
	 * 日期转化String 格式 yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateTimeToString(Date date){
		SimpleDateFormat datetemp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return datetemp.format(date);
	}

	/**
	 * 日期转化String 格式 yyyy
	 * 
	 * @param date
	 * @return
	 */
	public static String yearToString(Date date) {
		SimpleDateFormat datetemp = new SimpleDateFormat("yyyy");
		return datetemp.format(date);
	}
	/**
	 * 日期转化String 格式 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		SimpleDateFormat datetemp = new SimpleDateFormat("yyyy-MM-dd");
		return datetemp.format(date);
	}
	
	/**
	 * 日期转化为String   Date   20170523111111   年月日时分秒无分隔符
	 * @param date
	 * @return
	 */
	public static String dateTimeToStringWithoutSpit(Date date){
		SimpleDateFormat datetemp = new SimpleDateFormat("yyyyMMddHHmmss");
		return datetemp.format(date);
	}
	
	/**
	 * 获取文件扩展名
	 * @param fileName   xxxxx.jgp
	 * @return
	 */
	public static String getSysName(String fileName){
		String[] names = fileName.split("\\.");
		return names[names.length-1];
	}
	
}

package cn.vito.coding.check.utils;

import java.text.ParseException;
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
	
	public static String gradeIntToString(int grade) throws ParseException {
		String begin = grade + "0901";
		SimpleDateFormat datetemp = new SimpleDateFormat("yyyyMMdd");
		Date date1 = datetemp.parse(begin);
		Date date2 = new Date();
		int i=24 * 60 * 60 * 1000;
		if ((date2.getTime() - date1.getTime()) / i < 365) {
			return "大一";
		} else if ((date2.getTime() - date1.getTime()) / i < 730 && 365 <= (date2.getTime() - date1.getTime())) {
			return "大二";
		} else if ((date2.getTime() - date1.getTime()) / i < 1095 && 730 <= (date2.getTime() - date1.getTime())) {
			return "大三";
		} else if ((date2.getTime() - date1.getTime()) / i < 1460 && 1095 <= (date2.getTime() - date1.getTime())) {
			return "大四";
		} else if ((date2.getTime() - date1.getTime()) / i < 1825 && 1460 <= (date2.getTime() - date1.getTime())) {
			return "大五";
		} else if ((date2.getTime() - date1.getTime()) < 0) {
			return "年级错误";
		}else{
			return "?";
		}
	}
}

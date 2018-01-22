package cn.vito.coding.check.utils;

import java.util.regex.Pattern;

/**
 * 格式验证
 * 
 * @author baijw
 * 
 * @date 2017年3月14日 上午11:08:35
 */
public class ValidaterUtil {

	public static Pattern telephonePattern = Pattern.compile("^1[0-9]{10}$");

	public static Pattern accountNumberPattern = Pattern.compile("^[A-Za-z0-9]{1,15}$");

	public static Pattern passWordPattern = Pattern.compile("^[A-Za-z0-9!.]{6,40}$");

	public static Pattern eMailPattern = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$");

	public static Pattern imagePattern = Pattern.compile("(?i).+?\\.(jpg|gif|bmp|png|jpeg|JPG|GIF|BMP|PNG|JPEG)");

	/**
	 * 判断手机号码的格式
	 * 
	 * @param telephone
	 * @return
	 */
	public static boolean checkTelephone(String telephone) {
		return telephone == null ? false : telephonePattern.matcher(telephone).matches();
	}

	/**
	 * 判断昵称的格式
	 * 
	 * @param nickname
	 * @return
	 */
	public static boolean checkAccountNumber(String accountNumber) {
		return accountNumber == null ? false : accountNumberPattern.matcher(accountNumber).matches();
	}

	/**
	 * 判断密码的格式
	 * 
	 * @param nickname
	 * @return
	 */
	public static boolean checkPassWord(String password) {
		return password == null ? false : passWordPattern.matcher(password).matches();
	}

	/**
	 * 判断邮箱的格式
	 * 
	 * @param eMail
	 * @return
	 */
	public static boolean checkEMail(String eMail) {
		return eMail == null ? false : eMailPattern.matcher(eMail).matches();
	}

	/**
	 * 判断上传的是否是图片
	 * 
	 * @param imageName
	 * @return
	 */
	public static boolean checkImage(String imageName) {
		return imageName == null ? false : imagePattern.matcher(imageName).matches();
	}

	/**
	 * 身高数据校验
	 * 
	 * @param height
	 * @return
	 */
	public static boolean checkHeight(Integer height) {
		return height <= 300 && height >= 50;
	}

	/**
	 * 体重数据校验
	 * 
	 * @param weight
	 * @return
	 */
	public static boolean checkWeight(Double weight) {
		return weight <= 150 && weight >= 25;
	}

	/**
	 * 肺活量数据校验
	 * 
	 * @param vital_capacity
	 * @return
	 */
	public static boolean checkVital_capacity(Integer vital_capacity) {
		return vital_capacity <= 9999 && vital_capacity >= 500;
	}

	/**
	 * 50m跑数据校验
	 * 
	 * @param fivem
	 * @return
	 */
	public static boolean checkFivem(Double fivem) {
		return fivem <= 15.0 && fivem >= 5.0;
	}

	/**
	 * 跳远数据校验
	 * 
	 * @param long_jump
	 * @return
	 */
	public static boolean checkLong_jump(Double long_jump) {
		return long_jump <= 300.0 && long_jump >= 80.0;
	}

	/**
	 * 坐位体前屈数据校验
	 * 
	 * @param reach
	 * @return
	 */
	public static boolean checkReach(Double reach) {
		return reach <= 50.0 && reach >= -50.0;
	}

	/**
	 * 800m和1000m跑数据校验
	 * 
	 * @param runningTime
	 * @return
	 */
	public static boolean checkRunningTime(String runningTime) {
		String[] strings = runningTime.split("'");
		int minute = Integer.parseInt(strings[0]);
		int second = Integer.parseInt(strings[1].substring(0, 2));
		return minute >= 2 && minute <= 10 && second <= 59;
	}

	/**
	 * 仰卧起坐数据校验
	 * 
	 * @param sit_ups
	 * @return
	 */
	public static boolean checkSit_ups(Integer sit_ups) {
		return sit_ups <= 80 && sit_ups >= 0;
	}

	/**
	 * 引体向上数据校验
	 * 
	 * @param pull_up
	 * @return
	 */
	public static boolean checkPull_up(Integer pull_up) {
		return pull_up <= 60 && pull_up >= 0;
	}

	public static void main(String[] args) {
		System.out.println(checkRunningTime("2'22\""));
	}
}

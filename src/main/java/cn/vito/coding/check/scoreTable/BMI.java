package cn.vito.coding.check.scoreTable;

import java.text.DecimalFormat;

/**
 * 身体指数
 * 
 * @author 刘晓庆
 *
 */
public class BMI {
	public static void main(String[] args) {
		String gender = "男";
		int height = 183;
		double weight = 80;
		System.out.println(BodyIndex(gender, height, weight));
	}

	public static int BodyIndex(String gender, int height, double weight) {
		DecimalFormat df = new DecimalFormat("#.#");
		double s = Math.pow(height, 2) / 10000;
		double index = Double.parseDouble(df.format(weight / s));
		if (gender.equals("男")) {
			if (index >= 28.0) {
				return 60;
			} else if (index >= 24.0 && index <= 27.9) {
				return 80;
			} else if (index >= 17.9 && index <= 23.9) {
				return 100;
			} else {
				return 80;
			}
		} else {
			if (index >= 28.0) {
				return 60;
			} else if (index >= 24.0 && index <= 27.9) {
				return 80;
			} else if (index >= 17.2 && index <= 23.9) {
				return 100;
			} else {
				return 80;
			}
		}
	}
}

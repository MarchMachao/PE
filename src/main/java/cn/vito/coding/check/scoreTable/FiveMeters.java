package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

public class FiveMeters {
	public static void main(String[] args) {
		int grade = 2015;
		double sitNum = 7.2;
		String gender = "男";
		System.out.println(five(gender, grade, sitNum));
	}

	public static int five(String gender, int grade, double sitNum) {
		if (gender.equals("女")) {
			return fiveGirl(grade, sitNum);
		} else {
			return fiveBoy(grade, sitNum);
		}
	}

	// 女生50m
	public static int fiveGirl(int grade, double sitNum) {
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum <= 7.5) {
				return 100;
			} else if (sitNum == 7.6) {
				return 95;
			} else if (sitNum == 7.7) {
				return 90;
			} else if (sitNum > 7.7 && sitNum <= 8.0) {
				return 85;
			} else if (sitNum > 8.0 && sitNum <= 8.3) {
				return 80;
			} else if (sitNum > 8.3 && sitNum <= 8.5) {
				return 78;
			} else if (sitNum > 8.5 && sitNum <= 8.7) {
				return 76;
			} else if (sitNum > 8.7 && sitNum <= 8.9) {
				return 74;
			} else if (sitNum > 8.9 && sitNum <= 9.1) {
				return 72;
			} else if (sitNum > 9.1 && sitNum <= 9.3) {
				return 70;
			} else if (sitNum > 9.3 && sitNum <= 9.5) {
				return 68;
			} else if (sitNum > 9.5 && sitNum <= 9.7) {
				return 66;
			} else if (sitNum > 9.7 && sitNum <= 9.9) {
				return 64;
			} else if (sitNum > 9.9 && sitNum <= 10.1) {
				return 62;
			} else if (sitNum > 10.1 && sitNum <= 10.3) {
				return 60;
			} else if (sitNum > 10.3 && sitNum <= 10.5) {
				return 50;
			} else if (sitNum > 10.5 && sitNum <= 10.7) {
				return 40;
			} else if (sitNum > 10.7 && sitNum <= 10.9) {
				return 30;
			} else if (sitNum > 10.9 && sitNum <= 11.1) {
				return 20;
			} else if (sitNum > 11.1 && sitNum <= 11.3) {
				return 10;
			} else {
				return 0;
			}
		} else {
			if (sitNum <= 7.4) {
				return 100;
			} else if (sitNum == 7.5) {
				return 95;
			} else if (sitNum == 7.6) {
				return 90;
			} else if (sitNum > 7.6 && sitNum <= 7.9) {
				return 85;
			} else if (sitNum > 7.9 && sitNum <= 8.2) {
				return 80;
			} else if (sitNum > 8.2 && sitNum <= 8.4) {
				return 78;
			} else if (sitNum > 8.4 && sitNum <= 8.6) {
				return 76;
			} else if (sitNum > 8.6 && sitNum <= 8.8) {
				return 74;
			} else if (sitNum > 8.8 && sitNum <= 9.0) {
				return 72;
			} else if (sitNum > 9.0 && sitNum <= 9.2) {
				return 70;
			} else if (sitNum > 9.2 && sitNum <= 9.4) {
				return 68;
			} else if (sitNum > 9.4 && sitNum <= 9.6) {
				return 66;
			} else if (sitNum > 9.6 && sitNum <= 9.8) {
				return 64;
			} else if (sitNum > 9.8 && sitNum <= 10.0) {
				return 62;
			} else if (sitNum > 10.0 && sitNum <= 10.2) {
				return 60;
			} else if (sitNum > 10.2 && sitNum <= 10.4) {
				return 50;
			} else if (sitNum > 10.4 && sitNum <= 10.6) {
				return 40;
			} else if (sitNum > 10.6 && sitNum <= 10.8) {
				return 30;
			} else if (sitNum > 10.8 && sitNum <= 11.0) {
				return 20;
			} else if (sitNum > 11.0 && sitNum <= 11.2) {
				return 10;
			} else {
				return 0;
			}
		}
	}

	// 男生50m
	public static int fiveBoy(int grade, double sitNum) {
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum <= 6.7) {
				return 100;
			} else if (sitNum == 6.8) {
				return 95;
			} else if (sitNum == 6.9) {
				return 90;
			} else if (sitNum == 7.0) {
				return 85;
			} else if (sitNum == 7.1) {
				return 80;
			} else if (sitNum > 7.1 && sitNum <= 7.3) {
				return 78;
			} else if (sitNum > 7.3 && sitNum <= 7.5) {
				return 76;
			} else if (sitNum > 7.5 && sitNum <= 7.7) {
				return 74;
			} else if (sitNum > 7.7 && sitNum <= 7.9) {
				return 72;
			} else if (sitNum > 7.9 && sitNum <= 8.1) {
				return 70;
			} else if (sitNum > 8.1 && sitNum <= 8.3) {
				return 68;
			} else if (sitNum > 8.3 && sitNum <= 8.5) {
				return 66;
			} else if (sitNum > 8.5 && sitNum <= 8.7) {
				return 64;
			} else if (sitNum > 8.7 && sitNum <= 8.9) {
				return 62;
			} else if (sitNum > 8.9 && sitNum <= 9.1) {
				return 60;
			} else if (sitNum > 9.1 && sitNum <= 9.3) {
				return 50;
			} else if (sitNum > 9.3 && sitNum <= 9.5) {
				return 40;
			} else if (sitNum > 9.5 && sitNum <= 9.7) {
				return 30;
			} else if (sitNum > 9.7 && sitNum <= 9.9) {
				return 20;
			} else if (sitNum > 9.9 && sitNum <= 10.1) {
				return 10;
			} else {
				return 0;
			}
		} else {
			if (sitNum <= 6.6) {
				return 100;
			} else if (sitNum == 6.7) {
				return 95;
			} else if (sitNum == 6.8) {
				return 90;
			} else if (sitNum == 6.9) {
				return 85;
			} else if (sitNum == 7.0) {
				return 80;
			} else if (sitNum > 7.0 && sitNum <= 7.2) {
				return 78;
			} else if (sitNum > 7.2 && sitNum <= 7.4) {
				return 76;
			} else if (sitNum > 7.4 && sitNum <= 7.6) {
				return 74;
			} else if (sitNum > 7.6 && sitNum <= 7.8) {
				return 72;
			} else if (sitNum > 7.8 && sitNum <= 8.0) {
				return 70;
			} else if (sitNum > 8.0 && sitNum <= 8.2) {
				return 68;
			} else if (sitNum > 8.2 && sitNum <= 8.4) {
				return 66;
			} else if (sitNum > 8.4 && sitNum <= 8.6) {
				return 64;
			} else if (sitNum > 8.6 && sitNum <= 8.8) {
				return 62;
			} else if (sitNum > 8.8 && sitNum <= 9.0) {
				return 60;
			} else if (sitNum > 9.0 && sitNum <= 9.2) {
				return 50;
			} else if (sitNum > 9.2 && sitNum <= 9.4) {
				return 40;
			} else if (sitNum > 9.4 && sitNum <= 9.6) {
				return 30;
			} else if (sitNum > 9.6 && sitNum <= 9.8) {
				return 20;
			} else if (sitNum > 9.8 && sitNum <= 10.0) {
				return 10;
			} else {
				return 0;
			}
		}
	}
}

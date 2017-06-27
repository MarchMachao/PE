package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

public class SitUps {
	public static void main(String[] args) {
		int grade = 2015;
		int sitNum = 35;
		System.out.println(sitUp(grade, sitNum));
	}

	// 女生仰卧起坐
	public static int sitUp(int grade, int sitNum) {
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum < 16) {
				return 0;
			} else if (sitNum >= 16 && sitNum < 18) {
				return 10;
			} else if (sitNum >= 18 && sitNum < 20) {
				return 20;
			} else if (sitNum >= 20 && sitNum < 22) {
				return 30;
			} else if (sitNum >= 22 && sitNum < 24) {
				return 40;
			} else if (sitNum >= 24 && sitNum < 26) {
				return 50;
			} else if (sitNum >= 26 && sitNum < 28) {
				return 60;
			} else if (sitNum >= 28 && sitNum < 30) {
				return 62;
			} else if (sitNum >= 30 && sitNum < 32) {
				return 64;
			} else if (sitNum >= 32 && sitNum < 34) {
				return 66;
			} else if (sitNum >= 34 && sitNum < 36) {
				return 68;
			} else if (sitNum >= 36 && sitNum < 38) {
				return 70;
			} else if (sitNum >= 38 && sitNum < 40) {
				return 72;
			} else if (sitNum >= 40 && sitNum < 42) {
				return 74;
			} else if (sitNum >= 42 && sitNum < 44) {
				return 76;
			} else if (sitNum >= 44 && sitNum < 46) {
				return 78;
			} else if (sitNum >= 46 && sitNum < 49) {
				return 80;
			} else if (sitNum >= 49 && sitNum < 52) {
				return 85;
			} else if (sitNum >= 52 && sitNum < 54) {
				return 90;
			} else if (sitNum >= 54 && sitNum < 56) {
				return 95;
			} else {
				return 100;
			}
		} else {
			if (sitNum < 17) {
				return 0;
			} else if (sitNum >= 17 && sitNum < 19) {
				return 10;
			} else if (sitNum >= 19 && sitNum < 21) {
				return 20;
			} else if (sitNum >= 21 && sitNum < 23) {
				return 30;
			} else if (sitNum >= 23 && sitNum < 25) {
				return 40;
			} else if (sitNum >= 25 && sitNum < 27) {
				return 50;
			} else if (sitNum >= 27 && sitNum < 29) {
				return 60;
			} else if (sitNum >= 29 && sitNum < 31) {
				return 62;
			} else if (sitNum >= 31 && sitNum < 33) {
				return 64;
			} else if (sitNum >= 33 && sitNum < 35) {
				return 66;
			} else if (sitNum >= 35 && sitNum < 37) {
				return 68;
			} else if (sitNum >= 37 && sitNum < 39) {
				return 70;
			} else if (sitNum >= 39 && sitNum < 41) {
				return 72;
			} else if (sitNum >= 41 && sitNum < 43) {
				return 74;
			} else if (sitNum >= 43 && sitNum < 45) {
				return 76;
			} else if (sitNum >= 45 && sitNum < 47) {
				return 78;
			} else if (sitNum >= 47 && sitNum < 50) {
				return 80;
			} else if (sitNum >= 50 && sitNum < 53) {
				return 85;
			} else if (sitNum >= 53 && sitNum < 55) {
				return 90;
			} else if (sitNum >= 55 && sitNum < 57) {
				return 95;
			} else {
				return 100;
			}
		}
	}
}

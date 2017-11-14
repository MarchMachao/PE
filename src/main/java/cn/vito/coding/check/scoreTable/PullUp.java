package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

public class PullUp {
	public static void main(String[] args) {
		int grade = 2014;
		int sitNum = 28;
		System.out.println(pull(grade, sitNum));
	}

	// 男生引体向上
	public static int pull(int grade, int sitNum) {
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum < 5) {
				return 0;
			} else if (sitNum == 5) {
				return 10;
			} else if (sitNum == 6) {
				return 20;
			} else if (sitNum == 7) {
				return 30;
			} else if (sitNum == 8) {
				return 40;
			} else if (sitNum == 9) {
				return 50;
			} else if (sitNum == 10) {
				return 60;
			} else if (sitNum == 11) {
				return 64;
			} else if (sitNum == 12) {
				return 68;
			} else if (sitNum == 13) {
				return 72;
			} else if (sitNum == 14) {
				return 76;
			} else if (sitNum == 15) {
				return 80;
			} else if (sitNum == 16) {
				return 85;
			} else if (sitNum == 17) {
				return 90;
			} else if (sitNum == 18) {
				return 95;
			} else {
				return 100;
			}

		} else {
			if (sitNum < 6) {
				return 0;
			} else if (sitNum == 6) {
				return 10;
			} else if (sitNum == 7) {
				return 20;
			} else if (sitNum == 8) {
				return 30;
			} else if (sitNum == 9) {
				return 40;
			} else if (sitNum == 10) {
				return 50;
			} else if (sitNum == 11) {
				return 60;
			} else if (sitNum == 12) {
				return 64;
			} else if (sitNum == 13) {
				return 68;
			} else if (sitNum == 14) {
				return 72;
			} else if (sitNum == 15) {
				return 76;
			} else if (sitNum == 16) {
				return 80;
			} else if (sitNum == 17) {
				return 85;
			} else if (sitNum == 18) {
				return 90;
			} else if (sitNum == 19) {
				return 95;
			} else {
				return 100;
			}
		}
	}
}

package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

public class TenMeters {
	public static void main(String[] args) {
		String string = "3'78";
		int grade = 2015;
		System.out.println(fiveGirl(grade, string));
	}

	// 男生1000m
	public static int fiveGirl(int grade, String eight) {
		int sitNum = StringUtils.timeToInt(eight);
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum <= 317) {
				return 100;
			} else if (sitNum > 317 && sitNum <= 322) {
				return 95;
			} else if (sitNum > 322 && sitNum <= 327) {
				return 90;
			} else if (sitNum > 327 && sitNum <= 334) {
				return 85;
			} else if (sitNum > 334 && sitNum <= 342) {
				return 80;
			} else if (sitNum > 342 && sitNum <= 347) {
				return 78;
			} else if (sitNum > 347 && sitNum <= 352) {
				return 76;
			} else if (sitNum > 352 && sitNum <= 357) {
				return 74;
			} else if (sitNum > 357 && sitNum <= 402) {
				return 72;
			} else if (sitNum > 402 && sitNum <= 407) {
				return 70;
			} else if (sitNum > 407 && sitNum <= 412) {
				return 68;
			} else if (sitNum > 412 && sitNum <= 417) {
				return 66;
			} else if (sitNum > 417 && sitNum <= 422) {
				return 64;
			} else if (sitNum > 422 && sitNum <= 427) {
				return 62;
			} else if (sitNum > 427 && sitNum <= 432) {
				return 60;
			} else if (sitNum > 432 && sitNum <= 452) {
				return 50;
			} else if (sitNum > 452 && sitNum <= 512) {
				return 40;
			} else if (sitNum > 512 && sitNum <= 532) {
				return 30;
			} else if (sitNum > 532 && sitNum <= 552) {
				return 20;
			} else if (sitNum > 552 && sitNum <= 612) {
				return 10;
			} else {
				return 0;
			}
		} else {
			if (sitNum <= 315) {
				return 100;
			} else if (sitNum > 315 && sitNum <= 320) {
				return 95;
			} else if (sitNum > 320 && sitNum <= 325) {
				return 90;
			} else if (sitNum > 325 && sitNum <= 332) {
				return 85;
			} else if (sitNum > 332 && sitNum <= 340) {
				return 80;
			} else if (sitNum > 340 && sitNum <= 345) {
				return 78;
			} else if (sitNum > 345 && sitNum <= 350) {
				return 76;
			} else if (sitNum > 350 && sitNum <= 355) {
				return 74;
			} else if (sitNum > 355 && sitNum <= 400) {
				return 72;
			} else if (sitNum > 400 && sitNum <= 405) {
				return 70;
			} else if (sitNum > 405 && sitNum <= 410) {
				return 68;
			} else if (sitNum > 410 && sitNum <= 415) {
				return 66;
			} else if (sitNum > 415 && sitNum <= 420) {
				return 64;
			} else if (sitNum > 420 && sitNum <= 425) {
				return 62;
			} else if (sitNum > 425 && sitNum <= 430) {
				return 60;
			} else if (sitNum > 430 && sitNum <= 450) {
				return 50;
			} else if (sitNum > 450 && sitNum <= 510) {
				return 40;
			} else if (sitNum > 510 && sitNum <= 530) {
				return 30;
			} else if (sitNum > 530 && sitNum <= 550) {
				return 20;
			} else if (sitNum > 550 && sitNum <= 610) {
				return 10;
			} else {
				return 0;
			}
		}
	}
}

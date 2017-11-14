package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

public class EightMeters {
	public static void main(String[] args) {
		String string = "";
		int grade = 2015;
		System.out.println(eightGirl(grade, string));
	}

	// 女生800m
	public static int eightGirl(int grade, String eightm) {
		int sitNum = StringUtils.timeToInt(eightm);
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum <= 318) {
				return 100;
			} else if (sitNum > 318 && sitNum <= 324) {
				return 95;
			} else if (sitNum > 324 && sitNum <= 330) {
				return 90;
			} else if (sitNum > 330 && sitNum <= 337) {
				return 85;
			} else if (sitNum > 337 && sitNum <= 344) {
				return 80;
			} else if (sitNum > 344 && sitNum <= 349) {
				return 78;
			} else if (sitNum > 349 && sitNum <= 354) {
				return 76;
			} else if (sitNum > 354 && sitNum <= 359) {
				return 74;
			} else if (sitNum > 359 && sitNum <= 404) {
				return 72;
			} else if (sitNum > 404 && sitNum <= 409) {
				return 70;
			} else if (sitNum > 409 && sitNum <= 414) {
				return 68;
			} else if (sitNum > 414 && sitNum <= 419) {
				return 66;
			} else if (sitNum > 419 && sitNum <= 424) {
				return 64;
			} else if (sitNum > 424 && sitNum <= 429) {
				return 62;
			} else if (sitNum > 429 && sitNum <= 434) {
				return 60;
			} else if (sitNum > 434 && sitNum <= 444) {
				return 50;
			} else if (sitNum > 444 && sitNum <= 454) {
				return 40;
			} else if (sitNum > 454 && sitNum <= 504) {
				return 30;
			} else if (sitNum > 504 && sitNum <= 514) {
				return 20;
			} else if (sitNum > 514 && sitNum <= 524) {
				return 10;
			} else {
				return 0;
			}
		} else {
			if (sitNum <= 316) {
				return 100;
			} else if (sitNum > 316 && sitNum <= 322) {
				return 95;
			} else if (sitNum > 322 && sitNum <= 328) {
				return 90;
			} else if (sitNum > 328 && sitNum <= 335) {
				return 85;
			} else if (sitNum > 335 && sitNum <= 342) {
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
			} else if (sitNum > 432 && sitNum <= 442) {
				return 50;
			} else if (sitNum > 442 && sitNum <= 452) {
				return 40;
			} else if (sitNum > 452 && sitNum <= 502) {
				return 30;
			} else if (sitNum > 502 && sitNum <= 512) {
				return 20;
			} else if (sitNum > 512 && sitNum <= 522) {
				return 10;
			} else {
				return 0;
			}
		}
	}
}

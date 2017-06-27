package cn.vito.coding.check.scoreTable;

public class SitUps {
	public static void main(String[] args) {
		String gender = "男";
		String grade = "大二";
		int sitNum = 0;
		System.out.println(sitUp(gender, grade, sitNum));
	}

	public static int sitUp(String gender, String grade, int sitNum) {
		if (gender.equals("男")) {
			if ("大一大二".contains(grade)) {
				if (sitNum < 16) {
					return 0;
				} else if (sitNum >= 16 && sitNum < 18) {
					return 10;
				}else if (sitNum >= 18 && sitNum < 20) {
					return 20;
				}else if (sitNum >= 20 && sitNum < 22) {
					return 30;
				}else if (sitNum >= 22 && sitNum < 24) {
					return 40;
				}else if (sitNum >= 24 && sitNum < 26) {
					return 50;
				}else if (sitNum >= 26 && sitNum < 28) {
					return 60;
				}else if (sitNum >= 28 && sitNum < 30) {
					return 70;
				}else if (sitNum >= 30 && sitNum < 32) {
					return 80;
				}else if (sitNum >= 16 && sitNum < 18) {
					return 90;
				}else {
					return 100;
				}
			} else {

			}
		}
		return 0;
	}
}

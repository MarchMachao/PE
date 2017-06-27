package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

/**
 * 坐位体前屈成绩计算
 * 
 * @author March
 *
 */
public class Reach {

	public static int reaches(String gender, int grade, double reach) {
		String g = StringUtils.gradeIntToString(grade);
		if (gender.equals("男")) {
			if ("大一大二".contains(g)) {
				if (reach >= 24.9) {
					return 100;
				} else if (reach >= 23.1 && reach < 24.9) {
					return 95;
				} else if (reach >= 21.3 && reach < 23.1) {
					return 90;
				} else if (reach >= 19.5 && reach < 21.3) {
					return 85;
				} else if (reach >= 17.7 && reach < 19.5) {
					return 80;
				} else if (reach >= 16.3 && reach < 17.7) {
					return 78;
				} else if (reach >= 14.9 && reach < 16.3) {
					return 76;
				} else if (reach >= 13.5 && reach < 14.9) {
					return 74;
				} else if (reach >= 12.1 && reach < 13.5) {
					return 72;
				} else if (reach >= 10.7 && reach < 12.1) {
					return 70;
				} else if (reach >= 9.3 && reach < 10.7) {
					return 68;
				} else if (reach >= 7.9 && reach < 9.3) {
					return 66;
				} else if (reach >= 6.5 && reach < 7.9) {
					return 64;
				} else if (reach >= 5.1 && reach < 6.5) {
					return 62;
				} else if (reach >= 3.7 && reach < 5.1) {
					return 60;
				} else if (reach >= 2.7 && reach < 3.7) {
					return 50;
				} else if (reach >= 1.7 && reach < 2.7) {
					return 40;
				} else if (reach >= 0.7 && reach < 1.7) {
					return 30;
				} else if (reach >= -0.3 && reach < 0.7) {
					return 20;
				} else {
					return 10;
				}
			} else {
				if (reach >= 25.1) {
					return 100;
				} else if (reach >= 23.3 && reach < 25.1) {
					return 95;
				} else if (reach >= 21.5 && reach < 23.3) {
					return 90;
				} else if (reach >= 19.9 && reach < 21.5) {
					return 85;
				} else if (reach >= 18.2 && reach < 19.9) {
					return 80;
				} else if (reach >= 16.8 && reach < 18.2) {
					return 78;
				} else if (reach >= 15.4 && reach < 16.8) {
					return 76;
				} else if (reach >= 14.0 && reach < 15.4) {
					return 74;
				} else if (reach >= 12.6 && reach < 14.0) {
					return 72;
				} else if (reach >= 11.2 && reach < 12.6) {
					return 70;
				} else if (reach >= 9.8 && reach < 11.2) {
					return 68;
				} else if (reach >= 8.4 && reach < 9.8) {
					return 66;
				} else if (reach >= 7.0 && reach < 8.4) {
					return 64;
				} else if (reach >= 5.6 && reach < 7.0) {
					return 62;
				} else if (reach >= 4.2 && reach < 5.6) {
					return 60;
				} else if (reach >= 3.2 && reach < 4.2) {
					return 50;
				} else if (reach >= 2.2 && reach < 3.2) {
					return 40;
				} else if (reach >= 1.2 && reach < 2.2) {
					return 30;
				} else if (reach >= 0.2 && reach < 1.2) {
					return 20;
				} else {
					return 10;
				}
			}
		} else {
			if ("大一大二".contains(g)) {
				if (reach >= 25.8) {
					return 100;
				} else if (reach >= 24.0 && reach < 25.8) {
					return 95;
				} else if (reach >= 22.2 && reach < 24.0) {
					return 90;
				} else if (reach >= 20.6 && reach < 22.2) {
					return 85;
				} else if (reach >= 19.0 && reach < 20.6) {
					return 80;
				} else if (reach >= 17.7 && reach < 19.0) {
					return 78;
				} else if (reach >= 16.4 && reach < 17.7) {
					return 76;
				} else if (reach >= 15.1 && reach < 16.4) {
					return 74;
				} else if (reach >= 13.8 && reach < 15.1) {
					return 72;
				} else if (reach >= 12.5 && reach < 13.8) {
					return 70;
				} else if (reach >= 11.2 && reach < 12.5) {
					return 68;
				} else if (reach >= 9.9 && reach < 11.2) {
					return 66;
				} else if (reach >= 8.6 && reach < 9.9) {
					return 64;
				} else if (reach >= 7.3 && reach < 8.6) {
					return 62;
				} else if (reach >= 6.0 && reach < 7.3) {
					return 60;
				} else if (reach >= 5.2 && reach < 6.0) {
					return 50;
				} else if (reach >= 4.4 && reach < 5.2) {
					return 40;
				} else if (reach >= 3.6 && reach < 4.4) {
					return 30;
				} else if (reach >= 2.8 && reach < 3.6) {
					return 20;
				} else {
					return 10;
				}
			} else {
				if (reach >= 26.3) {
					return 100;
				} else if (reach >= 24.4 && reach < 26.3) {
					return 95;
				} else if (reach >= 22.4 && reach < 24.4) {
					return 90;
				} else if (reach >= 21.0 && reach < 22.4) {
					return 85;
				} else if (reach >= 19.5 && reach < 21.0) {
					return 80;
				} else if (reach >= 18.2 && reach < 19.5) {
					return 78;
				} else if (reach >= 16.9 && reach < 18.2) {
					return 76;
				} else if (reach >= 15.6 && reach < 16.9) {
					return 74;
				} else if (reach >= 14.3 && reach < 15.6) {
					return 72;
				} else if (reach >= 13.0 && reach < 14.3) {
					return 70;
				} else if (reach >= 11.7 && reach < 13.0) {
					return 68;
				} else if (reach >= 10.4 && reach < 11.7) {
					return 66;
				} else if (reach >= 9.1 && reach < 10.4) {
					return 64;
				} else if (reach >= 7.8 && reach < 9.1) {
					return 62;
				} else if (reach >= 6.5 && reach < 7.8) {
					return 60;
				} else if (reach >= 5.7 && reach < 6.5) {
					return 50;
				} else if (reach >= 4.9 && reach < 5.7) {
					return 40;
				} else if (reach >= 4.1 && reach < 4.9) {
					return 30;
				} else if (reach >= 3.3 && reach < 4.1) {
					return 20;
				} else {
					return 10;
				}
			}

		}
	}

}

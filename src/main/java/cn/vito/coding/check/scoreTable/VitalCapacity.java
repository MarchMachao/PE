package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

/**
 * 肺活量成绩计算
 * 
 * @author March
 *
 */
public class VitalCapacity {

	public static int vitalCapacity(String gender, int grade, int vital_capacity) {
		String g = StringUtils.gradeIntToString(grade);
		if (gender.equals("男")) {
			if ("大一大二".contains(g)) {
				if (vital_capacity >= 5040) {
					return 100;
				} else if (vital_capacity >= 4920 && vital_capacity < 5040) {
					return 95;
				} else if (vital_capacity >= 4800 && vital_capacity < 4920) {
					return 90;
				} else if (vital_capacity >= 4550 && vital_capacity < 4800) {
					return 85;
				} else if (vital_capacity >= 4300 && vital_capacity < 4550) {
					return 80;
				} else if (vital_capacity >= 4180 && vital_capacity < 4300) {
					return 78;
				} else if (vital_capacity >= 4060 && vital_capacity < 4180) {
					return 76;
				} else if (vital_capacity >= 3940 && vital_capacity < 4060) {
					return 74;
				} else if (vital_capacity >= 3820 && vital_capacity < 3940) {
					return 72;
				} else if (vital_capacity >= 3700 && vital_capacity < 3820) {
					return 70;
				} else if (vital_capacity >= 3580 && vital_capacity < 3700) {
					return 68;
				} else if (vital_capacity >= 3460 && vital_capacity < 3580) {
					return 66;
				} else if (vital_capacity >= 3340 && vital_capacity < 3460) {
					return 64;
				} else if (vital_capacity >= 3220 && vital_capacity < 3340) {
					return 62;
				} else if (vital_capacity >= 3100 && vital_capacity < 3220) {
					return 60;
				} else if (vital_capacity >= 2940 && vital_capacity < 3100) {
					return 50;
				} else if (vital_capacity >= 2780 && vital_capacity < 2940) {
					return 40;
				} else if (vital_capacity >= 2620 && vital_capacity < 2780) {
					return 30;
				} else if (vital_capacity >= 2460 && vital_capacity < 2620) {
					return 20;
				} else if (vital_capacity >= 2300 && vital_capacity < 2460){
					return 10;
				}else {
					return 0;
				}
			} else {
				if (vital_capacity >= 5140) {
					return 100;
				} else if (vital_capacity >= 5020 && vital_capacity < 5140) {
					return 95;
				} else if (vital_capacity >= 4900 && vital_capacity < 5020) {
					return 90;
				} else if (vital_capacity >= 4650 && vital_capacity < 4900) {
					return 85;
				} else if (vital_capacity >= 4400 && vital_capacity < 4650) {
					return 80;
				} else if (vital_capacity >= 4280 && vital_capacity < 4400) {
					return 78;
				} else if (vital_capacity >= 4160 && vital_capacity < 4280) {
					return 76;
				} else if (vital_capacity >= 4040 && vital_capacity < 4160) {
					return 74;
				} else if (vital_capacity >= 3920 && vital_capacity < 4040) {
					return 72;
				} else if (vital_capacity >= 3800 && vital_capacity < 3920) {
					return 70;
				} else if (vital_capacity >= 3680 && vital_capacity < 3800) {
					return 68;
				} else if (vital_capacity >= 3560 && vital_capacity < 3680) {
					return 66;
				} else if (vital_capacity >= 3440 && vital_capacity < 3560) {
					return 64;
				} else if (vital_capacity >= 3320 && vital_capacity < 3440) {
					return 62;
				} else if (vital_capacity >= 3200 && vital_capacity < 3320) {
					return 60;
				} else if (vital_capacity >= 3030 && vital_capacity < 3200) {
					return 50;
				} else if (vital_capacity >= 2860 && vital_capacity < 3030) {
					return 40;
				} else if (vital_capacity >= 2690 && vital_capacity < 2860) {
					return 30;
				} else if (vital_capacity >= 2520 && vital_capacity < 2690) {
					return 20;
				} else if (vital_capacity >= 2350 && vital_capacity < 2520){
					return 10;
				}else {
					return 0;
				}
			}
		} else {
			if ("大一大二".contains(g)) {
				if (vital_capacity >= 3400) {
					return 100;
				} else if (vital_capacity >= 3350 && vital_capacity < 3400) {
					return 95;
				} else if (vital_capacity >= 3300 && vital_capacity < 3350) {
					return 90;
				} else if (vital_capacity >= 3150 && vital_capacity < 3300) {
					return 85;
				} else if (vital_capacity >= 3000 && vital_capacity < 3150) {
					return 80;
				} else if (vital_capacity >= 2900 && vital_capacity < 3000) {
					return 78;
				} else if (vital_capacity >= 2800 && vital_capacity < 2900) {
					return 76;
				} else if (vital_capacity >= 2700 && vital_capacity < 2800) {
					return 74;
				} else if (vital_capacity >= 2600 && vital_capacity < 2700) {
					return 72;
				} else if (vital_capacity >= 2500 && vital_capacity < 2600) {
					return 70;
				} else if (vital_capacity >= 2400 && vital_capacity < 2500) {
					return 68;
				} else if (vital_capacity >= 2300 && vital_capacity < 2400) {
					return 66;
				} else if (vital_capacity >= 2200 && vital_capacity < 2300) {
					return 64;
				} else if (vital_capacity >= 2100 && vital_capacity < 2200) {
					return 62;
				} else if (vital_capacity >= 2000 && vital_capacity < 2100) {
					return 60;
				} else if (vital_capacity >= 1960 && vital_capacity < 2000) {
					return 50;
				} else if (vital_capacity >= 1920 && vital_capacity < 1960) {
					return 40;
				} else if (vital_capacity >= 1880 && vital_capacity < 1920) {
					return 30;
				} else if (vital_capacity >= 1840 && vital_capacity < 1880) {
					return 20;
				} else if (vital_capacity >= 1800 && vital_capacity < 1840){
					return 10;
				}else {
					return 0;
				}
			} else {
				if (vital_capacity >= 3450) {
					return 100;
				} else if (vital_capacity >= 3400 && vital_capacity < 3450) {
					return 95;
				} else if (vital_capacity >= 3350 && vital_capacity < 3400) {
					return 90;
				} else if (vital_capacity >= 3200 && vital_capacity < 3350) {
					return 85;
				} else if (vital_capacity >= 3050 && vital_capacity < 3200) {
					return 80;
				} else if (vital_capacity >= 2950 && vital_capacity < 3050) {
					return 78;
				} else if (vital_capacity >= 2850 && vital_capacity < 2950) {
					return 76;
				} else if (vital_capacity >= 2750 && vital_capacity < 2850) {
					return 74;
				} else if (vital_capacity >= 2650 && vital_capacity < 2750) {
					return 72;
				} else if (vital_capacity >= 2550 && vital_capacity < 2650) {
					return 70;
				} else if (vital_capacity >= 2450 && vital_capacity < 2550) {
					return 68;
				} else if (vital_capacity >= 2350 && vital_capacity < 2450) {
					return 66;
				} else if (vital_capacity >= 2250 && vital_capacity < 2350) {
					return 64;
				} else if (vital_capacity >= 2150 && vital_capacity < 2250) {
					return 62;
				} else if (vital_capacity >= 2050 && vital_capacity < 2150) {
					return 60;
				} else if (vital_capacity >= 2010 && vital_capacity < 2050) {
					return 50;
				} else if (vital_capacity >= 1970 && vital_capacity < 2010) {
					return 40;
				} else if (vital_capacity >= 1930 && vital_capacity < 1970) {
					return 30;
				} else if (vital_capacity >= 1890 && vital_capacity < 1930) {
					return 20;
				} else if (vital_capacity >= 1850 && vital_capacity < 1890){
					return 10;
				}else {
					return 0;
				}
			}
		}
	}

}

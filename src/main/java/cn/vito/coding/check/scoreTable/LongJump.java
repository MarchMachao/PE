package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

public class LongJump {
	public static void main(String[] args) {
		int grade = 2014;
		int sitNum = 28;
		System.out.println(jumpGirl(grade, sitNum));
	}

	// 女生立定跳远
	public static int jumpGirl(int grade, int sitNum) {
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum < 126) {
				return 0;
			} else if (sitNum >= 126 && sitNum < 131) {
				return 10;
			} else if (sitNum >= 131 && sitNum < 136) {
				return 20;
			} else if (sitNum >= 136 && sitNum < 141) {
				return 30;
			} else if (sitNum >= 141 && sitNum < 146) {
				return 40;
			} else if (sitNum >= 146 && sitNum < 151) {
				return 50;
			} else if (sitNum >= 151 && sitNum < 154) {
				return 60;
			} else if (sitNum >= 154 && sitNum < 157) {
				return 62;
			} else if (sitNum >= 157 && sitNum < 160) {
				return 64;
			} else if (sitNum >= 160 && sitNum < 163) {
				return 66;
			} else if (sitNum >= 163 && sitNum < 166) {
				return 68;
			} else if (sitNum >= 166 && sitNum < 169) {
				return 70;
			} else if (sitNum >= 169 && sitNum < 172) {
				return 72;
			} else if (sitNum >= 172 && sitNum < 175) {
				return 74;
			} else if (sitNum >= 175 && sitNum < 178) {
				return 76;
			} else if (sitNum >= 178 && sitNum < 181) {
				return 78;
			} else if (sitNum >= 181 && sitNum < 188) {
				return 80;
			} else if (sitNum >= 188 && sitNum < 195) {
				return 85;
			} else if (sitNum >= 195 && sitNum < 201) {
				return 90;
			} else if (sitNum >= 201 && sitNum < 207) {
				return 95;
			} else {
				return 100;
			}
		}else {
			if (sitNum < 127) {
				return 0;
			} else if (sitNum >= 127 && sitNum < 132) {
				return 10;
			} else if (sitNum >= 132 && sitNum < 137) {
				return 20;
			} else if (sitNum >= 137 && sitNum < 142) {
				return 30;
			} else if (sitNum >= 142 && sitNum < 147) {
				return 40;
			} else if (sitNum >= 147 && sitNum < 152) {
				return 50;
			} else if (sitNum >= 152 && sitNum < 155) {
				return 60;
			} else if (sitNum >= 155 && sitNum < 158) {
				return 62;
			} else if (sitNum >= 158 && sitNum < 161) {
				return 64;
			} else if (sitNum >= 161 && sitNum < 162) {
				return 66;
			} else if (sitNum >= 162 && sitNum < 167) {
				return 68;
			} else if (sitNum >= 167 && sitNum < 170) {
				return 70;
			} else if (sitNum >= 170 && sitNum < 173) {
				return 72;
			} else if (sitNum >= 173 && sitNum < 176) {
				return 74;
			} else if (sitNum >= 176 && sitNum < 179) {
				return 76;
			} else if (sitNum >= 179 && sitNum < 182) {
				return 78;
			} else if (sitNum >= 182 && sitNum < 189) {
				return 80;
			} else if (sitNum >= 189 && sitNum < 196) {
				return 85;
			} else if (sitNum >= 196 && sitNum < 202) {
				return 90;
			} else if (sitNum >= 202 && sitNum < 208) {
				return 95;
			} else {
				return 100;
			}
		}
	}
	// 女生立定跳远
		public static int jumpBoy(int grade, int sitNum) {
			String g = StringUtils.gradeIntToString(grade);
			if ("大一大二".contains(g)) {
				if (sitNum < 126) {
					return 0;
				} else if (sitNum >= 126 && sitNum < 131) {
					return 10;
				} else if (sitNum >= 131 && sitNum < 136) {
					return 20;
				} else if (sitNum >= 136 && sitNum < 141) {
					return 30;
				} else if (sitNum >= 141 && sitNum < 146) {
					return 40;
				} else if (sitNum >= 146 && sitNum < 151) {
					return 50;
				} else if (sitNum >= 151 && sitNum < 154) {
					return 60;
				} else if (sitNum >= 154 && sitNum < 157) {
					return 62;
				} else if (sitNum >= 157 && sitNum < 160) {
					return 64;
				} else if (sitNum >= 160 && sitNum < 163) {
					return 66;
				} else if (sitNum >= 163 && sitNum < 166) {
					return 68;
				} else if (sitNum >= 166 && sitNum < 169) {
					return 70;
				} else if (sitNum >= 169 && sitNum < 172) {
					return 72;
				} else if (sitNum >= 172 && sitNum < 175) {
					return 74;
				} else if (sitNum >= 175 && sitNum < 178) {
					return 76;
				} else if (sitNum >= 178 && sitNum < 181) {
					return 78;
				} else if (sitNum >= 181 && sitNum < 188) {
					return 80;
				} else if (sitNum >= 188 && sitNum < 195) {
					return 85;
				} else if (sitNum >= 195 && sitNum < 201) {
					return 90;
				} else if (sitNum >= 201 && sitNum < 207) {
					return 95;
				} else {
					return 100;
				}
			}else {
				if (sitNum < 127) {
					return 0;
				} else if (sitNum >= 127 && sitNum < 132) {
					return 10;
				} else if (sitNum >= 132 && sitNum < 137) {
					return 20;
				} else if (sitNum >= 137 && sitNum < 142) {
					return 30;
				} else if (sitNum >= 142 && sitNum < 147) {
					return 40;
				} else if (sitNum >= 147 && sitNum < 152) {
					return 50;
				} else if (sitNum >= 152 && sitNum < 155) {
					return 60;
				} else if (sitNum >= 155 && sitNum < 158) {
					return 62;
				} else if (sitNum >= 158 && sitNum < 161) {
					return 64;
				} else if (sitNum >= 161 && sitNum < 162) {
					return 66;
				} else if (sitNum >= 162 && sitNum < 167) {
					return 68;
				} else if (sitNum >= 167 && sitNum < 170) {
					return 70;
				} else if (sitNum >= 170 && sitNum < 173) {
					return 72;
				} else if (sitNum >= 173 && sitNum < 176) {
					return 74;
				} else if (sitNum >= 176 && sitNum < 179) {
					return 76;
				} else if (sitNum >= 179 && sitNum < 182) {
					return 78;
				} else if (sitNum >= 182 && sitNum < 189) {
					return 80;
				} else if (sitNum >= 189 && sitNum < 196) {
					return 85;
				} else if (sitNum >= 196 && sitNum < 202) {
					return 90;
				} else if (sitNum >= 202 && sitNum < 208) {
					return 95;
				} else {
					return 100;
				}
			}
		}
}

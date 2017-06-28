package cn.vito.coding.check.scoreTable;

import cn.vito.coding.check.utils.StringUtils;

public class LongJump {
	public static void main(String[] args) {
		int grade = 2015;
		double sitNum = 256;
		String gender = "男";
		System.out.println(jump(gender, grade, sitNum));
	}

	public static int jump(String gender, int grade, double long_jump) {
		if (gender.equals("女")) {
			return jumpGirl(grade, long_jump);
		} else {
			return jumpBoy(grade, long_jump);
		}
	}

	// 女生立定跳远
	public static int jumpGirl(int grade, double sitNum) {
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
		} else {
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

	// 男生立定跳远
	public static int jumpBoy(int grade, double sitNum) {
		String g = StringUtils.gradeIntToString(grade);
		if ("大一大二".contains(g)) {
			if (sitNum < 183) {
				return 0;
			} else if (sitNum >= 183 && sitNum < 188) {
				return 10;
			} else if (sitNum >= 188 && sitNum < 193) {
				return 20;
			} else if (sitNum >= 193 && sitNum < 198) {
				return 30;
			} else if (sitNum >= 198 && sitNum < 203) {
				return 40;
			} else if (sitNum >= 203 && sitNum < 208) {
				return 50;
			} else if (sitNum >= 208 && sitNum < 212) {
				return 60;
			} else if (sitNum >= 212 && sitNum < 216) {
				return 62;
			} else if (sitNum >= 216 && sitNum < 220) {
				return 64;
			} else if (sitNum >= 220 && sitNum < 224) {
				return 66;
			} else if (sitNum >= 224 && sitNum < 228) {
				return 68;
			} else if (sitNum >= 228 && sitNum < 232) {
				return 70;
			} else if (sitNum >= 232 && sitNum < 236) {
				return 72;
			} else if (sitNum >= 236 && sitNum < 240) {
				return 74;
			} else if (sitNum >= 240 && sitNum < 244) {
				return 76;
			} else if (sitNum >= 244 && sitNum < 248) {
				return 78;
			} else if (sitNum >= 248 && sitNum < 256) {
				return 80;
			} else if (sitNum >= 256 && sitNum < 263) {
				return 85;
			} else if (sitNum >= 263 && sitNum < 268) {
				return 90;
			} else if (sitNum >= 268 && sitNum < 273) {
				return 95;
			} else {
				return 100;
			}
		} else {
			if (sitNum < 185) {
				return 0;
			} else if (sitNum >= 185 && sitNum < 190) {
				return 10;
			} else if (sitNum >= 190 && sitNum < 195) {
				return 20;
			} else if (sitNum >= 195 && sitNum < 200) {
				return 30;
			} else if (sitNum >= 200 && sitNum < 205) {
				return 40;
			} else if (sitNum >= 205 && sitNum < 210) {
				return 50;
			} else if (sitNum >= 210 && sitNum < 214) {
				return 60;
			} else if (sitNum >= 214 && sitNum < 218) {
				return 62;
			} else if (sitNum >= 218 && sitNum < 222) {
				return 64;
			} else if (sitNum >= 222 && sitNum < 226) {
				return 66;
			} else if (sitNum >= 226 && sitNum < 230) {
				return 68;
			} else if (sitNum >= 230 && sitNum < 234) {
				return 70;
			} else if (sitNum >= 234 && sitNum < 238) {
				return 72;
			} else if (sitNum >= 238 && sitNum < 242) {
				return 74;
			} else if (sitNum >= 242 && sitNum < 246) {
				return 76;
			} else if (sitNum >= 246 && sitNum < 250) {
				return 78;
			} else if (sitNum >= 250 && sitNum < 258) {
				return 80;
			} else if (sitNum >= 258 && sitNum < 265) {
				return 85;
			} else if (sitNum >= 265 && sitNum < 270) {
				return 90;
			} else if (sitNum >= 270 && sitNum < 275) {
				return 95;
			} else {
				return 100;
			}
		}
	}
}

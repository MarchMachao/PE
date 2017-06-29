package cn.vito.coding.check.scoreTable;

public class ComputeScore {
	public static double score(int grade, String gender, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups,
			Integer pull_up) {

		height = (height == null) ? 0 : height;
		weight = (weight == null) ? 0 : weight;
		vital_capacity = (vital_capacity == null) ? 0 : vital_capacity;
		fivem = (fivem == null) ? 0 : fivem;
		long_jump = (long_jump == null) ? 0 : long_jump;
		reach = (reach == null) ? 0 : reach;
		sit_ups = (sit_ups == null) ? 0 : sit_ups;
		pull_up = (pull_up == null) ? 0 : pull_up;

		double score = BMI.BodyIndex(gender, height, weight) * 0.15 + EightMeters.eightGirl(grade, eightm) * 0.2
				+ FiveMeters.five(gender, grade, fivem) * 0.2 + LongJump.jump(gender, grade, long_jump) * 0.1
				+ PullUp.pull(grade, pull_up) * 0.1 + Reach.reaches(gender, grade, reach) * 0.1
				+ SitUps.sitUp(grade, sit_ups) * 0.1 + TenMeters.tenBoy(grade, tenm) * 0.2
				+ VitalCapacity.vitalCapacity(gender, grade, vital_capacity) * 0.15;
		return score;
	}
}

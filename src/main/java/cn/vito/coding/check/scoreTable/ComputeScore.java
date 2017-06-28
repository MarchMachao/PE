package cn.vito.coding.check.scoreTable;

public class ComputeScore {
	public static double score(int grade, String gender, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups,
			Integer pull_up) {
		double score = BMI.BodyIndex(gender, height, weight) * 0.15 + EightMeters.eightGirl(grade, eightm) * 0.2
				+ FiveMeters.five(gender, grade, fivem) * 0.2 + LongJump.jump(gender, grade, long_jump) * 0.1
				+ PullUp.pull(grade, pull_up) * 0.1 + Reach.reaches(gender, grade, reach) * 0.1
				+ SitUps.sitUp(grade, sit_ups) * 0.1 + TenMeters.tenBoy(grade, tenm) * 0.2
				+ VitalCapacity.vitalCapacity(gender, grade, vital_capacity) * 0.15;
		return score;
	}
}

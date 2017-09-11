package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.TeacherAndAcademyDao;
import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import cn.vito.coding.check.scoreTable.ComputeScore;
import cn.vito.coding.check.service.TeacherAndAcademyService;

@Service
public class TeacherAndAcademyServiceImpl implements TeacherAndAcademyService {

	@Autowired
	private TeacherAndAcademyDao teacherAndAcademyDao;

	@Override
	public List<TeacherAndAcademy> findFreshmanTeacherData(String id, String name, String school, String teacher,
			Integer year, String subjectname, int page, int rows) {
		return teacherAndAcademyDao.findFreshmanTeacherData(
				new TeacherAndAcademyLike(id, name, school, teacher, year, subjectname, page, rows));
	}

	@Override
	public List<String> teacherFreshmanList(String subjectname) {
		return teacherAndAcademyDao.teacherFreshmanList(subjectname);
	}

	@Override
	public List<TeacherAndAcademy> findAcademyData(String id, String name, String school, String teacher, Integer year,
			int page, int rows) {
		return teacherAndAcademyDao
				.findAcademyData(new TeacherAndAcademyLike(id, name, school, teacher, year, page, rows));
	}

	@Override
	public void updateTeacherData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups, Integer pull_up,
			Integer grade, String gender) {
		double score = ComputeScore.score(grade, gender, height, weight, vital_capacity, fivem, long_jump, reach,
				eightm, tenm, sit_ups, pull_up);
		teacherAndAcademyDao.updateTeacherData(new Data(id, year, height, weight, vital_capacity, fivem, long_jump,
				reach, eightm, tenm, sit_ups, pull_up, score, "未审核", "未审核"));

	}

	@Override
	public List<TeacherAndAcademy> findJuniorTeacherData(String id, String name, String school, Integer year, int page,
			int rows) {
		return teacherAndAcademyDao
				.findJuniorTeacherData(new TeacherAndAcademyLike(id, name, school, year, page, rows));
	}

	@Override
	public List<TeacherAndAcademy> findAcademyFreshmanData(String id, String name, String school, Integer year,
			int page, int rows) {
		return teacherAndAcademyDao
				.findAcademyFreshmanData(new TeacherAndAcademyLike(id, name, school, year, page, rows));
	}

}

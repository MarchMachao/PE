package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.AdminDao;
import cn.vito.coding.check.po.Data;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import cn.vito.coding.check.po.TeacherToStudent;
import cn.vito.coding.check.scoreTable.ComputeScore;
import cn.vito.coding.check.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<TeacherAndAcademy> findAdminData(String id, String name, String school, String teacher, Integer year,
			int page, int rows) {
		return adminDao.findAdminData(new TeacherAndAcademyLike(id, name, school, teacher, year, page, rows));
	}

	@Override
	public int countAdminDatas() {
		return adminDao.countAdminDatas();
	}

	@Override
	public void updateAdminData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups, Integer pull_up,
			Integer grade, String gender) {
		double score = ComputeScore.score(grade, gender, height, weight, vital_capacity, fivem, long_jump, reach,
				eightm, tenm, sit_ups, pull_up);
		adminDao.updateAdminData(new Data(id, year, height, weight, vital_capacity, fivem, long_jump, reach, eightm,
				tenm, sit_ups, pull_up, score, "未审核", "未审核"));

	}

	@Override
	public List<TeacherAndAcademy> findAdminGraduateData(String studentId, String name, String school, String teacher,
			Integer year, int page, int rows) {
		return adminDao
				.findAdminGraduateData(new TeacherAndAcademyLike(studentId, name, school, teacher, year, page, rows));
	}

	@Override
	public int countAdminGraduateDatas() {
		return adminDao.countAdminGraduateDatas();
	}

	@Override
	public List<TeacherToStudent> findTeachersToStudentData(String studentId, String school, Integer year,
			String teacher,
			Integer subjectId, String subjectName, int page, int rows) {
		return adminDao.findTeachersToStudentData(
				new TeacherToStudent(studentId, school, year, teacher, subjectId, subjectName, page, rows));
	}

	@Override
	public int countTeacherToStudent() {
		return adminDao.countTeacherToStudent();
	}

	@Override
	public void addOneTeacherToStudentData(String studentId, Integer year, String teacher, Integer subjectId,
			String subjectName) {
		adminDao.addOneTeacherToStudentData(new TeacherToStudent(studentId, year, teacher, subjectId, subjectName));

	}

	@Override
	public void deleteTeacherToStudentData(String studentId, Integer year) {
		TeacherToStudent teacherToStudent = new TeacherToStudent();
		teacherToStudent.setstudentId(studentId);
		teacherToStudent.setYear(year);
		adminDao.deleteTeacherToStudentData(teacherToStudent);

	}

	@Override
	public void updateTeacherToStudentData(String id, Integer year, String teacher, Integer subjectId,
			String subjectName) {
		adminDao.updateTeacherToStudentData(new TeacherToStudent(id, year, teacher, subjectId, subjectName));
	}

	@Override
	public void addOneStudentData(String id, Integer year, Integer height, Double weight, Integer vital_capacity,
			Double fivem, Double long_jump, Double reach, String eightm, String tenm, Integer sit_ups,
			Integer pull_up, Integer grade, String gender) {
		double score = ComputeScore.score(grade, gender, height, weight, vital_capacity, fivem, long_jump, reach,
				eightm, tenm, sit_ups, pull_up);
		adminDao.addOneStudentData(new Data(id, year, height, weight, vital_capacity, fivem, long_jump, reach, eightm,
				tenm, sit_ups, pull_up, score, "已审核", "已审核"));
	}
}

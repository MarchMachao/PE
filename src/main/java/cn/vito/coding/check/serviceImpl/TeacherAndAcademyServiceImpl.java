package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.TeacherAndAcademyDao;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import cn.vito.coding.check.service.TeacherAndAcademyService;

@Service
public class TeacherAndAcademyServiceImpl implements TeacherAndAcademyService {

	@Autowired
	private TeacherAndAcademyDao teacherAndAcademyDao;

	@Override
	public List<TeacherAndAcademy> findTeacherData(String id, String name, String school, String teacher, Integer year,
			int page, int rows) {
		return teacherAndAcademyDao
				.findTeacherData(new TeacherAndAcademyLike(id, name, school, teacher, year, page, rows));
	}

	@Override
	public List<TeacherAndAcademy> findAcademyData(String id, String name, String school, String teacher, Integer year,
			int page, int rows) {
		return teacherAndAcademyDao
				.findAcademyData(new TeacherAndAcademyLike(id, name, school, teacher, year, page, rows));
	}

}

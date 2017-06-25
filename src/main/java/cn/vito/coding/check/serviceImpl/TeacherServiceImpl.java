package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.TeacherDao;
import cn.vito.coding.check.po.Teacher;
import cn.vito.coding.check.po.TeacherLike;
import cn.vito.coding.check.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	@Override
	public int count() {
		return teacherDao.count();
	}

	@Override
	public List<Teacher> findTeacherData(String id, String name, String school, String teacher, Integer year, int page,
			int rows) {
		return teacherDao.findTeacherData(new TeacherLike(id, name, school, teacher, year, page, rows));
	}

}

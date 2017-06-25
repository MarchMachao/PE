package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.TeacherDao;
import cn.vito.coding.check.po.Teacher;
import cn.vito.coding.check.service.TeacherService;
import cn.vito.coding.check.vo.Page;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	@Override
	public int count() {
		return teacherDao.count();
	}

	@Override
	public List<Teacher> findTeacherData(int pageNo, int pageSize) {
		return teacherDao.findTeacherData(new Page(pageNo, pageSize));
	}

}

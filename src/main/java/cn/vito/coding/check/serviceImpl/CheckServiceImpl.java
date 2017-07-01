package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.CheckDao;
import cn.vito.coding.check.po.CheckAcademy;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.po.TeacherAndAcademyLike;
import cn.vito.coding.check.service.CheckService;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private CheckDao checkDao;

	@Override
	public List<TeacherAndAcademy> findCheckList() {
		return checkDao.findCheckList();
	}

	@Override
	public List<TeacherAndAcademy> findCheckByTeacher(String teacher, int pageNo, int pageSize) {
		return checkDao.findCheckByTeacher(new TeacherAndAcademyLike(teacher, pageNo, pageSize));
	}

	@Override
	public void updateState(String teacher) {
		checkDao.updateState(teacher);
	}

	@Override
	public void updateStateNo(String teacher) {
		checkDao.updateStateNo(teacher);
	}

	@Override
	public List<TeacherAndAcademy> findCheckBySchool(String school, int pageNo, int pageSize) {
		return checkDao.findCheckBySchool(new CheckAcademy(school, pageNo, pageSize));
	}

	@Override
	public void checkPass(String school) {
		checkDao.checkPass(school);
	}

	@Override
	public void checkNoPass(String school) {
		checkDao.checkNoPass(school);
	}

}

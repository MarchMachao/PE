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

	@Override
	public List<TeacherAndAcademy> findSchoolCheckList() {
		return checkDao.findSchoolCheckList();
	}

	@Override
	public List<TeacherAndAcademy> findTeacherCheckList() {
		return checkDao.findTeacherCheckList();
	}

	@Override
	public List<TeacherAndAcademy> findAdminCheckByTeacher(String teacher, int pageNo, int pageSize) {
		return checkDao.findAdminCheckByTeacher(new TeacherAndAcademyLike(teacher, pageNo, pageSize));
	}

	@Override
	public List<TeacherAndAcademy> findAdminCheckBySchool(String school, int pageNo, int pageSize) {
		return checkDao.findAdminCheckBySchool(new CheckAcademy(school, pageNo, pageSize));
	}

	@Override
	public void updateAdminTeacherStateOk(String teacher) {
		checkDao.updateAdminTeacherStateOk(teacher);
	}

	@Override
	public void updateAdminTeacherStateNo(String teacher) {
		checkDao.updateAdminTeacherStateNo(teacher);
	}

	@Override
	public void updateAdminSchoolStateOk(String school) {
		checkDao.updateAdminSchoolStateOk(school);
	}

	@Override
	public void updateAdminSchoolStateNo(String school) {
		checkDao.updateAdminSchoolStateNo(school);
	}

	@Override
	public int countCheckByTeacher(String teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countCheckBySchool(String school) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countAdminCheckByTeacher(String teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countAdminCheckBySchool(String school) {
		// TODO Auto-generated method stub
		return 0;
	}

}

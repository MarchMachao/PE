package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.StudentDao;
import cn.vito.coding.check.po.DataAndExtra;
import cn.vito.coding.check.po.Student;
import cn.vito.coding.check.po.StudentAndItsTeacher;
import cn.vito.coding.check.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student findStudentById(String id) {
		return studentDao.findStudentById(id);
	}

	@Override
	public StudentAndItsTeacher findStudentToTeacherById(String id) {
		return studentDao.findStudentToTeacherById(id);
	}

	@Override
	public List<DataAndExtra> findAllDataById(String id) {
		List<DataAndExtra> DataAndExtraList = studentDao.findAllDataById(id);
		for (int i = 0; i < DataAndExtraList.size(); i++) {
			if (DataAndExtraList.get(i).getExtras().getExtra() == null) {
				DataAndExtraList.get(i).getExtras().setExtra(0d);
			}
		}
		return DataAndExtraList;
	}

	@Override
	public void updateData(String id, String classes) {
		studentDao.updateData(new Student(id, classes));
	}

}

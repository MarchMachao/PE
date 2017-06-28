package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.CheckDao;
import cn.vito.coding.check.po.TeacherAndAcademy;
import cn.vito.coding.check.service.CheckService;
import cn.vito.coding.check.vo.Page;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private CheckDao checkDao;

	@Override
	public List<TeacherAndAcademy> findCheckData(int pageNo, int pageSize) {
		return checkDao.findCheckData(new Page(pageNo, pageSize));
	}

}

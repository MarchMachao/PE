package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.ExtrasDao;
import cn.vito.coding.check.po.Extras;
import cn.vito.coding.check.service.ExtrasService;

@Service
public class ExtrasServiceImpl implements ExtrasService {

	@Autowired
	private ExtrasDao extrasDao;

	@Override
	public List<Extras> findStudentExtras(Extras extras) {
		return extrasDao.findStudentExtras(extras);
	}

	@Override
	public int countStudentExtras(Extras extras) {
		return extrasDao.countStudentExtras(extras);
	}

	@Override
	public void addOneExtra(String id, Integer year, Double extra) {
		extrasDao.addOneExtra(new Extras(id, year, extra));
	}

	@Override
	public void updateExtras(String id, Integer year, Double extra) {
		extrasDao.updateExtras(new Extras(id, year, extra));
	}

	@Override
	public void deleteExtras(String id, Integer year) {
		extrasDao.deleteExtras(new Extras(id, year));
	}

}

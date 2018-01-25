package cn.vito.coding.check.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.NoticesDao;
import cn.vito.coding.check.po.Notice;
import cn.vito.coding.check.service.NoticesService;

@Service
public class NoticesServiceImpl implements NoticesService {

	@Autowired
	private NoticesDao noticesDao;

	@Override
	public void addOneNotice(Notice notice) {
		noticesDao.addOneNotice(notice);
	}

	@Override
	public void deleteNotice(int id) {
		noticesDao.deleteNotice(id);
	}

	@Override
	public void updateNotice(Notice notice) {
		noticesDao.updateNotice(notice);
	}

	@Override
	public List<Notice> getAllNotices(Notice notice) {
		return noticesDao.getAllNotices(notice);
	}

	@Override
	public Notice getLatestNotice(String roles) {
		return noticesDao.getLatestNotice(roles);
	}

	@Override
	public int getAllNoticesCount(Notice notice) {
		return noticesDao.getAllNoticesCount(notice);
	}

}

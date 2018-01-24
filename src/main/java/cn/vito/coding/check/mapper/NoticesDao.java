package cn.vito.coding.check.mapper;

import java.util.List;

import cn.vito.coding.check.po.Notice;

public interface NoticesDao {

	/**
	 * 增加一条通知
	 * 
	 * @param notice
	 */
	public void addOneNotice(Notice notice);

	/**
	 * 删除一条通知
	 * 
	 * @param id
	 */
	public void deleteNotice(int id);

	/**
	 * 更新一条通知
	 * 
	 * @param notice
	 */
	public void updateNotice(Notice notice);

	/**
	 * 获取所有通知
	 * 
	 * @param notice
	 * @return
	 */
	public List<Notice> getAllNotices(Notice notice);

	/**
	 * 获取最新通知
	 * 
	 * @param roles
	 * @return
	 */
	public Notice getLatestNotice(String roles);
}

package cn.vito.coding.check.mapper;

import java.util.List;
import java.util.Map;

import cn.vito.coding.check.po.Menu;

/**
 * 菜单操作
 * 
 * @author baijw
 * 
 * @date 2017年3月13日 下午8:40:51
 */
public interface MenuDao {

	/**
	 * 不同部门显示不同菜单
	 * @param role 所属部门
	 * @return
	 */
	public List<Menu> getMenuByRole(String role);
	
	/**
	 * 查找菜单
	 * @param paraMap  菜单名称,分页
	 * @return
	 */
	public List<Menu> getMenuByPage(Map<String, Object> paraMap);
	
	/**
	 * 查找菜单信息
	 * @param menuId	菜单id
	 * @return
	 */
	public Menu getMenuById(String menuId);
	
	/**
	 * 获取所有一级菜单
	 * @return
	 */
	public List<Menu> getAllParentMenu();
	
	/**
	 * 更新菜单信息
	 * @param menu
	 */
	public void updateMenu(Menu menu);
	
}

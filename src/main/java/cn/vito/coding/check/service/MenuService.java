package cn.vito.coding.check.service;

import java.util.List;

import cn.vito.coding.check.po.Menu;
import cn.vito.coding.check.vo.BaseMsg;
import cn.vito.coding.check.vo.DataGrideRow;
import cn.vito.coding.check.vo.MenuVo;

/**
 * menu相关service
 * @author baijw12
 *
 */
public interface MenuService {
	
	/**
	 * 不同部门显示不同菜单
	 * @param role 所属部门
	 * @return
	 */
	public List<Menu> getMenuByRoles(String role);
	
	/**
	 * 
	 * @param menuName
	 * @param page
	 * @param rows
	 * @return
	 */
	public DataGrideRow<Menu> getMenuByPage(String menuName,Integer page,Integer rows);
	
	/**
	 * 根据id查找菜单信息
	 * @param menuId 菜单id
	 * @return
	 */
	public MenuVo getMenuByMenuId(String menuId);
	
	/**
	 * 获取所有父菜单
	 * @return
	 */
	public List<Menu> getAllParentMenu();
	
	/**
	 * 修改菜单信息
	 * @param menuId	菜单编号
	 * @param menuName	菜单名称
	 * @param permition	权限
	 * @return
	 */
	public BaseMsg updateMenu(String menuId,String menuName,String permition);
	
}

package cn.vito.coding.check.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vito.coding.check.mapper.MenuDao;
import cn.vito.coding.check.po.Menu;
import cn.vito.coding.check.service.MenuService;
import cn.vito.coding.check.vo.BaseMsg;
import cn.vito.coding.check.vo.DataGrideRow;
import cn.vito.coding.check.vo.MenuVo;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> getMenuByRoles(String role) {
		return menuDao.getMenuByRole(role);
	}

	@Override
	public DataGrideRow<Menu> getMenuByPage(String menuName, Integer page, Integer rows) {
		Map<String, Object> paraMap = new HashMap<String,Object>();
		paraMap.put("startIndex", (page-1)*rows);
		paraMap.put("rows", rows);
		paraMap.put("menuName", menuName);
		Map<String, Object> para = new HashMap<String,Object>();
		para.put("menuName", menuName);
		menuDao.getMenuByPage(paraMap);
		return new DataGrideRow<>(menuDao.getMenuByPage(para).size(), menuDao.getMenuByPage(paraMap));
	}

	@Override
	public MenuVo getMenuByMenuId(String menuId) {
		Menu menu = menuDao.getMenuById(menuId);
		MenuVo menuVo = new MenuVo();
		menuVo.setMenuId(menu.getMenuId());
		menuVo.setMenuName(menu.getMenuName());
		String[] permition = menu.getPermition().split(",");
		menuVo.setPermition(permition);
		return menuVo;
	}

	@Override
	public List<Menu> getAllParentMenu() {
		return menuDao.getAllParentMenu();
	}

	@Override
	public BaseMsg updateMenu(String menuId, String menuName, String permition) {
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		menu.setMenuName(menuName);
		menu.setPermition(permition);
		menuDao.updateMenu(menu);
		return new BaseMsg(true, "菜单信息修改成功");
	}

}

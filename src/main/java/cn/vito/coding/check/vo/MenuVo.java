package cn.vito.coding.check.vo;

import java.util.Arrays;

/**
 * 
 * @author baijw
 * 
 * @date 2017年4月20日 下午8:21:44
 */
public class MenuVo {

	private String menuId;
	private String menuName;
	private String[] permition;

	public MenuVo() {
		super();
	}

	public MenuVo(String menuId, String menuName, String[] permition) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.permition = permition;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String[] getPermition() {
		return permition;
	}

	public void setPermition(String[] permition) {
		this.permition = permition;
	}

	@Override
	public String toString() {
		return "MenuVo [menuId=" + menuId + ", menuName=" + menuName + ", permition=" + Arrays.toString(permition)
				+ "]";
	}

}

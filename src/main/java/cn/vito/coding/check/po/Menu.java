package cn.vito.coding.check.po;

import java.util.List;

/**
 * 菜单po
 * 
 * @author baijw
 * 
 * @date 2017年3月13日 下午8:42:41
 */
public class Menu {

	private String menuId;
	private String menuName;
	private String parentId;//父菜单
	private String menuUrl;
	private Integer order;
	private String permition;
	private List<Menu> submenus;

	public Menu() {
	}

	public Menu(String menuId, String menuName, String parentId, String menuUrl, Integer order, String permition,
			List<Menu> submenus) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.parentId = parentId;
		this.menuUrl = menuUrl;
		this.order = order;
		this.permition = permition;
		this.submenus = submenus;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Menu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<Menu> submenus) {
		this.submenus = submenus;
	}

	public String getPermition() {
		return permition;
	}

	public void setPermition(String permition) {
		this.permition = permition;
	}

}
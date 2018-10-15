package com.lh.bean;

public class Menu {
    private Integer id;

    private String menuName;

    private String menuLink;

    private String menuIcon;

    private Integer menuRole;

    private Integer menuStatus;

    public String menuStatusDesc()
    {
        String s = "";
        if (menuStatus==1)
            s = "正常";
        else if(menuStatus==2)
            s = "异常";
        return s;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink == null ? null : menuLink.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public Integer getMenuRole() {
        return menuRole;
    }

    public void setMenuRole(Integer menuRole) {
        this.menuRole = menuRole;
    }

    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }
}
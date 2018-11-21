package com.guigu.instructional.po;

public class AuthortyInfo {
    private Integer authortyId;

    private Integer authortyPid;

    private String authortyName;

    private String authortyDesc;

    private String authortyUrl;

    private Integer authortyClass;
    
    // 添加上级权限名称属性
    private String authortyPName;

    public String getAuthortyPName() {
		return authortyPName;
	}

	public void setAuthortyPName(String authortyPName) {
		this.authortyPName = authortyPName;
	}

	public Integer getAuthortyId() {
        return authortyId;
    }

    public void setAuthortyId(Integer authortyId) {
        this.authortyId = authortyId;
    }

    public Integer getAuthortyPid() {
        return authortyPid;
    }

    public void setAuthortyPid(Integer authortyPid) {
        this.authortyPid = authortyPid;
    }

    public String getAuthortyName() {
        return authortyName;
    }

    public void setAuthortyName(String authortyName) {
        this.authortyName = authortyName == null ? null : authortyName.trim();
    }

    public String getAuthortyDesc() {
        return authortyDesc;
    }

    public void setAuthortyDesc(String authortyDesc) {
        this.authortyDesc = authortyDesc == null ? null : authortyDesc.trim();
    }

    public String getAuthortyUrl() {
        return authortyUrl;
    }

    public void setAuthortyUrl(String authortyUrl) {
        this.authortyUrl = authortyUrl == null ? null : authortyUrl.trim();
    }

    public Integer getAuthortyClass() {
        return authortyClass;
    }

    public void setAuthortyClass(Integer authortyClass) {
        this.authortyClass = authortyClass;
    }
}
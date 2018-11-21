package com.guigu.instructional.po;

import java.util.Date;

public class StaffSalary extends StaffInfo {
    private Integer staffSalaryId;

    private Integer staffId;

    private Integer staStaffId;

    private Double staffSalaryTotal;

    private Double staffSalaryDeduct;

    private Double staffSalaryReal;

    private String staffSalaryIsused;

    private Date staffSalaryTime;

    private String remark;
    
    private String staStaffName;
    
    public String getStaStaffName() {
		return staStaffName;
	}

	public void setStaStaffName(String staStaffName) {
		this.staStaffName = staStaffName;
	}

	private StaffInfo staffInfo;

    public Integer getStaffSalaryId() {
        return staffSalaryId;
    }

    public void setStaffSalaryId(Integer staffSalaryId) {
        this.staffSalaryId = staffSalaryId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStaStaffId() {
        return staStaffId;
    }

    public void setStaStaffId(Integer staStaffId) {
        this.staStaffId = staStaffId;
    }

    public Double getStaffSalaryTotal() {
        return staffSalaryTotal;
    }

    public void setStaffSalaryTotal(Double staffSalaryTotal) {
        this.staffSalaryTotal = staffSalaryTotal;
    }

    public Double getStaffSalaryDeduct() {
        return staffSalaryDeduct;
    }

    public void setStaffSalaryDeduct(Double staffSalaryDeduct) {
        this.staffSalaryDeduct = staffSalaryDeduct;
    }

    public Double getStaffSalaryReal() {
        return staffSalaryReal;
    }

    public void setStaffSalaryReal(Double staffSalaryReal) {
        this.staffSalaryReal = staffSalaryReal;
    }

    public String getStaffSalaryIsused() {
        return staffSalaryIsused;
    }

    public void setStaffSalaryIsused(String staffSalaryIsused) {
        this.staffSalaryIsused = staffSalaryIsused == null ? null : staffSalaryIsused.trim();
    }

    public Date getStaffSalaryTime() {
        return staffSalaryTime;
    }

    public void setStaffSalaryTime(Date staffSalaryTime) {
        this.staffSalaryTime = staffSalaryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
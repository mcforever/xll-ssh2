package com.pojo.system;

import java.io.Serializable;

public class SysDictionary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String dataTypeCode;
	private String dataTypeDescription;
	private Integer dataID;
	private String dataDescription;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataTypeCode() {
		return dataTypeCode;
	}
	public void setDataTypeCode(String dataTypeCode) {
		this.dataTypeCode = dataTypeCode;
	}
	public String getDataTypeDescription() {
		return dataTypeDescription;
	}
	public void setDataTypeDescription(String dataTypeDescription) {
		this.dataTypeDescription = dataTypeDescription;
	}
	public Integer getDataID() {
		return dataID;
	}
	public void setDataID(Integer dataID) {
		this.dataID = dataID;
	}
	public String getDataDescription() {
		return dataDescription;
	}
	public void setDataDescription(String dataDescription) {
		this.dataDescription = dataDescription;
	}
	
	
	
}

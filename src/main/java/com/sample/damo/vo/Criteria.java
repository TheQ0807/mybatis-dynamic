package com.sample.damo.vo;

import java.util.List;

public class Criteria {

	private String opt;
	private String keyword;
	private List<Integer> depts;
	
	
	public List<Integer> getDepts() {
		return depts;
	}
	public void setDepts(List<Integer> depts) {
		this.depts = depts;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "Criteria [opt=" + opt + ", keyword=" + keyword + ", depts=" + depts + "]";
	}
	
}

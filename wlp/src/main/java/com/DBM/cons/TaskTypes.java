package com.DBM.cons;

public enum TaskTypes {
	/**
	 * 审核
	 */
	数据审核{
		public String getTypeId(){
			return "1";
		}
	},
	/**
	 * 编辑
	 */
	数据编辑{
		public String getTypeId(){
			return "2";
		}
	};
	public abstract String getTypeId();
}

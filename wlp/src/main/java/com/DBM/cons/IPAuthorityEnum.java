package com.DBM.cons;
/**
 * 访问权限类型的枚举类型
 * @author maxiaocheng
 *	20170226
 */
public enum IPAuthorityEnum {
	栏目访问{
		public String getTypeId(){
			return "1";
		}
	},
	下载原文{
		public String getTypeId(){
			return "2";
		}
	},
	正文查看{
		public String getTypeId(){
			return "3";
		}
	},
	专题访问{
		public String getTypeId(){
			return "4";
		}
	};
	public abstract String getTypeId();
}

package com.DBM.cons;
/**
 * 原文传递处理类型的枚举类型
 * @author maxiaocheng
 *	20170315
 */
public enum ArticleTransType {
	未处理{
		public String getTypeId(){
			return "1";
		}
	},
	已发送原文{
		public String getTypeId(){
			return "2";
		}
	},
	未找到原文已退款{
		public String getTypeId(){
			return "3";
		}
	};
	public abstract String getTypeId();
}

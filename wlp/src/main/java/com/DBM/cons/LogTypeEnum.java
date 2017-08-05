package com.DBM.cons;

/**
 * 日志类型的枚举类型
 * @author maxiaocheng
 *20170224
 */
public enum LogTypeEnum {
	文章下载{
		public int toInt(){
			return 1;
		}
	},
	访问{
		public int toInt(){
			return 2;
		}
	},
	登录{
		public int toInt(){
			return 3;
		}
	},
	浏览{
		public int toInt(){
			return 4;
		}
	},
	检索{
		public int toInt(){
			return 5;
		}
	},
	报告下载{
		public int toInt(){
			return 6;
		}
	},
	分类浏览{
		public int toInt(){
			return 7;
		}
	},
	收藏{
		public int toInt(){
			return 8;
		}
	},
	注册{
		public int toInt(){
			return 9;
		}
	},
	其他{
		public int toInt(){
			return 10;
		}
	};
	public abstract int toInt();
}

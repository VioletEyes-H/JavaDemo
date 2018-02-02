package com;


public class 正则表达式 {

	public static void main(String[] args) {
		// 单个字符
		System.out.println("a".matches("."));
		// 0~1个a
		System.out.println("a".matches("a?"));
		// 1~N个a
		System.out.println("aaaa".matches("a+"));
		// 0~N个a
		System.out.println("a".matches("a*"));
		// 1~N个q和1个0~9之间的数字
		System.out.println("qqqqqq3".matches("q+[0-9]"));
		// 12~100个数字
		System.out.println("12345667890123".matches("\\d{12,100}"));
		// 0~3个数字分别以.分割
		System.out.println("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		// 第一个数字0~2，第二个数字0~9，第三个数字0~9
		System.out.println("192".matches("[0-2][0-9][0-9]"));
		// 4个任意空白
		System.out.println(" \n\r\t".matches("\\s{4}"));
		// 特殊字符\需转义
		System.out.println("\\".matches("\\\\"));
		// 以h开头，中间有0~N个字符，最后以o结尾
		System.out.println("hess21._llo".matches("^.*o$"));
		// 以h开头，中间1~3个字母尾随一个o，接着空白连着0~N个字符并以d结尾
		System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*d$"));
		// 以任意空白且不以换行开头为开头，并以换行结尾
		System.out.println("   \n".matches("^[\\s&&[^\\n]]*\\n$"));
		// 0~N个字符，连接4个数字和一个字符
		System.out.println("aaa 2222q".matches(".*\\d{4}."));
	}

}

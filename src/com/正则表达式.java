package com;


public class ������ʽ {

	public static void main(String[] args) {
		// �����ַ�
		System.out.println("a".matches("."));
		// 0~1��a
		System.out.println("a".matches("a?"));
		// 1~N��a
		System.out.println("aaaa".matches("a+"));
		// 0~N��a
		System.out.println("a".matches("a*"));
		// 1~N��q��1��0~9֮�������
		System.out.println("qqqqqq3".matches("q+[0-9]"));
		// 12~100������
		System.out.println("12345667890123".matches("\\d{12,100}"));
		// 0~3�����ֱַ���.�ָ�
		System.out.println("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		// ��һ������0~2���ڶ�������0~9������������0~9
		System.out.println("192".matches("[0-2][0-9][0-9]"));
		// 4������հ�
		System.out.println(" \n\r\t".matches("\\s{4}"));
		// �����ַ�\��ת��
		System.out.println("\\".matches("\\\\"));
		// ��h��ͷ���м���0~N���ַ��������o��β
		System.out.println("hess21._llo".matches("^.*o$"));
		// ��h��ͷ���м�1~3����ĸβ��һ��o�����ſհ�����0~N���ַ�����d��β
		System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*d$"));
		// ������հ��Ҳ��Ի��п�ͷΪ��ͷ�����Ի��н�β
		System.out.println("   \n".matches("^[\\s&&[^\\n]]*\\n$"));
		// 0~N���ַ�������4�����ֺ�һ���ַ�
		System.out.println("aaa 2222q".matches(".*\\d{4}."));
	}

}

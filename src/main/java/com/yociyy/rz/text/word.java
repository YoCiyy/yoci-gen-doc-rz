//package com.yociyy.rz.text;
//
//import com.yociyy.rz.coreUtils;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.Version;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: YoCiyy
// * @date: 2020/11/1
// */
//public class word {
//	public static void main(String[] args) {
//		Map<String, Object> dataMap = new HashMap<String, Object>();
//		try {
//            dataMap.put("content1"  , "asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd" );
//
//            for (int i = 2; i <= 53; i++) {
//				dataMap.put("content" + i, "asdasdasdasd" + i);
//			}
//			System.out.println(dataMap.size());
//			// ���
//			dataMap.put("title", "ŵ�Ǽ��ŵ��ݹ���ϵͳ");
//			// Configuration ���ڶ�ȡftl�ļ�
//			Configuration configuration = new Configuration(new Version("2.3.0"));
//			configuration.setDefaultEncoding("UTF-8");
//
//			/**
//			 * ����������ָ��ftl�ļ�����Ŀ¼·���ķ�ʽ��ע�������ַ�ʽ���� ָ��ftl�ļ�����Ŀ¼��·����������ftl�ļ���·��
//			 */
//			// ָ��·���ĵ�һ�ַ�ʽ������ĳ��������·��ָ����
//			// configuration.setClassForTemplateLoading(this.getClass(), "");
//
//			// ָ��·���ĵڶ��ַ�ʽ���ҵ�·����C��/a.ftl
//			configuration.setDirectoryForTemplateLoading(new File("D:/"));
//
//			// ����ĵ�·��������
//			File outFile = new File("D:/ŵ�Ǽ��ŵ��ݹ���ϵͳ.doc");
//
//			// ��UTF-8�ı����ȡftl�ļ�
//			Template template = configuration.getTemplate("tpl.ftl", "UTF-8");
//			// Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"), 10240);
//			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
//			template.process(dataMap, out);
//			out.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void wordUtil(Map<String, Object> dataMap) {
//		// Map<String, Object> dataMap = new HashMap<String, Object>();
//		try {
//			// ���
//			// System.out.println(sb.toString());
//			// dataMap.put("content", sb.toString());
//			// dataMap.put("title","ŵ�Ǽ��ŵ��ݹ���ϵͳ");
//			// Configuration ���ڶ�ȡftl�ļ�
//			Configuration configuration = new Configuration(new Version("2.3.0"));
//			configuration.setDefaultEncoding("UTF-8");
//
//			/**
//			 * ����������ָ��ftl�ļ�����Ŀ¼·���ķ�ʽ��ע�������ַ�ʽ���� ָ��ftl�ļ�����Ŀ¼��·����������ftl�ļ���·��
//			 */
//			// ָ��·���ĵ�һ�ַ�ʽ������ĳ��������·��ָ����
//			// configuration.setClassForTemplateLoading(this.getClass(), "");
//
//			// ָ��·���ĵڶ��ַ�ʽ���ҵ�·����C��/a.ftl
//			configuration.setDirectoryForTemplateLoading(new File("D:/"));
//			long name = System.currentTimeMillis();
//			// ����ĵ�·��������
//			String filePath1 = "D:\\doc\\" + name + ".doc";
//			String filePath2 = "D:\\doc\\" + name + ".docx";
//
//			File outFile = new File(filePath1);
//			// ��UTF-8�ı����ȡftl�ļ�
//			Template template = configuration.getTemplate("tpl.ftl", "UTF-8");
//			// Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"), 10240);
//			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
//			template.process(dataMap, out);
//			out.close();
//			// ��doc�ĵ�ת����docx
//			coreUtils.convertDocxFmt(filePath1,filePath2,1);
//			outFile.delete();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
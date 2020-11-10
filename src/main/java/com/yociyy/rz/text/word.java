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
//			// 编号
//			dataMap.put("title", "诺登集团电梯管理系统");
//			// Configuration 用于读取ftl文件
//			Configuration configuration = new Configuration(new Version("2.3.0"));
//			configuration.setDefaultEncoding("UTF-8");
//
//			/**
//			 * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是 指定ftl文件所在目录的路径，而不是ftl文件的路径
//			 */
//			// 指定路径的第一种方式（根据某个类的相对路径指定）
//			// configuration.setClassForTemplateLoading(this.getClass(), "");
//
//			// 指定路径的第二种方式，我的路径是C：/a.ftl
//			configuration.setDirectoryForTemplateLoading(new File("D:/"));
//
//			// 输出文档路径及名称
//			File outFile = new File("D:/诺登集团电梯管理系统.doc");
//
//			// 以UTF-8的编码读取ftl文件
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
//			// 编号
//			// System.out.println(sb.toString());
//			// dataMap.put("content", sb.toString());
//			// dataMap.put("title","诺登集团电梯管理系统");
//			// Configuration 用于读取ftl文件
//			Configuration configuration = new Configuration(new Version("2.3.0"));
//			configuration.setDefaultEncoding("UTF-8");
//
//			/**
//			 * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是 指定ftl文件所在目录的路径，而不是ftl文件的路径
//			 */
//			// 指定路径的第一种方式（根据某个类的相对路径指定）
//			// configuration.setClassForTemplateLoading(this.getClass(), "");
//
//			// 指定路径的第二种方式，我的路径是C：/a.ftl
//			configuration.setDirectoryForTemplateLoading(new File("D:/"));
//			long name = System.currentTimeMillis();
//			// 输出文档路径及名称
//			String filePath1 = "D:\\doc\\" + name + ".doc";
//			String filePath2 = "D:\\doc\\" + name + ".docx";
//
//			File outFile = new File(filePath1);
//			// 以UTF-8的编码读取ftl文件
//			Template template = configuration.getTemplate("tpl.ftl", "UTF-8");
//			// Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"), 10240);
//			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
//			template.process(dataMap, out);
//			out.close();
//			// 将doc文档转换成docx
//			coreUtils.convertDocxFmt(filePath1,filePath2,1);
//			outFile.delete();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
package com.yociyy.rz;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 代码生成核心包
 *
 * @author: YoCiyy
 * @date: 2020/11/2
 */
public class coreUtils {

	/**
	 * docx 格式
	 */
	private static final int DOCX_FMT = 12;

	public static List<File> fileList = new ArrayList<File>();

	/*
	 * 通过递归得到某一路径下所有的目录及其文件
	 */
	public static List<File> getFiles(File root) {

		File[] files = root.listFiles();

		for (File file : files) {
			if (file.exists() && file.isDirectory()) {
				getFiles(file);
			} else {
				String filename = file.getName();
				String suffix = filename.substring(filename.lastIndexOf(".") + 1);
				if (suffix.equals("java")) {
					fileList.add(file);
					System.out.println("addFile " + file);
				} else {
					System.out.println("notFile " + file);
				}
			}
		}
		return fileList;
	}

	public static void genDoc(Map<String, Object> dataMap, String outPath) {
		// Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			// Configuration 用于读取ftl文件
			Configuration configuration = new Configuration(new Version("2.3.0"));
			configuration.setDefaultEncoding("UTF-8");

			/**
			 * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是 指定ftl文件所在目录的路径，而不是ftl文件的路径
			 */
			// 指定路径的第一种方式（根据某个类的相对路径指定）

			configuration.setClassForTemplateLoading(coreUtils.class, "/");
			// 指定路径的第二种方式，我的路径是C：/a.ftl
			// configuration.setDirectoryForTemplateLoading(new File("D:/"));
			long name = System.currentTimeMillis();
			// 输出文档路径及名称
			String filePath1 = outPath + name + ".doc";
			String filePath2 = outPath + name + ".docx";

			File outFile = new File(filePath1);
			// 以UTF-8的编码读取ftl文件
			Template template = configuration.getTemplate("tpl.ftl", "UTF-8");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
			template.process(dataMap, out);
			out.close();
			// 将doc文档转换成docx
			coreUtils.convertDocxFmt(filePath1, filePath2, 1);
			outFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据格式类型转换 com.yociyy.rz.text.word 文件
	 *
	 * @param srcPath 源文件
	 * @param descPath 目标文件
	 * @param fmt 所转格式
	 */
	public static void convertDocxFmt(String srcPath, String descPath, int fmt) throws Exception {
		File file = new File(srcPath);

		// 实例化ComThread线程与ActiveXComponent
		ComThread.InitSTA();
		ActiveXComponent app = new ActiveXComponent("Word.Application");
		try {
			// 文档隐藏时进行应用操作
			app.setProperty("Visible", new Variant(false));
			// 实例化模板Document对象
			Dispatch document = app.getProperty("Documents").toDispatch();
			// 打开Document进行另存为操作
			Dispatch doc = Dispatch.invoke(
					document,
					"Open",
					Dispatch.Method,
					new Object[] { file.getAbsolutePath(), new Variant(false),
							new Variant(true) },
					new int[1]).toDispatch();

			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
					descPath, new Variant(DOCX_FMT) }, new int[1]);

			Dispatch.call(doc, "Close", new Variant(false));
			// return new File(descPath);
		} catch (Exception e) {
			throw e;
		} finally {

			// 释放线程与ActiveXComponent
			app.invoke("Quit", new Variant[] {});
			ComThread.Release();
		}
	}
}

package com.yociyy.rz;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 软著文档导出 导出txt文档 v1.0
 */
public class txtUtils {

	// 扫描的源代码
	public static String PROJECT_URL = "D:\\javaDemo1\\jeecg-boot";

	public static void main(String[] args) throws IOException {

		File f = new File(PROJECT_URL);
		List<File> fileList = coreUtils.getFiles(f);
		long leftLines = 0;

		// 正向 fileList
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < fileList.size(); i++) {
			File item = fileList.get(i);
			List<String> contentList = FileUtils.readLines(item, "UTF-8");

			for (String content : contentList) {
				content = content.trim().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;");
				if (content.length() == 0) {
					continue;
				}
				// 跳过功能注释 跳过版权注释
				if (content.startsWith("/") || content.startsWith("*")) {
					continue;
				}
				// 2950行大约60页文档
				if (leftLines > 2950) {
					FileUtils.write(new File("D:\\doc\\" + System.currentTimeMillis() + ".txt"), sb.toString(), "UTF-8");
					leftLines = 0;
					sb.setLength(0);
					break;
				}

				sb.append(content);
				sb.append("\n");
				leftLines++;
			}
		}

	}

}

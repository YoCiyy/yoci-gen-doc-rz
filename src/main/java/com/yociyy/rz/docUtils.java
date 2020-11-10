package com.yociyy.rz;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 软著文档导出 导出docx文档 3000行源代码 v1.2
 */
public class docUtils {

	// 扫描的源代码
	public static String PROJECT_URL = "D:\\javaDemo1\\text-boot";
	// 文档输出路径
	public static String OUT_PATH = "D:\\doc\\";

	public static void main(String[] args) throws IOException {

		File f = new File(PROJECT_URL);

		List<File> fileList = coreUtils.getFiles(f);

		long lines = 1;
		long count = 1;

		Map<String, Object> dataMap = new HashMap<String, Object>();
		for (int i = 0; i < fileList.size(); i++) {
			File item = fileList.get(i);
			List<String> contentList = FileUtils.readLines(item, "UTF-8");
			for (String content : contentList) {
				// 替换xml无法识别的特殊字符
				content = content.trim().replaceAll("<", "").replaceAll(">", "").replaceAll("&", "");
				// 保证每一个模板字符不超过第二行
				if (content.length() > 65) {
					content = content.substring(0, 65);
				}
				// 跳过空行
				if (content.length() == 0) {
					continue;
				}
				// 跳过功能注释 跳过版权注释
				if (content.contains("/") || content.contains("*")) {
					continue;
				}
				// 填充模板字符串从 content1~content3000 保证每个模板3000行代码
				dataMap.put("content" + lines, content);
				if (dataMap.size() == 3000) {
					// 生产doc
					coreUtils.genDoc(dataMap, OUT_PATH);
					System.out.println("生成第" + count + "份文档");
					// 清理数据生成下一份
					dataMap.clear();
					count++;
					lines = 1;
					break;
				}
				lines++;
			}
		}
		System.out.println("文档已生成完成");
	}
}

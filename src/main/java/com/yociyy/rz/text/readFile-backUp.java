package com.yociyy.rz.text;//import org.apache.commons.io.coreUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class com.yociyy.rz.txtUtils {
//
//    public static List<File> filelist = new ArrayList<File>();
//
//    public static String PROJECT_URL = "D:\\IDEA\\cloud-platform";
//
//    // 3000行大概60页文档存至left
//    public static String LEFT_URL = "D:\\left.txt";
//    // 其余切割至right
//    public static String RIGHT_URL = "D:\\right.txt";
//
//    public static void main(String[] args) throws IOException {
//
//        File f = new File(PROJECT_URL);
//        getFiles(f);
//
////        List<File> ll = (List<File>) coreUtils.listFiles(f, new SuffixFileFilter(new String[]{"m", "h"}), null);
//
//        long leftLines= 0,rightLines = 0;
//
//        // 正向 fileList
//        StringBuffer leftBuffer = new StringBuffer();
//        for (int i = 0 ; i < filelist.size() ; i ++){
//            File item = filelist.get(i);
//
//            List<String> contentList = coreUtils.readLines(item, "UTF-8");
//
//            for (String content :contentList){
//                content = content.trim();
//                if (content.length() == 0){
//                    continue;
//                }
//                // 跳过注释
//                if (content.startsWith("/") || content.startsWith("*")) {
//                    continue;
//                }
//                if (leftLines > 3000){
//                    // 大于2000行
//                    break;
//                }
//
//                leftBuffer.append(content);
//                leftBuffer.append("\n");
//                leftLines++;
//            }
//        }
//
//        // 逆向 fileList
//        StringBuffer rightBuffer = new StringBuffer();
//        for (int i = filelist.size() - 1 ; i > 0 ; i --){
//            File item = filelist.get(i);
//
//            List<String> contentList = coreUtils.readLines(item, "UTF-8");
//
//            for (String content :contentList){
//                content = content.trim();
//                if (content.length() == 0){
//                    continue;
//                }
//
//                // 跳过注释
//                if (content.startsWith("/") || content.startsWith("*")) {
//                    continue;
//                }
//
//                if (rightLines > 3000){
//                    // 大于2000行
//                    break;
//                }
//
//                rightBuffer.append(content);
//                rightBuffer.append("\n");
//                rightLines++;
//            }
//        }
//
//        coreUtils.write(new File(LEFT_URL), leftBuffer.toString(), "UTF-8");
//        coreUtils.write(new File(RIGHT_URL), rightBuffer.toString(), "UTF-8");
//
//    }
//
//    /*
//     * 通过递归得到某一路径下所有的目录及其文件
//     */
//    static void getFiles(File root){
//
//        File[] files = root.listFiles();
//
//        for (File file : files){
//            if (file.exists() && file.isDirectory()){
//                getFiles(file);
//            }else {
//
//                String filename = file.getName();
//                String suffix = filename.substring(filename.lastIndexOf(".")+1);
//
//                if (suffix.equals("java")){
//                    filelist.add(file);
//                    System.out.println("addFile "+file);
//                }else {
//                    System.out.println("notFile "+file);
//                }
//            }
//        }
//    }
//
//}

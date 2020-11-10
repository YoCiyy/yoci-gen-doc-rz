//package com.yociyy.rz.text;
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//import com.jacob.com.Variant;
//
//import java.io.File;
//
///**
// * @author: YoCiyy
// * @date: 2020/11/8
// */
//public class text {
//    public static void main(String[] args) {
//        text dfc = new text();
//        String srcDocPath = "D:\\doc\\1604848339670.doc";
//        dfc.wordConveter(srcDocPath,srcDocPath + ".docx");
//    }
//    public static void wordConveter(String src,String dist) {
//        File file = new File(src);
//        // 启动word应用程序(Microsoft Office Word 2003)
//        ActiveXComponent app = new ActiveXComponent("Word.Application");
//        System.out.println("正在转换     "+file.getAbsolutePath()+"");
//        try {
//            // 设置word应用程序不可见
//            app.setProperty("Visible", new Variant(false));
//            // documents表示word程序的所有文档窗口，（word是多文档应用程序）
//            Dispatch docs = app.getProperty("Documents").toDispatch();
//            // 打开要转换的word文件
//            Dispatch doc = Dispatch.invoke(
//                    docs,
//                    "Open",
//                    Dispatch.Method,
//                    new Object[] { file.getAbsolutePath(), new Variant(false),
//                            new Variant(true) }, new int[1]).toDispatch();
//            int type=12;
//            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
//                    dist, new Variant(type) }, new int[1]);
//            // 关闭word文件
//            Dispatch.call(doc, "Close", new Variant(false));
//        } catch (Exception e) {
//            System.out.println("*******转换出错********");
//        } finally {
//            // 关闭word应用程序
//            app.invoke("Quit", new Variant[] {});
//        }
//        System.out.println("*******转换完毕********");
//    }
//}

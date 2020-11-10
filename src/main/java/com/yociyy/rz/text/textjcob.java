/*
package com.yociyy.rz.text;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

*/
/**
 * @author: YoCiyy
 * @date: 2020/11/3
 *//*

public class textjcob {
    */
/*** doc 格式 *//*

    private static final int DOC_FMT = 0;

    */
/*** docx 格式 *//*

    private static final int DOCX_FMT = 12;

    public static void main(String[] args) {
        textjcob dfc = new textjcob();
        String srcDocPath = "D:/test.xml";

        String descDocPath = "D:/test.docx";
        try {
            dfc.convertDocFmt(srcDocPath, descDocPath, DOCX_FMT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 根据格式类型转换 com.yociyy.rz.text.word 文件
     *
     * @param srcPath    源文件
     * @param descPath    目标文件
     * @param fmt        所转格式
     *//*

    public static void convertDocFmt(String srcPath, String descPath, int fmt) throws Exception {
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
                            new Variant(true) }, new int[1]).toDispatch();

            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
                    descPath, new Variant(DOCX_FMT) }, new int[1]);

            Dispatch.call(doc, "Close", new Variant(false));
//            return new File(descPath);
        } catch (Exception e) {
            throw e;
        } finally {
            // 释放线程与ActiveXComponent
            app.invoke("Quit", new Variant[] {});
            ComThread.Release();
        }
    }
}
*/

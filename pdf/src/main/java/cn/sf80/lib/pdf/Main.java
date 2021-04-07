package cn.sf80.lib.pdf;

import technology.tabula.CommandLineApp;

/**
 * @author wangcongjun
 * @date 2021/3/18 15:24
 */
public class Main {
    public static void main(String[] args) throws Exception {// TODO Auto-generated method stub
//        String[] ar = {"-o=D:/tmp/PDF/output.csv", "-p=all", "D:\\tmp\\PDF\\input.pdf"};
        String[] ar = {"-o=D:/tmp/PDF/primary.csv", "-p=all", "D:\\tmp\\PDF\\primary.pdf"};
        CommandLineApp.main(ar);
        //PdfUtil.convert2Csv("E:\\doc\\pdf\\(2018) .pdf", "output.csv");
    }
}

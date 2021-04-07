package cn.sf80.hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;

/**
 * @author wangcongjun
 * @date 2021/3/29 10:26
 */
public class DateDemo {
    public static void main(String[] args) {
        String strDate = "2021-1-31 22:36:54";
        Calendar calendar = DateUtil.parseByPatterns(strDate, "yyyy", "yyyy-MM","yyyy-MM-dd","yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm","HH:mm:ss");
        DateTime offset = DateUtil.offset(calendar.getTime(), DateField.MONTH, 1);
        System.out.println(offset);

    }
}

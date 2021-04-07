package cn.sf80.cron;

import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;

import java.util.Calendar;
import java.util.Date;

import static com.cronutils.model.field.expression.FieldExpressionFactory.*;

/**
 * @author wangcongjun
 * @date 2021/3/23 14:50
 */
public class SpecialDate {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Cron cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ))
                .withYear(on(calendar.get(Calendar.YEAR)))
                .withDoW(on(calendar.get(Calendar.DAY_OF_WEEK)))
                .withMonth(on(calendar.get(Calendar.MONTH)+1))
                .withDoM(on(calendar.get(Calendar.DATE)))
                .withHour(on(calendar.get(Calendar.HOUR_OF_DAY)))
                .withMinute(on(calendar.get(Calendar.MINUTE)))
                .withSecond(on(calendar.get(Calendar.SECOND)))
                .instance();
        String cronAsString = cron.asString();
        System.out.println(cronAsString);
    }
}

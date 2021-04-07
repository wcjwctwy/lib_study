package cn.sf80.cron;

import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.field.value.SpecialChar;

import static com.cronutils.model.field.expression.FieldExpressionFactory.*;

/**
 * @author wangcongjun
 * @date 2021/3/23 14:29
 */
public class Demo {
    public static void main(String[] args) {
        Cron cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ))
                .withYear(always())
                .withDoM(always())
                .withMonth(always())
                .withDoW(questionMark())
                .withHour(on(2))
//                .withHour(always())
                .withMinute(always())
                .withSecond(on(0))
                .instance();
// Obtain the string expression
        String cronAsString = cron.asString(); // 0 * * L-3 * ? *
        System.out.println(cronAsString);
    }
}

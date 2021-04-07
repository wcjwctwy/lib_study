package cn.sf80.lib.pdf;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

public class CsvUtil {
   public static List<String[]> getData(String filePath){
       List<String[]> result = new ArrayList<>();
       try {
           CSVReader primaryReader = new CSVReader(new FileReader(filePath));
           Map<String, HehaiUniversalAnalyse.AnalyseItem> primaryMap = new HashMap<>();
           Boolean startRecord = false;
           while (true) {
               String[] strings = primaryReader.readNext();
               if (strings == null) {
                   break;
               }
               result.add(strings);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return result;
   }
}
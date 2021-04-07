package cn.sf80.lib.pdf;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangcongjun
 * @date 2021/3/18 16:37
 */
public class HehaiUniversalAnalyse {
    public static void main(String[] args) throws Exception {
        Map<String, AnalyseItem> primaryMap = new HashMap<>();
        Boolean startRecord = false;
        List<String[]> primaryData = CsvUtil.getData("D:/tmp/PDF/primary.csv");

        for (String[] strings : primaryData) {
            if (StringUtils.equals(strings[0], "102940250008312")) {
                startRecord = true;
            }
            if (startRecord) {
//            System.out.println(Arrays.asList(strings));
                primaryMap.put(strings[0], new AnalyseItem(strings[0], strings[6]));
            }
            if (StringUtils.equals(strings[0], "102940250012207")) {
                startRecord = false;
            }
        }


        Map<String, AnalyseItem> hireMap = new HashMap<>();
        List<String[]> hireData = CsvUtil.getData("D:/tmp/PDF/output.csv");
        for (String[] strings : hireData) {
//            System.out.println(Arrays.asList(strings));
            String specialName = strings[5];
            String academyName = strings[3];
//            if(StringUtils.equals(specialName,"工程管理") && StringUtils.equals(academyName,"商学院")) {
            if (StringUtils.equals(academyName, "商学院")) {
                hireMap.put(strings[0], new AnalyseItem(strings[0], strings[6], strings[5], strings[3]));
            }
        }

        ArrayList<AnalyseItem> memList = new ArrayList<>();
        hireMap.forEach((k, v) -> {
            if (StringUtils.equals(v.specialName, "工程管理") && StringUtils.equals(v.academyName, "商学院")) {
                memList.add(v);
            }
        });

        HashMap<String, AnalyseItem> result = new HashMap<>();
        primaryMap.forEach((k, v) -> {
            if (!hireMap.containsKey(k)) {
                result.put(k, v);
            } else {
                System.out.println(hireMap.get(k).specialName);
            }
        });

        System.out.println("MEM招收人数：" + memList.size());
        System.out.println("MEM初试人数：" + primaryMap.size());
        System.out.println("MEM复试淘汰人数：" + result.size());
        result.forEach((i, v) -> System.out.println(v));
    }


    public static class AnalyseItem {
        @Override
        public String toString() {
            return "AnalyseItem{" +
                    "number='" + number + '\'' +
                    ", score='" + score + '\'' +
                    ", specialName='" + specialName + '\'' +
                    ", academyName='" + academyName + '\'' +
                    '}';
        }

        public AnalyseItem(String number, String score) {
            this.number = number;
            this.score = score;
        }

        public AnalyseItem(String number, String score, String specialName, String academyName) {
            this.number = number;
            this.score = score;
            this.specialName = specialName;
            this.academyName = academyName;
        }

        private String number;
        private String score;
        private String specialName;
        private String academyName;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getSpecialName() {
            return specialName;
        }

        public void setSpecialName(String specialName) {
            this.specialName = specialName;
        }

        public String getAcademyName() {
            return academyName;
        }

        public void setAcademyName(String academyName) {
            this.academyName = academyName;
        }
    }

}

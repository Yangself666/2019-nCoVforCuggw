package cn.yangself;

import cn.yangself.domain.Result;
import cn.yangself.service.GCService;
import com.github.andyczy.java.excel.ExcelUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void fun1() throws IOException {
        GCService gcService = new GCService();
        List<Result> dayTemp = gcService.getDayTemp("2020-02-13");
        System.out.println(dayTemp);
    }
    @org.junit.Test
    public void fun2() throws IOException {
        String[] sheetNameList = new String[]{"sheet123"};

        //LocalExcelUtils noResponseExcelUtils = LocalExcelUtils.initialization();
        //noResponseExcelUtils.setDataLists(getExcelData());
        //noResponseExcelUtils.setSheetName(new String[]{"测试"});
        //noResponseExcelUtils.setFilePath("测试" + ".xlsx");
        //noResponseExcelUtils.localNoResponse();
        ExcelUtils excelUtils = ExcelUtils.initialization();
        //excelUtils.setResponse(response);
    }


    public List<List<String[]>> getExcelData() throws IOException {
        List<List<String[]>> dataLists = new ArrayList<>();
        List<String[]> oneList = new ArrayList<>();  // 表格一数据
        GCService gcService = new GCService();
        List<Result> dayTemp = gcService.getDayTemp("2020-02-13");

        String[] valueString = null;

        String[] headers = {"序号","姓名","学院","年级","专业","班级","现居住地（具体到门牌号）","本人电话","家长电话","本人体温","父亲体温","母亲体温"};
        oneList.add(headers);

        for (int i = 0; i < dayTemp.size(); i++) {
            valueString = new String[]{dayTemp.get(i).getSid().toString(),
                    dayTemp.get(i).getsName(),
                    dayTemp.get(i).getPart(),
                    dayTemp.get(i).getGrade(),
                    dayTemp.get(i).getMajor(),
                    dayTemp.get(i).getsClass(),
                    dayTemp.get(i).getAddr(),
                    dayTemp.get(i).getMyTel(),
                    dayTemp.get(i).getOtTel(),
                    dayTemp.get(i).getMyTemp() == null?null:dayTemp.get(i).getMyTemp().toString(),
                    dayTemp.get(i).getFaTemp() == null?null:dayTemp.get(i).getFaTemp().toString(),
                    dayTemp.get(i).getMoTemp() == null?null:dayTemp.get(i).getMoTemp().toString()};
            oneList.add(valueString);
        }
        dataLists.add(oneList);   // 多个表格导出就是多个sheet
        return dataLists;
    }
}

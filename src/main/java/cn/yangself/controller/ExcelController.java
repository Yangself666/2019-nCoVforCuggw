package cn.yangself.controller;

import cn.yangself.domain.ClassResult;
import cn.yangself.domain.Result;
import cn.yangself.service.GCService;
import com.github.andyczy.java.excel.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ExcelController {
    @RequestMapping("getExcel")
    public String getExcel(HttpServletRequest request, HttpServletResponse response, Model model, String tDate) throws IOException {
        ExcelUtils excelUtils = ExcelUtils.initialization();

        List<List<String[]>> dataLists = new ArrayList<>();
        List<String[]> oneList = new ArrayList<>();  // 表格一数据
        GCService gcService = new GCService();
        List<Result> dayTemp = gcService.getDayTemp(tDate);
        if (dayTemp.get(0).getMyTemp() == null){
            model.addAttribute("dMsg","当天没有数据！请重新选择日期！");
            return "getExcel";
        }

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
        dataLists.add(oneList);

        excelUtils.setDataLists(dataLists);
        excelUtils.setSheetName(new String[]{tDate+"工程二队体温信息"});
        excelUtils.setResponse(response);

        response.setContentType("application/x-download");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        excelUtils.exportForExcelsOptimize();
        return "downloadSuccess";
    }
    @RequestMapping("getTempList")
    public String getTempList(HttpServletResponse response, Model model,String tDate) throws IOException {
        ExcelUtils excelUtils = ExcelUtils.initialization();
        GCService gcService = new GCService();


        List<ClassResult> oneTemp = gcService.getDayTempList(tDate,"电子1601");
        List<ClassResult> twoTemp = gcService.getDayTempList(tDate,"电气1601");
        List<ClassResult> threeTemp = gcService.getDayTempList(tDate,"电气1602");
        List<ClassResult> fourTemp = gcService.getDayTempList(tDate,"电气1603");
        List<ClassResult> fiveTemp = gcService.getDayTempList(tDate,"电气1604");
        List<ClassResult> sixTemp = gcService.getDayTempList(tDate,"计算机1601");
        List<ClassResult> sevenTemp = gcService.getDayTempList(tDate,"计算机1602");
        List<ClassResult> eightTemp = gcService.getDayTempList(tDate,"计算机1603");
        List<ClassResult> nineTemp = gcService.getDayTempList(tDate,"计算机1604");

        if (    oneTemp.get(0).getMyTemp() == null &&
                twoTemp.get(0).getMyTemp() == null &&
                threeTemp.get(0).getMyTemp() == null &&
                fourTemp.get(0).getMyTemp() == null &&
                fiveTemp.get(0).getMyTemp() == null &&
                sixTemp.get(0).getMyTemp() == null &&
                sevenTemp.get(0).getMyTemp() == null &&
                eightTemp.get(0).getMyTemp() == null &&
                nineTemp.get(0).getMyTemp() == null
        ){
            model.addAttribute("dMsg","当天没有数据！请重新选择日期！");
            return "getTempList";
        }

        List<List<String[]>> dataLists = new ArrayList<>();

        List<String[]> oneList = new ArrayList<>();  // 表格一数据
        List<String[]> twoList = new ArrayList<>();  // 表格一数据
        List<String[]> threeList = new ArrayList<>();  // 表格一数据
        List<String[]> fourList = new ArrayList<>();  // 表格一数据
        List<String[]> fiveList = new ArrayList<>();  // 表格一数据
        List<String[]> sixList = new ArrayList<>();  // 表格一数据
        List<String[]> sevenList = new ArrayList<>();  // 表格一数据
        List<String[]> eightList = new ArrayList<>();  // 表格一数据
        List<String[]> nineList = new ArrayList<>();  // 表格一数据


        //自定义合并单元格
        HashMap regionMap = new HashMap();

        //合并单元格-代表起始行号，终止行号， 起始列号，终止列号进行合并。
        ArrayList<Integer[]> sheet1 = new ArrayList<>();
        ArrayList<Integer[]> sheet2 = new ArrayList<>();
        ArrayList<Integer[]> sheet3 = new ArrayList<>();
        ArrayList<Integer[]> sheet4 = new ArrayList<>();
        ArrayList<Integer[]> sheet5 = new ArrayList<>();
        ArrayList<Integer[]> sheet6 = new ArrayList<>();
        ArrayList<Integer[]> sheet7 = new ArrayList<>();
        ArrayList<Integer[]> sheet8 = new ArrayList<>();
        ArrayList<Integer[]> sheet9 = new ArrayList<>();



        String[] oneValueString = null;
        String[] twoValueString = null;
        String[] threeValueString = null;
        String[] fourValueString = null;
        String[] fiveValueString = null;
        String[] sixValueString = null;
        String[] sevenValueString = null;
        String[] eightValueString = null;
        String[] nineValueString = null;


        String[] header1 = {"序号","姓名","专业班级（会计1601）","专业班级（会计1601）","家庭成员体温","家庭成员体温","家庭成员体温","身体状况","身体状况","备注"};
        String[] header2 = {"序号","姓名","专业班级（会计1601）","专业班级（会计1601）","本人","父亲","母亲","身体状况","身体状况","备注"};


        //电子1601开始
        oneList.add(header1);
        oneList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet1.add(new Integer[]{1, 2, 0, 0});
        sheet1.add(new Integer[]{1, 2, 1, 1});
        sheet1.add(new Integer[]{1, 2, 2, 3});
        sheet1.add(new Integer[]{1, 1, 4, 6});
        sheet1.add(new Integer[]{1, 2, 7, 8});
        sheet1.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < oneTemp.size(); i++) {
            oneValueString = new String[]{i+1+"",
                    oneTemp.get(i).getsName(),
                    oneTemp.get(i).getsClass(),
                    oneTemp.get(i).getsClass(),
                    oneTemp.get(i).getMyTemp() == null?null:oneTemp.get(i).getMyTemp().toString(),
                    oneTemp.get(i).getFaTemp() == null?null:oneTemp.get(i).getFaTemp().toString(),
                    oneTemp.get(i).getMoTemp() == null?null:oneTemp.get(i).getMoTemp().toString(),
                    oneTemp.get(i).getState(),
                    oneTemp.get(i).getState(),
                    ""
            };
            oneList.add(oneValueString);
            sheet1.add(new Integer[]{i+3, i+3, 2, 3});
            sheet1.add(new Integer[]{i+3, i+3, 7, 8});
        }
        String[] lastLine = {"注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”",
                "注：专业班级一栏务必严格按照统一格式填写，身体状况填写“正常”、“发烧”、“咳嗽”"
        };
        //最后一行
        sheet1.add(new Integer[]{oneTemp.size()+3, oneTemp.size()+3, 0, 9});
        oneList.add(lastLine);

        //电子1601结束

//===========================================================================
        //电气1601开始
        twoList.add(header1);
        twoList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet2.add(new Integer[]{1, 2, 0, 0});
        sheet2.add(new Integer[]{1, 2, 1, 1});
        sheet2.add(new Integer[]{1, 2, 2, 3});
        sheet2.add(new Integer[]{1, 1, 4, 6});
        sheet2.add(new Integer[]{1, 2, 7, 8});
        sheet2.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < twoTemp.size(); i++) {
            twoValueString = new String[]{i+1+"",
                    twoTemp.get(i).getsName(),
                    twoTemp.get(i).getsClass(),
                    twoTemp.get(i).getsClass(),
                    twoTemp.get(i).getMyTemp() == null?null:twoTemp.get(i).getMyTemp().toString(),
                    twoTemp.get(i).getFaTemp() == null?null:twoTemp.get(i).getFaTemp().toString(),
                    twoTemp.get(i).getMoTemp() == null?null:twoTemp.get(i).getMoTemp().toString(),
                    twoTemp.get(i).getState(),
                    twoTemp.get(i).getState(),
                    ""
            };
            twoList.add(twoValueString);
            sheet2.add(new Integer[]{i+3, i+3, 2, 3});
            sheet2.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet2.add(new Integer[]{twoTemp.size()+3, twoTemp.size()+3, 0, 9});
        twoList.add(lastLine);
        //电气1601结束
//===========================================================================
        //电气1602开始
        threeList.add(header1);
        threeList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet3.add(new Integer[]{1, 2, 0, 0});
        sheet3.add(new Integer[]{1, 2, 1, 1});
        sheet3.add(new Integer[]{1, 2, 2, 3});
        sheet3.add(new Integer[]{1, 1, 4, 6});
        sheet3.add(new Integer[]{1, 2, 7, 8});
        sheet3.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < threeTemp.size(); i++) {
            threeValueString = new String[]{i+1+"",
                    threeTemp.get(i).getsName(),
                    threeTemp.get(i).getsClass(),
                    threeTemp.get(i).getsClass(),
                    threeTemp.get(i).getMyTemp() == null?null:threeTemp.get(i).getMyTemp().toString(),
                    threeTemp.get(i).getFaTemp() == null?null:threeTemp.get(i).getFaTemp().toString(),
                    threeTemp.get(i).getMoTemp() == null?null:threeTemp.get(i).getMoTemp().toString(),
                    threeTemp.get(i).getState(),
                    threeTemp.get(i).getState(),
                    ""
            };
            threeList.add(threeValueString);
            sheet3.add(new Integer[]{i+3, i+3, 2, 3});
            sheet3.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet3.add(new Integer[]{threeTemp.size()+3, threeTemp.size()+3, 0, 9});
        threeList.add(lastLine);
        //电气1602结束
//===========================================================================
        //电气1603开始
        fourList.add(header1);
        fourList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet4.add(new Integer[]{1, 2, 0, 0});
        sheet4.add(new Integer[]{1, 2, 1, 1});
        sheet4.add(new Integer[]{1, 2, 2, 3});
        sheet4.add(new Integer[]{1, 1, 4, 6});
        sheet4.add(new Integer[]{1, 2, 7, 8});
        sheet4.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < fourTemp.size(); i++) {
            fourValueString = new String[]{i+1+"",
                    fourTemp.get(i).getsName(),
                    fourTemp.get(i).getsClass(),
                    fourTemp.get(i).getsClass(),
                    fourTemp.get(i).getMyTemp() == null?null:fourTemp.get(i).getMyTemp().toString(),
                    fourTemp.get(i).getFaTemp() == null?null:fourTemp.get(i).getFaTemp().toString(),
                    fourTemp.get(i).getMoTemp() == null?null:fourTemp.get(i).getMoTemp().toString(),
                    fourTemp.get(i).getState(),
                    fourTemp.get(i).getState(),
                    ""
            };
            fourList.add(fourValueString);
            sheet4.add(new Integer[]{i+3, i+3, 2, 3});
            sheet4.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet4.add(new Integer[]{fourTemp.size()+3, fourTemp.size()+3, 0, 9});
        fourList.add(lastLine);

        //电气1603结束
//===========================================================================
        //电气1604开始
        fiveList.add(header1);
        fiveList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet5.add(new Integer[]{1, 2, 0, 0});
        sheet5.add(new Integer[]{1, 2, 1, 1});
        sheet5.add(new Integer[]{1, 2, 2, 3});
        sheet5.add(new Integer[]{1, 1, 4, 6});
        sheet5.add(new Integer[]{1, 2, 7, 8});
        sheet5.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < fiveTemp.size(); i++) {
            fiveValueString = new String[]{i+1+"",
                    fiveTemp.get(i).getsName(),
                    fiveTemp.get(i).getsClass(),
                    fiveTemp.get(i).getsClass(),
                    fiveTemp.get(i).getMyTemp() == null?null:fiveTemp.get(i).getMyTemp().toString(),
                    fiveTemp.get(i).getFaTemp() == null?null:fiveTemp.get(i).getFaTemp().toString(),
                    fiveTemp.get(i).getMoTemp() == null?null:fiveTemp.get(i).getMoTemp().toString(),
                    fiveTemp.get(i).getState(),
                    fiveTemp.get(i).getState(),
                    ""
            };
            fiveList.add(fiveValueString);
            sheet5.add(new Integer[]{i+3, i+3, 2, 3});
            sheet5.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet5.add(new Integer[]{fiveTemp.size()+3, fiveTemp.size()+3, 0, 9});
        fiveList.add(lastLine);
        //电气1604结束
//===========================================================================
        //计算机1601开始
        sixList.add(header1);
        sixList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet6.add(new Integer[]{1, 2, 0, 0});
        sheet6.add(new Integer[]{1, 2, 1, 1});
        sheet6.add(new Integer[]{1, 2, 2, 3});
        sheet6.add(new Integer[]{1, 1, 4, 6});
        sheet6.add(new Integer[]{1, 2, 7, 8});
        sheet6.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < sixTemp.size(); i++) {
            sixValueString = new String[]{i+1+"",
                    sixTemp.get(i).getsName(),
                    sixTemp.get(i).getsClass(),
                    sixTemp.get(i).getsClass(),
                    sixTemp.get(i).getMyTemp() == null?null:sixTemp.get(i).getMyTemp().toString(),
                    sixTemp.get(i).getFaTemp() == null?null:sixTemp.get(i).getFaTemp().toString(),
                    sixTemp.get(i).getMoTemp() == null?null:sixTemp.get(i).getMoTemp().toString(),
                    sixTemp.get(i).getState(),
                    sixTemp.get(i).getState(),
                    ""
            };
            sixList.add(sixValueString);
            sheet6.add(new Integer[]{i+3, i+3, 2, 3});
            sheet6.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet6.add(new Integer[]{sixTemp.size()+3, sixTemp.size()+3, 0, 9});
        sixList.add(lastLine);
        //计算机1601结束
//===========================================================================
        //计算机1602开始
        sevenList.add(header1);
        sevenList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet7.add(new Integer[]{1, 2, 0, 0});
        sheet7.add(new Integer[]{1, 2, 1, 1});
        sheet7.add(new Integer[]{1, 2, 2, 3});
        sheet7.add(new Integer[]{1, 1, 4, 6});
        sheet7.add(new Integer[]{1, 2, 7, 8});
        sheet7.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < sevenTemp.size(); i++) {
            sevenValueString = new String[]{i+1+"",
                    sevenTemp.get(i).getsName(),
                    sevenTemp.get(i).getsClass(),
                    sevenTemp.get(i).getsClass(),
                    sevenTemp.get(i).getMyTemp() == null?null:sevenTemp.get(i).getMyTemp().toString(),
                    sevenTemp.get(i).getFaTemp() == null?null:sevenTemp.get(i).getFaTemp().toString(),
                    sevenTemp.get(i).getMoTemp() == null?null:sevenTemp.get(i).getMoTemp().toString(),
                    sevenTemp.get(i).getState(),
                    sevenTemp.get(i).getState(),
                    ""
            };
            sevenList.add(sevenValueString);
            sheet7.add(new Integer[]{i+3, i+3, 2, 3});
            sheet7.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet7.add(new Integer[]{sevenTemp.size()+3, sevenTemp.size()+3, 0, 9});
        sevenList.add(lastLine);
        //计算机1602结束
//===========================================================================
        //计算机1603开始
        eightList.add(header1);
        eightList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet8.add(new Integer[]{1, 2, 0, 0});
        sheet8.add(new Integer[]{1, 2, 1, 1});
        sheet8.add(new Integer[]{1, 2, 2, 3});
        sheet8.add(new Integer[]{1, 1, 4, 6});
        sheet8.add(new Integer[]{1, 2, 7, 8});
        sheet8.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < eightTemp.size(); i++) {
            eightValueString = new String[]{i+1+"",
                    eightTemp.get(i).getsName(),
                    eightTemp.get(i).getsClass(),
                    eightTemp.get(i).getsClass(),
                    eightTemp.get(i).getMyTemp() == null?null:eightTemp.get(i).getMyTemp().toString(),
                    eightTemp.get(i).getFaTemp() == null?null:eightTemp.get(i).getFaTemp().toString(),
                    eightTemp.get(i).getMoTemp() == null?null:eightTemp.get(i).getMoTemp().toString(),
                    eightTemp.get(i).getState(),
                    eightTemp.get(i).getState(),
                    ""
            };
            eightList.add(eightValueString);
            sheet8.add(new Integer[]{i+3, i+3, 2, 3});
            sheet8.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet8.add(new Integer[]{eightTemp.size()+3, eightTemp.size()+3, 0, 9});
        eightList.add(lastLine);
        //计算机1603结束
//===========================================================================
        //计算机1604开始
        nineList.add(header1);
        nineList.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet9.add(new Integer[]{1, 2, 0, 0});
        sheet9.add(new Integer[]{1, 2, 1, 1});
        sheet9.add(new Integer[]{1, 2, 2, 3});
        sheet9.add(new Integer[]{1, 1, 4, 6});
        sheet9.add(new Integer[]{1, 2, 7, 8});
        sheet9.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < nineTemp.size(); i++) {
            nineValueString = new String[]{i+1+"",
                    nineTemp.get(i).getsName(),
                    nineTemp.get(i).getsClass(),
                    nineTemp.get(i).getsClass(),
                    nineTemp.get(i).getMyTemp() == null?null:nineTemp.get(i).getMyTemp().toString(),
                    nineTemp.get(i).getFaTemp() == null?null:nineTemp.get(i).getFaTemp().toString(),
                    nineTemp.get(i).getMoTemp() == null?null:nineTemp.get(i).getMoTemp().toString(),
                    nineTemp.get(i).getState(),
                    nineTemp.get(i).getState(),
                    ""
            };
            nineList.add(nineValueString);
            sheet9.add(new Integer[]{i+3, i+3, 2, 3});
            sheet9.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet9.add(new Integer[]{nineTemp.size()+3, nineTemp.size()+3, 0, 9});
        nineList.add(lastLine);
        //计算机1604结束


        //将表数据放入文件
        dataLists.add(oneList);
        dataLists.add(twoList);
        dataLists.add(threeList);
        dataLists.add(fourList);
        dataLists.add(fiveList);
        dataLists.add(sixList);
        dataLists.add(sevenList);
        dataLists.add(eightList);
        dataLists.add(nineList);




        //表格设置导入
        regionMap.put(1, sheet1);
        regionMap.put(2, sheet2);
        regionMap.put(3, sheet3);
        regionMap.put(4, sheet4);
        regionMap.put(5, sheet5);
        regionMap.put(6, sheet6);
        regionMap.put(7, sheet7);
        regionMap.put(8, sheet8);
        regionMap.put(9, sheet9);



        //单元格合并
        excelUtils.setRegionMap(regionMap);
        excelUtils.setDataLists(dataLists);
        String[] dayTime = tDate.split("-");
        String fileName = dayTime[1]+"月"+dayTime[2]+"日16工程二队学生体温监测台账";
        excelUtils.setLabelName(new String[]{"保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账","保定理工学院学生身体状况检测台账"});
        excelUtils.setSheetName(new String[]{"电子1601","电气1601","电气1602","电气1603","电气1604","计算机1601","计算机1602","计算机1603","计算机1604"});
        excelUtils.setFileName(fileName);

        response.setContentType("application/x-download");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        excelUtils.setResponse(response);

        excelUtils.exportForExcelsOptimize();
        return "downloadSuccess";
    }
}

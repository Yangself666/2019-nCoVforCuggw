package cn.yangself.controller;

import cn.yangself.domain.ClassResult;
import cn.yangself.domain.Result;
import cn.yangself.service.GcService;
import com.github.andyczy.java.excel.ExcelUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExcelController {
    @RequestMapping("getExcel")
    @ResponseBody
    public String getExcel(HttpServletRequest request, HttpServletResponse response, Model model, String tDate) throws IOException {
        ExcelUtils excelUtils = ExcelUtils.initialization();

        List<List<String[]>> dataLists = new ArrayList<>();
        List<String[]> oneList = new ArrayList<>();  // 表格一数据
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GcService gcService = context.getBean("gcService", GcService.class);
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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GcService gcService = context.getBean("gcService", GcService.class);


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
            return "/getTempList.jsp";
        }

        List<List<String[]>> dataLists = new ArrayList<>();





        //自定义合并单元格
        HashMap regionMap = new HashMap();

        //List<Map<String, Object>> classExcelList = new ArrayList<Map<String, Object>>();
        Map<String, Object> classExcel1 = getClassExcel(oneTemp);
        Map<String, Object> classExcel2 = getClassExcel(twoTemp);
        Map<String, Object> classExcel3 = getClassExcel(threeTemp);
        Map<String, Object> classExcel4 = getClassExcel(fourTemp);
        Map<String, Object> classExcel5 = getClassExcel(fiveTemp);
        Map<String, Object> classExcel6 = getClassExcel(sixTemp);
        Map<String, Object> classExcel7 = getClassExcel(sevenTemp);
        Map<String, Object> classExcel8 = getClassExcel(eightTemp);
        Map<String, Object> classExcel9 = getClassExcel(nineTemp);

        //合并单元格-代表起始行号，终止行号， 起始列号，终止列号进行合并。
        ArrayList<Integer[]> sheet1 = (ArrayList<Integer[]>) classExcel1.get("style");
        ArrayList<Integer[]> sheet2 = (ArrayList<Integer[]>) classExcel2.get("style");
        ArrayList<Integer[]> sheet3 = (ArrayList<Integer[]>) classExcel3.get("style");
        ArrayList<Integer[]> sheet4 = (ArrayList<Integer[]>) classExcel4.get("style");
        ArrayList<Integer[]> sheet5 = (ArrayList<Integer[]>) classExcel5.get("style");
        ArrayList<Integer[]> sheet6 = (ArrayList<Integer[]>) classExcel6.get("style");
        ArrayList<Integer[]> sheet7 = (ArrayList<Integer[]>) classExcel7.get("style");
        ArrayList<Integer[]> sheet8 = (ArrayList<Integer[]>) classExcel8.get("style");
        ArrayList<Integer[]> sheet9 = (ArrayList<Integer[]>) classExcel9.get("style");


        List<String[]> oneList = (List<String[]>) classExcel1.get("content");
        List<String[]> twoList = (List<String[]>) classExcel2.get("content");
        List<String[]> threeList = (List<String[]>) classExcel3.get("content");
        List<String[]> fourList = (List<String[]>) classExcel4.get("content");
        List<String[]> fiveList = (List<String[]>) classExcel5.get("content");
        List<String[]> sixList = (List<String[]>) classExcel6.get("content");
        List<String[]> sevenList = (List<String[]>) classExcel7.get("content");
        List<String[]> eightList = (List<String[]>) classExcel8.get("content");
        List<String[]> nineList = (List<String[]>) classExcel9.get("content");





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
        return null;
    }

    public Map<String,Object> getClassExcel(List<ClassResult> numTemp){
        String[] ValueString = null;
        String[] header1 = {"序号","姓名","专业班级（会计1601）","专业班级（会计1601）","家庭成员体温","家庭成员体温","家庭成员体温","身体状况","身体状况","备注"};
        String[] header2 = {"序号","姓名","专业班级（会计1601）","专业班级（会计1601）","本人","父亲","母亲","身体状况","身体状况","备注"};
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
        Map<String,Object> map = new HashMap<String,Object>();
        //最后一行
        ArrayList<Integer[]> sheet = new ArrayList<>();
        List<String[]> list = new ArrayList<>();  // 表格一数据
        //计算机1604开始
        list.add(header1);
        list.add(header2);
        //代表起始行号，终止行号， 起始列号，终止列号进行合并。（注意：excel从零行开始数）
        sheet.add(new Integer[]{1, 2, 0, 0});
        sheet.add(new Integer[]{1, 2, 1, 1});
        sheet.add(new Integer[]{1, 2, 2, 3});
        sheet.add(new Integer[]{1, 1, 4, 6});
        sheet.add(new Integer[]{1, 2, 7, 8});
        sheet.add(new Integer[]{1, 2, 9, 9});
        //上面已经将表头设计好

        for (int i = 0; i < numTemp.size(); i++) {
            ValueString = new String[]{i+1+"",
                    numTemp.get(i).getsName(),
                    numTemp.get(i).getsClass(),
                    numTemp.get(i).getsClass(),
                    numTemp.get(i).getMyTemp() == null?null:numTemp.get(i).getMyTemp().toString(),
                    numTemp.get(i).getFaTemp() == null?null:numTemp.get(i).getFaTemp().toString(),
                    numTemp.get(i).getMoTemp() == null?null:numTemp.get(i).getMoTemp().toString(),
                    numTemp.get(i).getState(),
                    numTemp.get(i).getState(),
                    ""
            };
            list.add(ValueString);
            sheet.add(new Integer[]{i+3, i+3, 2, 3});
            sheet.add(new Integer[]{i+3, i+3, 7, 8});
        }

        //最后一行
        sheet.add(new Integer[]{numTemp.size()+3, numTemp.size()+3, 0, 9});
        list.add(lastLine);

        map.put("style", sheet);
        map.put("content", list);
        return map;
    }
}

package cn.yangself.controller;

import cn.yangself.domain.Result;
import cn.yangself.service.GCService;
import com.github.andyczy.java.excel.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {
    @RequestMapping("getExcel")
    public String getExcel(HttpServletResponse response, Model model, String tDate) throws IOException {
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

        excelUtils.exportForExcelsOptimize();
        return "downloadSuccess";
    }
}

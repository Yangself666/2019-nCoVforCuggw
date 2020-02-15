package cn.yangself.controller;

import cn.yangself.domain.Student;
import cn.yangself.domain.Temp;
import cn.yangself.service.GCService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Controller
public class GCController {
    private GCService gcService = new GCService();
    private Temp temp ;
    private Student student ;
    private Temp toTemp;
    @RequestMapping("submitForm")
    public String submitForm(Model model, String tName, String major, String mClass, String myTemp, String faTemp, String moTemp,String state){
        Double myTempI = null;
        Double faTempI = null;
        Double moTempI = null;

        //这是今天的日期
        String tDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if ("".equals(myTemp.trim())){
            model.addAttribute("tName",tName);
            model.addAttribute("myTemp",myTemp);
            model.addAttribute("faTemp",faTemp);
            model.addAttribute("moTemp",moTemp);
            model.addAttribute("msg","请至少填写本人的体温信息！");
            return "index";
        }
        if(!Pattern.matches("[1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*",myTemp.trim())){
            model.addAttribute("tName",tName);
            model.addAttribute("myTemp",myTemp);
            model.addAttribute("faTemp",faTemp);
            model.addAttribute("moTemp",moTemp);
            model.addAttribute("msg","请填写正确的温度数字！");
            return "index";
        }
        myTempI = Double.parseDouble(myTemp.trim());
        if(!"".equals(faTemp.trim())){
            if (!Pattern.matches("[1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*",faTemp.trim())){
                model.addAttribute("tName",tName);
                model.addAttribute("myTemp",myTemp);
                model.addAttribute("faTemp",faTemp);
                model.addAttribute("moTemp",moTemp);
                model.addAttribute("msg","请填写正确的温度数值！");
                return "index";
            }
            faTempI = Double.parseDouble(faTemp.trim());
        }
        if(!"".equals(moTemp.trim())){
            if (!Pattern.matches("[1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*",moTemp.trim())){
                model.addAttribute("tName",tName);
                model.addAttribute("myTemp",myTemp);
                model.addAttribute("faTemp",faTemp);
                model.addAttribute("moTemp",moTemp);
                model.addAttribute("msg","请填写正确的温度数值！");
                return "index";
            }
            moTempI = Double.parseDouble(moTemp.trim());
        }
        //if (!Pattern.matches("[1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*",myTemp.trim()) ||!Pattern.matches("[1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*",faTemp.trim())||!Pattern.matches("[1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*",moTemp.trim())){
        //    model.addAttribute("tName",tName);
        //    model.addAttribute("myTemp",myTemp);
        //    model.addAttribute("faTemp",faTemp);
        //    model.addAttribute("moTemp",moTemp);
        //    model.addAttribute("msg","请填写正确的温度数值！");
        //    return "index";
        //}



        try {
            //查询今天有没有记录
            temp = gcService.findByNameFromTempToday(tName, mClass,tDate);

            if (temp == null){//在temp中没有查到今天的记录
                //查询是否有这个人
                student = gcService.findByNameFromStudent(tName, mClass);
                if (student == null){//说明姓名输入错误，或者班级选择错误
                    model.addAttribute("tName",tName);
                    model.addAttribute("myTemp",myTemp);
                    model.addAttribute("faTemp",faTemp);
                    model.addAttribute("moTemp",moTemp);
                    model.addAttribute("msg","请检查您的姓名或班级是否正确，如果确认无误，请联系QQ：212000375");
                    return "index";
                }else{
                    //在student里面查询到，创建今天的体温记录
                    toTemp = new Temp(null,tDate,tName,mClass,myTempI,faTempI,moTempI,state);
                    gcService.addTemp(toTemp);
                    return "success";
                }
            }
            toTemp = new Temp(null, tDate, tName, mClass, myTempI, faTempI, moTempI,state);
            gcService.alterTemp(toTemp);
            return "success";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}



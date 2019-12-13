package com.wangyuelin.app.controller;

import com.wangyuelin.app.bean.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("splash")
public class SplashController {

    @RequestMapping("/showImg")
    @ResponseBody
    public RespBean getSplashImg() {
        Map<String, String> respMap = new HashMap<String, String>();
        respMap.put("url", "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1576057689&di=e54ec9ea7781254398cd9daf15e5fdc3&src=http://5.595818.com/download/pic/000/264/ca1c9dc32e621f5bc3294ab71bb8ac3b.jpg");
        return new RespBean(10000, "请求成功", respMap);
    }
}

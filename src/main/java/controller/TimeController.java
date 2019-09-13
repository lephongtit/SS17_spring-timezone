package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // nhận thời gian hiện tại tại địa phương
        Date date = new Date();
        // Nhận múi giờ của địa phương
        TimeZone local = TimeZone.getDefault();
        // Nhận múi giờ của địa phương
        TimeZone locale = TimeZone.getTimeZone(city);
        // tính tgian hiện tại trong thành phố đc chỉ định
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // đặt lại ngyà theo locale_time
        date.setTime(locale_time);
        // đặt dữ liệu đc gửi đến chế độ xem
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
package com.mypro.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jayMamba
 * @date 2020/1/3
 * @time 9:59
 * @desc
 */
@RestController
@RequestMapping("/email")
public class emailTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Autowired

    private JavaMailSender mailSender;



    @PostMapping("/send")
    public ResData sendMail(@RequestBody UserData userData){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("j_wz_666@sina.com");

        message.setTo("1178515275@qq.com","1262360741@qq.com");

        message.setSubject("紫数阿里云测试");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("客户姓名："+userData.getName()+"\r\n");
        stringBuffer.append("联系方式："+userData.getPhone()+"\r\n");
        stringBuffer.append("需求："+userData.getComment()+"\r\n");
        stringBuffer.append("预算："+userData.getBudget()+"\r\n");

        message.setText(stringBuffer.toString());



        try {

            mailSender.send(message);

            logger.info("邮件已发送。");
            return ResData.success(null);

        } catch (Exception e) {

            logger.error("邮件时发生异常了！", e);
            return ResData.failed("邮件发送失败");
        }

    }
}

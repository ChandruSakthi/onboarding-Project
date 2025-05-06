package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Employee;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;



@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    SpringTemplateEngine templateEngine;

    public void sendRegistrationEmail(Employee user) {
        try {
            Context context = new Context();
            context.setVariable("name", user.getFullName());
            context.setVariable("username", user.getFullName());
            context.setVariable("password", user.getPassword());
            context.setVariable("loginLink", "http://localhost:8080/login");

            String emailContent = templateEngine.process("UserRegistrationEmail", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(user.getEmail());
            helper.setSubject("Welcome to TVM Infotech Pvt Ltd Onboarding Portal!");
            helper.setText(emailContent, true);

            mailSender.send(message);

        } catch (Exception e) {
            throw new RuntimeException("Failed to send registration email", e);
 }
}

}

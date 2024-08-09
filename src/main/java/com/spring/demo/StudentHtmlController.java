package com.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller  // always returns html view name  --> /resource/templates/filename.html --> beautification
public class StudentHtmlController {


    @GetMapping("/showDetail")
    public String getAllInfo(Model model){  // API -> Application Programming Interface
        try {
            List<Student> studentList = new ArrayList<>();
            studentList.add(new Student("Rohit Sharma", 45));
            studentList.add(new Student("Virat Kohli", 18));
            studentList.add(new Student("Rahul Dravid",24));
            studentList.add(new Student("Sourav Ganguly", 04));
            studentList.add(new Student("MS Dhoni", 07));
            model.addAttribute("students",studentList); // sends data from backend to frontend
            return "student_details"; // /resource/templates/student_details.html
        }catch (Exception e){
            return "FAILURE";
        }
    }
}

package com.adeptia.Adeptia.Controller;

import com.adeptia.Adeptia.Exception.StudentnotException;
import com.adeptia.Adeptia.Model.Student;
import com.adeptia.Adeptia.Service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("savedata")
    public Student saveStudent(@RequestBody Student student){
        System.out.print(student);
        return studentService.saveStudentdata(student);
    }


        @GetMapping("/studentId")
        public ResponseEntity<String> findStudent(@RequestParam Integer id) throws StudentnotException {
            try {
                List<Student> result = studentService.getStudentDetails(id);
                if (result.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cant not find");
                }
                return ResponseEntity.status(HttpStatus.OK).body(result.toString());
            }
//            } catch (Exception e) {
//
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//            }
            catch (StudentnotException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
        @PutMapping("/updatestudent")
        public String updateStudentDetails(@RequestBody Student student){

            Optional<Student> ans = Optional.ofNullable(studentService.updateStudent(student));
//            if(ans.isEmpty()){
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("match not found");
//            }
//            return ResponseEntity.status(HttpStatus.OK).body("match not found");

            return "details updated sucess"+ans;

        }
        @DeleteMapping("/deleteById")
        public  String deleteStudent(@RequestParam int studentId) throws EntityNotFoundException {

        studentService.deleteStudentByID(studentId);
        return "details has been deleted with id"+ studentId;
        }
}

package com.adeptia.Adeptia.Service;

import com.adeptia.Adeptia.Exception.StudentnotException;
import com.adeptia.Adeptia.Model.Student;
import com.adeptia.Adeptia.Repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student saveStudentdata(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudentDetails(Integer id) throws StudentnotException {
//        List al = new ArrayList<>();
        return studentRepository.findAllById(Collections.singleton(id));
    }
    public Student updateStudent(Student student) {


        Optional<Student> existingStudent = studentRepository.findById(student.getId());
        if (existingStudent.isPresent()) {
            return studentRepository.save(student);
        } else {
            throw new EntityNotFoundException("Student with ID " + student.getId() + " does not exist");
        }
    }


    public void deleteStudentByID(int studentId) throws EntityNotFoundException {
        Optional<Student> existingStudent = studentRepository.findById(studentId);

        if (!existingStudent.isPresent()) {
            throw new EntityNotFoundException("Student with ID " + studentId + " is not present");
        }

        studentRepository.deleteById(studentId);
        System.out.println("Student with ID " + studentId + " has been deleted successfully");
    }


}
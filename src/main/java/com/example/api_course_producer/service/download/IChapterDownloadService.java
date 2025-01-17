package com.example.api_course_producer.service.download;

import com.example.api_course_producer.entity.course.Chapter;
import com.example.api_course_producer.entity.course.Course;
import com.example.api_course_producer.repository.ChapterRepository;
import com.example.api_course_producer.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IChapterDownloadService implements ChapterDownloadService{

    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Chapter> getallChapter () {
        return  chapterRepository.findAll();
    }
    @Override
    public List<Chapter> getChapterbyCourse(int course_id){
        Course course  = courseRepository.findById(course_id).orElse(null);
        return course.getChapters();
    }

    @Override
    public int getNumberOfChapter(int course_id) {
        return courseRepository.getNumberOfChapter(course_id);
    }

    @Override
    public Chapter getChapterbyId(int id){
        Chapter chapter  = chapterRepository.findById(id).orElse(null);
        return chapter;
    }

}

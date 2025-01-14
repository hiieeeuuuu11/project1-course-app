package com.example.api_course_producer.service.upload;

import com.example.api_course_producer.dto.ChapterRequest;
import com.example.api_course_producer.entity.course.Chapter;
import com.example.api_course_producer.entity.course.Course;
import com.example.api_course_producer.repository.ChapterRepository;
import com.example.api_course_producer.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IChapterUploadService implements ChapterUploadService{

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Chapter addChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter addChapterToCourse(ChapterRequest chapterDetailInfomation) {
        Course course = courseRepository.findById(chapterDetailInfomation.getCourse_id()).orElse(null);
        int numberOfChapter = course.getChapters().size();
        Chapter chapter = Chapter.builder()
                .title(chapterDetailInfomation.getTitle())
                .description(chapterDetailInfomation.getDescription())
                .position(numberOfChapter+1)
                .build();
        course.getChapters().add(chapter);
        courseRepository.save(course);
        //chapterRepository.save(chapter);
        return chapter;
    }

    @Override
    public Chapter updateChapter(Chapter chapter)                                                                              {
        Chapter chapter1 = chapterRepository.findById(chapter.getId()).orElse(null);
        if (chapter1 != null) {
            chapter1.setTitle(chapter.getTitle());
            chapter1.setDescription(chapter.getDescription());
            return chapterRepository.save(chapter1);
        }
        return null;
    }

    @Override
    public void deleteChapter(int id) {
        chapterRepository.deleteById(id);
    }
}

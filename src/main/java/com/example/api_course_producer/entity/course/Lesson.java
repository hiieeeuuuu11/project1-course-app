package com.example.api_course_producer.entity.course;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson")
@Entity
@Builder
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    String description;

    String content;

    String videoUrl;
    String textUrl;

    @ManyToOne @JoinColumn(name = "chapter_id") @JsonBackReference
    Chapter chapter_id;



}

package com.example.api_course_producer.service.third_party_service;

import com.example.api_course_producer.entity.third_party_app.ThirdPartyApplication;

import java.util.List;


public interface ThirdPartyService {

    ThirdPartyApplication getById(int id);

    ThirdPartyApplication update(ThirdPartyApplication thirdPartyApplication);

    void delete(int id);

    List<ThirdPartyApplication> getAll();

    ThirdPartyApplication findByAddress(String address);

    ThirdPartyApplication add(ThirdPartyApplication thirdPartyApplication);

}

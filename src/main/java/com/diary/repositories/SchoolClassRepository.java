package com.diary.repositories;

import com.diary.model.SchoolClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JaroLP on 2016-11-03.
 */


public interface SchoolClassRepository {
    SchoolClass findSchooClassById(Long id);
}

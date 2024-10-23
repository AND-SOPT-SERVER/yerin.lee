package com.sopt_server.seminar.api.repository;

import com.sopt_server.seminar.api.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}

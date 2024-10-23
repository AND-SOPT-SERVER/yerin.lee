package com.sopt_server.seminar.api.service;

import com.sopt_server.seminar.api.domain.Diary;
import com.sopt_server.seminar.api.dto.request.DiaryPostRequest;
import com.sopt_server.seminar.api.repository.DiaryRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Transactional
    public void postDiary(DiaryPostRequest diaryPostRequest){
        Diary diary = Diary.builder()
                .title(diaryPostRequest.title())
                .content(diaryPostRequest.content())
                .category(diaryPostRequest.category())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        diaryRepository.save(diary);
    }
}

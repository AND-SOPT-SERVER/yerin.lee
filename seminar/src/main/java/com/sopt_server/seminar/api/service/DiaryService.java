package com.sopt_server.seminar.api.service;

import com.sopt_server.seminar.api.domain.Diary;
import com.sopt_server.seminar.api.dto.request.DiaryPostRequest;
import com.sopt_server.seminar.api.dto.response.DiaryGetResponse;
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

    public DiaryGetResponse getDiary(Long id){
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Diary not found"));
        return DiaryGetResponse.builder()
                .id(diary.getId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .createdAt(diary.getCreatedAt())
                .build();
    }
}

package com.sopt_server.seminar.api.service;

import static org.springframework.data.domain.Sort.Order.by;

import com.sopt_server.seminar.api.domain.Diary;
import com.sopt_server.seminar.api.dto.request.DiaryPatchRequest;
import com.sopt_server.seminar.api.dto.request.DiaryPostRequest;
import com.sopt_server.seminar.api.dto.response.DiaryGetResponse;
import com.sopt_server.seminar.api.dto.response.DiaryListGetResponse;
import com.sopt_server.seminar.api.repository.DiaryRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

    public void patchDiary(Long id, DiaryPatchRequest diaryPatchRequest){
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Diary not found"));
        diary.setContent(diaryPatchRequest.content());
    }

    public void deleteDiary(Long id){
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Diary not found"));
        diaryRepository.delete(diary);
    }

    public Page<DiaryListGetResponse> getDiaryList(int page, int size){

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.DESC, "createdAt"));
        Page<Diary> diaryList = diaryRepository.findAll(pageRequest);
        List<DiaryListGetResponse> diaryListGetResponses = diaryList.stream()
                .map(diary -> new DiaryListGetResponse(diary.getId(), diary.getTitle()))
                .collect(Collectors.toList());
        return new PageImpl<>(diaryListGetResponses, pageRequest, diaryList.getTotalElements());
    }
}

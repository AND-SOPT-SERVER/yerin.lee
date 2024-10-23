package com.sopt_server.seminar.api.controller;

import com.sopt_server.seminar.api.domain.Diary;
import com.sopt_server.seminar.api.dto.request.DiaryPostRequest;
import com.sopt_server.seminar.api.service.DiaryService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/diary")
    public ResponseEntity postDiary(@Valid @RequestBody DiaryPostRequest diaryPostRequest){
        diaryService.postDiary(diaryPostRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

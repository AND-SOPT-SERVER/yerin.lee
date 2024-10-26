package com.sopt_server.seminar.api.controller;

import com.sopt_server.seminar.api.domain.Diary;
import com.sopt_server.seminar.api.dto.request.DiaryPatchRequest;
import com.sopt_server.seminar.api.dto.request.DiaryPostRequest;
import com.sopt_server.seminar.api.service.DiaryService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/diary/{diaryId}")
    public ResponseEntity getDiary(@PathVariable Long diaryId){
        return ResponseEntity.ok(diaryService.getDiary(diaryId));
    }

    @PatchMapping("/diary/{diaryId}")
    public ResponseEntity patchDiary(@PathVariable Long diaryId,
                                     @Valid @RequestBody DiaryPatchRequest diaryPatchRequest){
        diaryService.patchDiary(diaryId, diaryPatchRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/diary/{diaryId}")
    public ResponseEntity deleteDiary(@PathVariable Long diaryId){
        diaryService.deleteDiary(diaryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

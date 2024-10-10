package org.sopt.assignment1;

import java.util.List;
import java.util.Scanner;

public class DiaryController {
    private Status status = Status.READY;
    private final DiaryService diaryService = new DiaryService();

    Status getStatus() {
        return status;
    }

    void boot() {
        this.status = Status.RUNNING;
    }

    void finish() {
        this.status = Status.FINISHED;
    }

    // APIS
    final List<Diary> getList() {
        return diaryService.getDiaryList();
    }

    final void post(final String body) {
        if (body.length() > 30){
            throw new IllegalArgumentException("일기의 길이는 30자를 넘을 수 없습니다.");
        }
        diaryService.postDiary(body);
    }

    final void delete(final String id) {
        diaryService.deleteDiary(id);
    }

    final void patch(final String id, final String body) {
        diaryService.patchDiary(id,body);
    }

    enum Status {
        READY,
        RUNNING,
        FINISHED,
        ERROR,
    }
}

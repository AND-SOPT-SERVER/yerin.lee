package org.sopt.assignment1;

import java.util.List;

public class DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepository();

    void postDiary(final String body) {
        Diary diary = new Diary(null, body);

        diaryRepository.save(diary);
    }

    List<Diary> getDiaryList() {
        return diaryRepository.findAll();
    }

    void deleteDiary(final String id) {
        diaryRepository.delete(id);
    }

    void validateId(final Long id) {

    }
}

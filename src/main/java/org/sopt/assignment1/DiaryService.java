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
        if(!isExisted(id))
            throw new NullPointerException("존재하지 않는 id 입니다.");
        diaryRepository.delete(id);
    }

    void patchDiary(final String id, final String body) {
        if(!isExisted(id))
            throw new NullPointerException("존재하지 않는 id 입니다.");
        diaryRepository.update(id ,body);
    }

    boolean isExisted(final String id) {
        List<Diary> diaryList = getDiaryList();
        if (diaryList.isEmpty()) {
            return false;
        } else {
            for (Diary diary : diaryList) {
                if (diary.getId().equals(Long.parseLong(id)))
                    return true;
            }
        }
        return false;
    }
}

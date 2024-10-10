package org.sopt.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DiaryRepository {
    private final Map<Long, String> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    void save(final Diary diary) {
        final long id = numbering.addAndGet(1); //DB의 역할 - 채번 과정
        storage.put(id, diary.getBody()); //key-value 로 넣기 - 저장 과정
    }

    List<Diary> findAll() {
        //(1) diary 를 담을 자료구조
        final List<Diary> diaryList = new ArrayList<>();
        //(2) 저장한 값을 불러오는 반복 구조
        for(long index = 1; index <= numbering.intValue(); index++) {
            final String body = storage.get(index);
            //(2-1) 불러온 값을 구성한 자료구조로 이관
            if(body != null)
                diaryList.add(new Diary(index, body));
        }
        //(3) 저장한 자료구조 응답
        return diaryList;
    }

    void delete(final String id) {
        long parseId = Long.parseLong(id);
        storage.remove(parseId);
    }

    void update(final String id, final String body) {
        long parseId = Long.parseLong(id);
        storage.put(parseId, body);
    }
}

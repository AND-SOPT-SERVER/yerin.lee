package com.sopt_server.seminar.api.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record DiaryGetResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt
) {
}

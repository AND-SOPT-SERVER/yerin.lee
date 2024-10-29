package com.sopt_server.seminar.api.dto.response;

import lombok.Builder;

@Builder
public record DiaryListGetResponse(
        Long id,
        String title
) {
}

package com.sopt_server.seminar.api.dto.request;

import jakarta.validation.constraints.Size;

public record DiaryPatchRequest(
        @Size(max = 30)
        String content
) {
}

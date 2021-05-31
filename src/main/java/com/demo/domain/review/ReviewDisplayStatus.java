package com.demo.domain.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReviewDisplayStatus {
    DISPLAY("노출"),
    OPERATOR_BLOCK("운영 차단"),
    TEMPORARY_BLOCK("임시 차단"),
    ABUSE_BLOCK("어뷰저 차단"),
    MEMBER_NICKNAME_BLOCK("닉네임 차단된 회원 차단"),
    DELETED("리뷰 삭제");

    private final String desc;

}
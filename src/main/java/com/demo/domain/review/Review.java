package com.demo.domain.review;

import com.demo.domain.product.Product;
import com.demo.web.domain.posts.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name = "review")
@Entity
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private Long id;

    @Column(name = "memberNumber")
    private String memberNumber;

    @Column(name = "productId", updatable = false, insertable = false)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "purchaseCount")
    private int purchaseCount;

    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    private Review(String memberNumber, Long productId, String content, int score, int purchaseCount) {
        this.memberNumber = memberNumber;
        this.productId = productId;
        this.content = content;
        this.score = score;
        this.purchaseCount = purchaseCount;
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }


    public static Review of(ReviewRegister register) {
        return Review.builder()
                .productId(register.getProductId())
                .content(register.getContent())
                .score(register.getScore())
                .build();
    }
}

package com.example.xiyouji.quiz.vo;



import com.example.xiyouji.quiz.dto.QuizDto;
import com.example.xiyouji.type.Characters;
import com.example.xiyouji.type.Language;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED) // 상속 전략 설정
@DiscriminatorColumn(name = "type") // 상속받는 클래스를 구분하는 컬럼
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private Characters characterType;

    private String quizContent;

    private Language language;

    @Builder
    public Quiz(Long id, Characters characterType, String quizContent, Language language) {
        this.id = id;
        this.characterType = characterType;
        this.quizContent = quizContent;
        this.language = language;
    }

    public abstract QuizDto.QuizResponseDto toQuizResponse();
}

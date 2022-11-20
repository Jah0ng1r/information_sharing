package uz.tuitfb.exportdata.domain.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class QuizModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long owner_id;
    private String question;
    private String value0;
    private String value1;
    private String value2;
    private String value3;

    public QuizModel(Long owner_id, String question, String value0, String value1, String value2, String value3) {
    }
}

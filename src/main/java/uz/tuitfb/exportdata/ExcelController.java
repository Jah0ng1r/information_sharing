package uz.tuitfb.exportdata;

import lombok.AllArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uz.tuitfb.exportdata.domain.Model.QuizModel;

import java.io.IOException;


@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class ExcelController {
    public QuizModel quizModel;

    Long owner_id;
    String question;
    String value0;
    String value1;
    String value2;
    String value3;


    @PostMapping("/excel")
    public String excelReader(@RequestParam("file") MultipartFile excel) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int k = 1; k < sheet.getPhysicalNumberOfRows(); k++) {
                XSSFRow row;
                for (int i = 0; i <= k; i++) {

                    if (i == k) {
                        row = sheet.getRow(i);

                        for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {


                            owner_id = Long.valueOf(1);
                            if (j == 0) {
                                System.out.print(row.getCell(j) + " ");
                                question = String.valueOf(row.getCell(j));
                            } else if (j == 1) {
                                System.out.print("* " + row.getCell(j));
                                value0 = String.valueOf("*" + row.getCell(j));
                            } else if (j == 2) {
                                value1 = String.valueOf(row.getCell(j));
                            } else if (j == 3) {
                                value2 = String.valueOf(row.getCell(j));
                                System.out.print(row.getCell(j));
                            } else if (j == 4) {
                                value3 = String.valueOf(row.getCell(j));
                            }
                            quizModel = new QuizModel(owner_id, question, value0, value1, value2, value3);


                        }

                        System.out.println(">.....................................<");

                    }

                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Success";
    }

    @GetMapping("/quiz")
    public ResponseEntity sendQuiz() {
        return ResponseEntity.ok(quizModel);

    }

}

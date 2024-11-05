package ru.ChernomortsevEgor.NauJava.task7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Контроллер для работы с отчетами.
 * Предоставляет методы для создания и получения отчетов.
 */
@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportServiceImpl reportService;

    @Autowired
    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }


    @PostMapping("/create")
    public ResponseEntity<Long> createReport() {
        Long reportId = reportService.createReport();
        reportService.generateReport(reportId);
        return new ResponseEntity<>(reportId, HttpStatus.CREATED);
    }


    @GetMapping("/report/{id}")
    public ResponseEntity<String> getReportContent(@PathVariable Long id) {
        try {
            Report report = reportService.getReport(id);
            if (report.getStatus() == Status.Created) {
                return new ResponseEntity<>("Отчет еще не сформирован", HttpStatus.PROCESSING);
            } else if (report.getStatus() == Status.Error) {
                return new ResponseEntity<>("Формирование отчета завершилось с ошибкой", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(report.getDescription(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


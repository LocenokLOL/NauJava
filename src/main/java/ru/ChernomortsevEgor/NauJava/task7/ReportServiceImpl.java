package ru.ChernomortsevEgor.NauJava.task7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import ru.ChernomortsevEgor.NauJava.repository.UserRepository;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final SpringTemplateEngine templateEngine;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, UserRepository userRepository,
                             SpringTemplateEngine templateEngine) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.templateEngine = templateEngine;
    }

    @Override
    public Report getReport(Long reportId) throws Exception {
        Report report = reportRepository.findById(reportId).orElse(null);
        if (report == null)
        {
            throw new Exception("Отчет не найден");
        }
        return report;
    }
    @Override
    public Long createReport ()
    {
        Report report = new Report();
        report.setStatus(Status.Created);
        reportRepository.save(report);
        return report.getId();
    }

    @Override
    public void generateReport(Long reportId) {
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
        Report report = null;
        try {
            report = getReport(reportId);
            AtomicLong customerCountTime = new AtomicLong();
            AtomicLong entriesTime = new AtomicLong();

            long startTime;

            CompletableFuture<Long> customerCountFuture = CompletableFuture.supplyAsync(() -> {
                long start = System.currentTimeMillis();
                long count = userRepository.count();
                customerCountTime.set(System.currentTimeMillis() - start);
                return count;
            });
            startTime = System.currentTimeMillis();
            Long customerCount = customerCountFuture.join();


            long elapsed = System.currentTimeMillis() - startTime;

            Context context = new Context();
            context.setVariable("totalTime", elapsed);
            context.setVariable("customerCount", customerCount);
            context.setVariable("customerCountTime", customerCountTime);
            context.setVariable("entriesTime", entriesTime);

            String description = templateEngine.process("report", context);
            report.setDescription(description);

            if (customerCount > 0) {
                report.setStatus(Status.Done);
            } else {
                report.setStatus(Status.Error);
            }

        } catch (Exception e) {
            report.setStatus(Status.Error);
            report.setDescription("Ошибка при генерации отчета: " + e.getMessage());
        }

        reportRepository.save(report);
    });
        future.join();
    }
}

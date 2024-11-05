package ru.ChernomortsevEgor.NauJava.task7;

public interface ReportService {

    Report getReport(Long reportId) throws Exception;

    Long createReport();

    void generateReport(Long reportId);
}

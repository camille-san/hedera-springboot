package io.github.camillesan.hedera.services;

import io.github.camillesan.hedera.MockTestDataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class MonthReportServiceTest {
//
//    @Autowired
//    private MonthReportService monthReportService;
//    @Autowired
//    private MockTestDataService mock;
//
//    @PostConstruct
//    public void init() {
//        mock.init();
//    }
//
//    @DisplayName("Report shouldn't include single incomes and expenses not meant for requested month")
//    @Test
//    public void testDates() {
//        // We create a July report
//        MonthReport report = monthReportService.calculateMonth(1L, 7, 2022);
//
//        // Expense Christmas Gift shouldn't be present
//        assertFalse(report.getExpenses().stream().anyMatch(e -> e.getLabel().equals(mock.CHRISTMAS_EXPENSE)));
//        // Income Easter April gift shouldn't be present
//        assertFalse(report.getIncomes().stream().anyMatch(i -> i.getLabel().equals(mock.APRIL_BONUS)));
//        // Income Summer July gift should be present
//        assertTrue(report.getIncomes().stream().anyMatch(i -> i.getLabel().equals(mock.JULY_BONUS)));
//    }
//
//    @DisplayName("Report of one user shouldn't include incomes or expenses from another user")
//    @Test
//    public void testUsers() {
//        // We create a report for user 1
//        MonthReport report = monthReportService.calculateMonth(1L, 7, 2022);
//
//        // User 2 Expense shouldn't be present
//        assertFalse(report.getExpenses().stream().anyMatch(e -> e.getLabel().equals(mock.USER2_EXPENSE)));
//        // User 2 Income shouldn't be present
//        assertFalse(report.getIncomes().stream().anyMatch(i -> i.getLabel().equals(mock.USER2_INCOME)));
//    }

}
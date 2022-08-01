package io.github.camillesan.hedera.restcontrollers.reports;

import io.github.camillesan.hedera.dto.MonthReport;
import io.github.camillesan.hedera.services.MonthReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reports")
@Slf4j
public class ReportRestController {

    @Autowired
    private MonthReportService monthReportService;

    @GetMapping(value = "/month")
    public MonthReport getMonthReportForUser(@RequestParam Long userId, @RequestParam int month, @RequestParam int year) {
        log.info("[REST] Month report requested for user: {}", userId);
        return monthReportService.calculateMonth(userId, month, year);
    }

}

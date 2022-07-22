package io.github.camillesan.hederabudget.restcontrollers;

import io.github.camillesan.hederabudget.entities.Month;
import io.github.camillesan.hederabudget.services.MonthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("month")
@Slf4j
public class MonthRestController {

    @Autowired
    MonthService monthService;

    @GetMapping(value = "/{name}")
    public Month requestNewMonth(@PathVariable("name") String name) {
        return monthService.requestNewMonth(name);
    }

    @GetMapping(value = "/uuid/{uuid}")
    public Month getMonthByUUID(@PathVariable("uuid") UUID uuid) {
        return monthService.getMonthByUUID(uuid);
    }

}

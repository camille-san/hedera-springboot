package io.github.camillesan.hedera;

import io.github.camillesan.hedera.entities.Periodicity;
import io.github.camillesan.hedera.entities.expenses.ExpenseType;
import io.github.camillesan.hedera.entities.expenses.RegularExpense;
import io.github.camillesan.hedera.entities.expenses.SingleExpense;
import io.github.camillesan.hedera.entities.incomes.IncomeType;
import io.github.camillesan.hedera.entities.incomes.RegularIncome;
import io.github.camillesan.hedera.entities.incomes.SingleIncome;
import io.github.camillesan.hedera.entities.users.User;
import io.github.camillesan.hedera.repositories.expenses.RegularExpenseRepository;
import io.github.camillesan.hedera.repositories.expenses.SingleExpenseRepository;
import io.github.camillesan.hedera.repositories.incomes.RegularIncomeRepository;
import io.github.camillesan.hedera.repositories.incomes.SingleIncomeRepository;
import io.github.camillesan.hedera.repositories.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@Slf4j
public class MockTestDataService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegularExpenseRepository regularExpenseRepository;
    @Autowired
    private SingleExpenseRepository singleExpenseRepository;
    @Autowired
    private RegularIncomeRepository regularIncomeRepository;
    @Autowired
    private SingleIncomeRepository singleIncomeRepository;

//
//    public final String USER1_EMAIL = "bruce.willis@email.com";
//    public final String USER1_PASSWORD = "password111";
//    public final String CHRISTMAS_EXPENSE = "Christmas Gift";
//    public final String APRIL_BONUS = "Easter Bonus";
//    public final String JULY_BONUS = "Summer Bonus";
//    public final String USER2_EXPENSE = "From user 2 expense";
//    public final String USER2_INCOME = "From user 2 income";
//
//    public void init() {
//        if (!userRepository.existsById(1L)) {
//            log.info("Test data initialization");
//            User testUser1 = new User();
//            testUser1.setFirstName("Bruce");
//            testUser1.setLastName("Willis");
//            testUser1.setEmail(USER1_EMAIL);
//            testUser1.setPassword(USER1_PASSWORD);
//            testUser1 = userRepository.save(testUser1);
//
//            User testUser2 = new User();
//            testUser2.setFirstName("Julia");
//            testUser2.setLastName("Roberts");
//            testUser2.setEmail("julia.roberts@email.com");
//            testUser2.setPassword("password2");
//            testUser2 = userRepository.save(testUser2);
//
//            RegularExpense re11 = new RegularExpense();
//            re11.setUser(testUser1);
//            re11.setLabel("Rent 1");
//            re11.setType(ExpenseType.RENT);
//            re11.setPeriodicity(Periodicity.MONTH);
//            re11.setStartDate(LocalDate.now());
//            re11.setAmount(new BigDecimal("1250.50"));
//            regularExpenseRepository.save(re11);
//            RegularExpense re12 = new RegularExpense();
//            re12.setUser(testUser1);
//            re12.setLabel("Groceries 1");
//            re12.setType(ExpenseType.FOOD);
//            re12.setPeriodicity(Periodicity.MONTH);
//            re12.setStartDate(LocalDate.now());
//            re12.setAmount(new BigDecimal("600"));
//            regularExpenseRepository.save(re12);
//            SingleExpense se11 = new SingleExpense();
//            se11.setUser(testUser1);
//            se11.setLabel(CHRISTMAS_EXPENSE);
//            se11.setType(ExpenseType.GIFT);
//            se11.setAmount(new BigDecimal("100"));
//            se11.setDate(LocalDate.of(2022, 12, 25));
//            singleExpenseRepository.save(se11);
//
//            RegularIncome ri11 = new RegularIncome();
//            ri11.setUser(testUser1);
//            ri11.setLabel("Salary");
//            ri11.setType(IncomeType.SALARY);
//            ri11.setPeriodicity(Periodicity.MONTH);
//            ri11.setStartDate(LocalDate.now());
//            ri11.setAmount(new BigDecimal("1700.50"));
//            regularIncomeRepository.save(ri11);
//
//            SingleIncome si11 = new SingleIncome();
//            si11.setUser(testUser1);
//            si11.setLabel(APRIL_BONUS);
//            si11.setType(IncomeType.GIFT);
//            si11.setAmount(new BigDecimal("100"));
//            si11.setDate(LocalDate.of(2022, 4, 1));
//            singleIncomeRepository.save(si11);
//
//            SingleIncome si12 = new SingleIncome();
//            si12.setUser(testUser1);
//            si12.setLabel(JULY_BONUS);
//            si12.setType(IncomeType.GIFT);
//            si12.setAmount(new BigDecimal("666"));
//            si12.setDate(LocalDate.of(2022, 7, 10));
//            singleIncomeRepository.save(si12);
//
//            RegularExpense re21 = new RegularExpense();
//            re21.setUser(testUser2);
//            re21.setLabel(USER2_EXPENSE);
//            re21.setType(ExpenseType.RENT);
//            re21.setPeriodicity(Periodicity.MONTH);
//            re21.setStartDate(LocalDate.now());
//            re21.setAmount(new BigDecimal("760"));
//            regularExpenseRepository.save(re21);
//
//            RegularIncome ri21 = new RegularIncome();
//            ri21.setUser(testUser2);
//            ri21.setLabel(USER2_INCOME);
//            ri21.setType(IncomeType.SALARY);
//            ri21.setPeriodicity(Periodicity.MONTH);
//            ri21.setStartDate(LocalDate.now());
//            ri21.setAmount(new BigDecimal("760"));
//        }
//    }

}

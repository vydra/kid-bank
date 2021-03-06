package com.learnwithted.kidbank.adapter.web;

import com.learnwithted.kidbank.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/spend")
public class SpendController extends TransactionController {

  @Autowired
  public SpendController(Account account) {
    super(account);
  }

  @GetMapping
  public String spendForm(Model model) {
    TransactionDto spendCommand = TransactionDto.createWithTodayDate();
    model.addAttribute("spendCommand", spendCommand);

    return "spend";
  }

  @PostMapping
  public String processSpendCommand(
                @Valid @ModelAttribute("spendCommand") TransactionDto spendDto,
                BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "spend";
    }

    int spendAmount = spendDto.amountInCents();
    LocalDateTime dateTime = spendDto.getDateAsLocalDateTime();

    account.spend(dateTime, spendAmount, spendDto.getDescription());

    return "redirect:" + AccountController.ACCOUNT_URL;
  }

}

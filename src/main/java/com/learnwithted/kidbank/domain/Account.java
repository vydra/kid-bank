package com.learnwithted.kidbank.domain;

import com.google.common.collect.ImmutableList;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface Account {
  int balance();

  void deposit(LocalDateTime transactionDateTime, int amount, String source);

  void spend(LocalDateTime transactionDateTime, int amount, String description);

  ImmutableList<Transaction> transactions();

  void load(List<Transaction> transactionsToLoad);

  int balanceUpTo(LocalDateTime localDateTime);

  Set<Goal> goals();

  void createGoal(String description, int targetAmount);
}

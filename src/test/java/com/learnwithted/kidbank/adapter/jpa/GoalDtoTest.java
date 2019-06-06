package com.learnwithted.kidbank.adapter.jpa;

import com.learnwithted.kidbank.domain.Goal;
import org.junit.Assert;
import org.junit.Test;

public class GoalDtoTest {

  @Test
  public void testAsGoal() {
    final Goal goal = new GoalDto().asGoal();

    Assert.assertNull(goal.getId());
    Assert.assertEquals(0, goal.targetAmount());
  }

  @Test
  public void testFrom() {
    final Goal goal = new Goal("a/b/c", 0);
    final GoalDto goalDto = GoalDto.from(goal);

    Assert.assertNull(goalDto.getId());
    Assert.assertEquals(0, goalDto.getTargetAmount());
    Assert.assertEquals("a/b/c", goalDto.getDescription());
  }

}

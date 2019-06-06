package com.learnwithted.kidbank.domain;

import org.junit.Assert;
import org.junit.Test;

public class PercentTest {

  @Test
  public void testToString() {
    Assert.assertEquals("100%",
            Percent.of(1).over(0).toString());
    Assert.assertEquals("50%",
            Percent.of(1).over(2).toString());
  }

  @Test
  public void testRoundToInteger() {
    Assert.assertEquals(100,
            Percent.of(2).over(0).roundToInteger());
    Assert.assertEquals(40,
            Percent.of(2).over(5).roundToInteger());
  }
}

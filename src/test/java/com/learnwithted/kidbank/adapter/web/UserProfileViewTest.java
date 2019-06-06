package com.learnwithted.kidbank.adapter.web;

import com.learnwithted.kidbank.domain.PhoneNumber;
import com.learnwithted.kidbank.domain.Role;
import com.learnwithted.kidbank.domain.UserProfile;
import org.junit.Assert;
import org.junit.Test;

public class UserProfileViewTest {

  @Test
  public void testOf() {
    final PhoneNumber phoneNumber = new PhoneNumber( "+16505551212");
    final UserProfile userProfile = new UserProfile(
            "Diffy", phoneNumber, "redacted@example.com", Role.KID);
    userProfile.setId(-1_000_000_000L);
    final UserProfileView userProfileView = UserProfileView.of(userProfile);

    Assert.assertEquals("redacted@example.com", userProfileView.getEmail());
    Assert.assertEquals("+16505551212", userProfileView.getPhoneNumber());
    Assert.assertEquals("Kid", userProfileView.getRole());
    Assert.assertEquals("Diffy", userProfileView.getName());
    Assert.assertEquals("-1000000000", userProfileView.getId());
  }
}

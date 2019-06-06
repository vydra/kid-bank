package com.learnwithted.kidbank.adapter.jpa;

import com.learnwithted.kidbank.domain.PhoneNumber;
import com.learnwithted.kidbank.domain.Role;
import com.learnwithted.kidbank.domain.UserProfile;
import org.junit.Assert;
import org.junit.Test;

public class UserProfileDtoTest {

  @Test
  public void testFrom() {
    final PhoneNumber phoneNumber = new PhoneNumber( "+16505551212");
    final UserProfile userProfile = new UserProfile(
            "Diffy", phoneNumber,"redacted@example.com", Role.PARENT);
    userProfile.setId(-1_000_000_000L);
    final UserProfileDto userProfileDto = UserProfileDto.from(userProfile);

    Assert.assertEquals("redacted@example.com", userProfileDto.getEmail());
    Assert.assertEquals("Diffy", userProfileDto.getName());
    Assert.assertEquals("PARENT", userProfileDto.getRole());
    Assert.assertEquals("+16505551212", userProfileDto.getPhone());
    Assert.assertNotNull(userProfileDto.getId());
  }

}

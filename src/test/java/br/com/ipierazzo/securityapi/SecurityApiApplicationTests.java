package br.com.ipierazzo.securityapi;

import br.com.ipierazzo.securityapi.model.PasswordRequest;
import br.com.ipierazzo.securityapi.service.PasswordService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApiApplicationTests {
	@Autowired
	PasswordService passwordService;

	@Test
	@DisplayName("Testing a empty password")
	void PasswordTestEmpty() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a password without a uppercase character")
	void PasswordTestWithoutUpperCase() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("abcd@1234");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a password without a numerical character")
	void PasswordTestWithoutNumber() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("Abcd@a");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a password without a special character")
	void PasswordTestWithoutSpecialCharacter() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("Abcd1a");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a password containing a blank space")
	void PasswordTestWithSpace() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("abcd@ 1234");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a password with repeated characters")
	void PasswordTestWithRepeatedCharacters() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("AbTp9!foo");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a password containing a invalid special character like |")
	void PasswordTestWithInvalidSpecialCharacter() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("AbTp9|fo");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a password containing a invalid length < 9")
	void PasswordTestWithInvalidLength() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("AbTp9@fo");

		Assert.assertEquals(false, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a valid password AbTp9!fok")
	void PasswordTestWithValidPasswordCase1() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("AbTp9!fok");

		Assert.assertEquals(true, passwordService.validatePassword(request).getValid());
	}

	@Test
	@DisplayName("Testing a valid password NaxP@wd12")
	void PasswordTestWithValidPasswordCase2() {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("NaxP@wd12");

		Assert.assertEquals(true, passwordService.validatePassword(request).getValid());
	}



}

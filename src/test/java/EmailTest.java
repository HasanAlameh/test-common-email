package org.apache.commons.mail;

import static org.junit.Assert.*;

public class EmailTest{
    public static String[] TEST_EMAILs = {"abcdef@gmail.com", "124c@b.com", "fff@c.a"};

    EmailConcrete email;

    @Before
	public void setUpEmailTest() throws Exception{
		//All the common methods needed for more than one test are added here in @Before to clean the code
		email = new EmailConcrete();
		email.addBcc(TEST_EMAILS);
		email.addCc(TEST_EMAILS[0]);
		email.addReplyTo(TEST_EMAILS[1], "SampleName");
		email.addHeader("NameTest", "ValueTest");
		email.setContent(new MimeMultipart());
		email.setContent(new Object(), "SampleType");
		email.setHostName("TestHostName");
	}

    @After
	public void tearDownEmailTest() throws Exception{}

    //Simple test for adding an array of emails to BCC
	@Test
	public void testAddBcc() throws Exception{
		assertEquals(3, email.getBccAddresses().size());
	}
	
	//Testing adding one email using addCc()
	@Test
	public void testAddCc() throws Exception{
		assertEquals(1, email.getCcAddresses().size());
	}

    //Testing addHeader()
	//Since we are testing for a thrown exception we could use the expected attribute of @Test
	@Test
	public void testAddHeader() throws Exception{
		//First we test a successful run of addHeader() with no empty or null strings
		assertEquals(1, email.headers.size());
		//For more coverage we test for empty argument
		boolean exceptionThrown = false;
		//We try to catch the exception thrown and assert
		//This is one way of asserting for exceptions
		//Another way can be using the "expected" attribute with @Test
		try {
			email.addHeader("", "SampleValue");
		} catch (IllegalArgumentException ex){
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
		//Now we try the test again for the second argument for 100% coverage
		exceptionThrown = false;
		try {
			email.addHeader("SampleName", "");
		} catch (IllegalArgumentException ex) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}
}
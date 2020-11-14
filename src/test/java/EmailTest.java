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
}
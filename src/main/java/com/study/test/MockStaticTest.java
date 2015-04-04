/*
 * MockStaticTest.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.test;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Job.class)
public class MockStaticTest {

  @Test
  public void testMockMethod() {
      Job job = EasyMock.createMock(Job.class);
      String jobName = "owen";
      EasyMock.expect(job.getName()).andReturn(jobName);
      EasyMock.replay(job);

      Person person = new Person(123, "testName", job);
      Assert.assertEquals(person.getJobName(), jobName);
  }

  @Test
  public void testStatic() {
      Job job = EasyMock.createMock(Job.class);
      int expectId = 1234;
      PowerMock.mockStatic(Job.class);
      EasyMock.expect(Job.generateId()).andReturn(expectId);
      PowerMock.replay(Job.class);

      Person person = new Person(123, "testName", job);

      Assert.assertEquals(person.getJobId(), expectId);
  }

  @Test
  public void testMix() {
      Job job = EasyMock.createMock(Job.class);
      int expectId = 1234;
      PowerMock.mockStatic(Job.class);
      EasyMock.expect(Job.generateId()).andReturn(expectId);
      PowerMock.replay(Job.class);
      String jobName = "owen";
      EasyMock.expect(job.getName()).andReturn(jobName);
      EasyMock.replay(job);

      Person person = new Person(123, "testName", job);

      Assert.assertEquals(person.getJobNamePrefixId(), expectId + jobName);
  }
}
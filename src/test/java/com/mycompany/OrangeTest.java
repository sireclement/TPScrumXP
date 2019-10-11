package com.mycompagny.app;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OrangeTest
{
  @Test
  public void test_hello_world()
  {
    System.out.printf("eL pSY cONGROO!\n");
    // setup
    {
      Orange orange = mock(Orange.class);
      when(orange.getPrice()).thenCallRealMethod();
      when(orange.getOrigin()).thenCallRealMethod();
      System.out.printf("getPrice()  -> %f\n", orange.getPrice());

      String origin = orange.getOrigin();
      System.out.printf("getOrigin() -> %s\n", origin);
      assertTrue("Origin is suposed to be null after allocation.", origin == null);
    }
  }
}

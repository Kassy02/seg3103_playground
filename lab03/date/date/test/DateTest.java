import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_tc01() {
    Date today = new Date(1700, 6, 20);
    Date expectedTomorrow = new Date(1700, 6, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc02() {
    Date today = new Date(2005, 4, 15);
    Date expectedTomorrow = new Date(2005, 4, 16);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc03() {
    Date today = new Date(1901, 7, 20);
    Date expectedTomorrow = new Date(1901, 7, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc04() {
    Date today = new Date(3456, 3, 27);
    Date expectedTomorrow = new Date(3456, 3, 28);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc05() {
    Date today = new Date(1500, 2, 17);
    Date expectedTomorrow = new Date(1500, 2, 18);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc06() {
    Date today = new Date(1700, 6, 29);
    Date expectedTomorrow = new Date(1700, 6, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc07() {
    Date today = new Date(1800, 11, 29);
    Date expectedTomorrow = new Date(1800, 11, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc08() {
    Date today = new Date(3453, 1, 29);
    Date expectedTomorrow = new Date(3453, 1, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc09() {
    Date today = new Date(444, 2, 29);
    Date expectedTomorrow = new Date(444, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc10() {
    Date today = new Date(2005, 4, 30);
    Date expectedTomorrow = new Date(2005, 5, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc11() {
    Date today = new Date(3453, 1, 30);
    Date expectedTomorrow = new Date(3453, 1, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc12() {
    Date today = new Date(3456, 3, 30);
    Date expectedTomorrow = new Date(3456, 3, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc13() {
    Date today = new Date(1901, 7, 31);
    Date expectedTomorrow = new Date(1901, 8, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc14() {
    Date today = new Date(3453, 1, 31);
    Date expectedTomorrow = new Date(3453, 2, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc15() {
    Date today = new Date(3456, 12, 31);
    Date expectedTomorrow = new Date(3457, 1, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_invalid_tc16() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 31)
    );
  }

  @Test
  void nextDate_invalid_tc17() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 29)
    );
  }

  @Test
  void nextDate_invalid_tc18() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(-1, 10, 20)
    );
  }

  @Test
  void nextDate_invalid_tc19() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1458, 15, 12)
    );
  }

  @Test
  void nextDate_invalid_tc20() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 6, -50)
    );
  }

  @Test
    void testLeapYear() {
        assertTrue(new Date(2020, 2, 29).isLeapYear());
        assertFalse(new Date(2021, 2, 28).isLeapYear());
        assertTrue(new Date(2000, 2, 29).isLeapYear());
        assertFalse(new Date(1900, 2, 28).isLeapYear());
    }

    @Test
    void testToString() {
        Date date = new Date(2024, 6, 6);
        assertEquals("2024/June/6", date.toString());
    }

    @Test
    void testEquals() {
        Date date1 = new Date(2024, 6, 6);
        Date date2 = new Date(2024, 6, 6);
        Date date3 = new Date(2024, 6, 7);

        assertTrue(date1.equals(date2));
        assertFalse(date1.equals(date3));
    }

    @Test
    void setDay_valid() {
        Date date = new Date(2024, 6, 6);
        date.setDay(15);
        assertEquals(15, date.getDay());
    }

    @Test
    void setDay_invalid() {
        Date date = new Date(2024, 6, 6);
        assertThrows(IllegalArgumentException.class, () -> date.setDay(0));
        assertThrows(IllegalArgumentException.class, () -> date.setDay(32));
        assertThrows(IllegalArgumentException.class, () -> date.setDay(31)); // June has 30 days
    }

    @Test
    void setMonth_valid() {
        Date date = new Date(2024, 6, 6);
        date.setMonth(12);
        assertEquals(12, date.getMonth());
    }

    @Test
    void setMonth_invalid() {
        Date date = new Date(2024, 6, 6);
        assertThrows(IllegalArgumentException.class, () -> date.setMonth(0));
        assertThrows(IllegalArgumentException.class, () -> date.setMonth(13));
    }

    @Test
    void setYear_valid() {
        Date date = new Date(2024, 6, 6);
        date.setYear(2025);
        assertEquals(2025, date.getYear());
    }

    @Test
    void setYear_invalid() {
        Date date = new Date(2024, 6, 6);
        assertThrows(IllegalArgumentException.class, () -> date.setYear(-1));
    }

    @Test
    void testIsEndOfMonth() {
        Date date1 = new Date(2024, 1, 31);
        assertTrue(date1.isEndOfMonth());
        
        Date date2 = new Date(2024, 2, 29); // leap year
        assertTrue(date2.isEndOfMonth());

        Date date3 = new Date(2021, 2, 28); // non-leap year
        assertTrue(date3.isEndOfMonth());
        
        Date date4 = new Date(2024, 4, 30); // 30-day month
        assertTrue(date4.isEndOfMonth());
        
        Date date5 = new Date(2024, 4, 29);
        assertFalse(date5.isEndOfMonth());
    }

    @Test
    void testIsThirtyDayMonth() {
        assertTrue(new Date(2024, 4, 1).isThirtyDayMonth());
        assertFalse(new Date(2024, 1, 1).isThirtyDayMonth());
    }
}
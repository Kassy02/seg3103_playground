import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_sample() {
    Date d = new Date(2020,5,3);
    assertEquals(new Date(2020,5,4), d.nextDate());
  }

  // Additional explicit test cases
  @Test
  public void nextDate_normal() {
      Date date = new Date(2023, 6, 20);
      Date expected = new Date(2023, 6, 21);
      assertEquals(expected, date.nextDate());
    }
    @Test
    public void nextDate_endOfMonth() {
        Date date = new Date(2023, 4, 30);
        Date expected = new Date(2023, 5, 1);
        assertEquals(expected, date.nextDate());
    }

    @Test
    public void nextDate_endOfYear() {
        Date date = new Date(2023, 12, 31);
        Date expected = new Date(2024, 1, 1);
        assertEquals(expected, date.nextDate());
    }

    @Test
    public void nextDate_leapYear() {
        Date date = new Date(2024, 2, 28);
        Date expected = new Date(2024, 2, 29);
        assertEquals(expected, date.nextDate());
    }

    @Test
    public void nextDate_nonLeapYear() {
        Date date = new Date(2023, 2, 28);
        Date expected = new Date(2023, 3, 1);
        assertEquals(expected, date.nextDate());
    }



}
public class DateNextDateExceptionTest
{
    @ParameterizedTest
    @CsvSource({
        "1500, 2, 31",
        "1500, 2, 29",
        "-1, 10, 20",
        "1458, 15, 12",
        "1975, 6, -50"
    })
    public void testNextDateException(int year, int month, int day) {
        Date date = new Date(year, month, day);
        assertThrows(IllegalArgumentException.class, date::nextDate);
    }

}
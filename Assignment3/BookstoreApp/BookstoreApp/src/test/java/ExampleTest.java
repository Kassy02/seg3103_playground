package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class ExampleTest {

    static Process server;
    private WebDriver driver;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
        server = pb.start();
    }

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        if (server != null) {
            server.destroy();
        }
    }

    @Test
    void makingSureJUnitConfigured() {
        assertEquals(1, 1);
    }

    @Test
    void testAdministratorSignInPositive() {
        driver.get("http://localhost:8080/admin");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("admin");
        password.sendKeys("password");
        driver.findElement(By.name("login")).click();
        assertEquals("http://localhost:8080/admin/home", driver.getCurrentUrl());
    }

    @Test
    void testAdministratorSignInNegative() {
        driver.get("http://localhost:8080/admin");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("wrong");
        password.sendKeys("wrong");
        driver.findElement(By.name("login")).click();
        WebElement error = driver.findElement(By.id("error"));
        assertEquals("Invalid credentials", error.getText());
    }

    @Test
    void testCustomerSignInPositive() {
        driver.get("http://localhost:8080/customer");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("customer");
        password.sendKeys("password");
        driver.findElement(By.name("login")).click();
        assertEquals("http://localhost:8080/customer/home", driver.getCurrentUrl());
    }

    @Test
    void testCustomerSignInNegative() {
        driver.get("http://localhost:8080/customer");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("wrong");
        password.sendKeys("wrong");
        driver.findElement(By.name("login")).click();
        WebElement error = driver.findElement(By.id("error"));
        assertEquals("Invalid credentials", error.getText());
    }

    @Test
    void testCustomerRegistration() {
        driver.get("http://localhost:8080/register");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement email = driver.findElement(By.name("email"));
        username.sendKeys("newcustomer");
        password.sendKeys("newpassword");
        email.sendKeys("newcustomer@example.com");
        driver.findElement(By.name("register")).click();
        WebElement success = driver.findElement(By.id("success"));
        assertEquals("Registration successful!", success.getText());
    }

    @Test
    void testBookSearch() {
        driver.get("http://localhost:8080/");
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Effective Java");
        searchBox.submit();
        WebElement bookTitle = driver.findElement(By.className("book-title"));
        assertEquals("Effective Java", bookTitle.getText());
    }

    @Test
    void testAddBookToCart() {
        driver.get("http://localhost:8080/");
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Effective Java");
        searchBox.submit();
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();
        WebElement cart = driver.findElement(By.id("cart"));
        assertTrue(cart.getText().contains("Effective Java"));
    }

    @Test
    void testCheckout() {
        driver.get("http://localhost:8080/");
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Effective Java");
        searchBox.submit();
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();
        driver.findElement(By.id("checkout")).click();
        WebElement checkoutMessage = driver.findElement(By.id("checkout-message"));
        assertEquals("Checkout successful!", checkoutMessage.getText());
    }
}
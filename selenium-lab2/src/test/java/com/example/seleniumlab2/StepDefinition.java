package com.example.seleniumlab2;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class StepDefinition {

    static WebDriver driver;



    @Given("SVT Play is available")
    public void svt_play_is_available() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);

        driver.get("https://www.svtplay.se/");
    }

    @When("User visits SVT Play")
    public void user_visits_svt_play() {
        driver.manage().window().maximize();
        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()= 'Acceptera alla']"));

        acceptCookies.click();
    }

    @Then("Title should be {string}")
    public void title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle, "Title does not match");
        driver.quit();
    }

    @Then("Logotype should be visible")
    public void logotype_should_be_visible() {

        boolean result = driver.findElement(By.className("sc-31022b15-0")).isDisplayed();

        Assertions.assertTrue(result, "Logotype is not visible");
        driver.quit();
    }

    @Then("Start menu text should be {string}")
    public void start_menu_text_should_be(String start) {

        WebElement startLink = driver.findElement(By.className("ilPmDY"));
        String startLinkText = startLink.getText();

        assertEquals(start, startLinkText, "Text does not match");
        driver.quit();
    }

    @Then("Program menu text should be {string}")
    public void program_menu_text_should_be(String program) {
        WebElement programLink = driver.findElement(By.xpath("//a[text() = 'Program']"));
        String programLinkText = programLink.getText();

        assertEquals(program, programLinkText, "Text does not match");
        driver.quit();
    }

    @Then("Chanel menu text should be {string}")
    public void chanel_menu_text_should_be(String kanaler) {
        WebElement chanelLink = driver.findElement(By.xpath("//a[text() = 'Kanaler']"));
        String chanelLinkText = chanelLink.getText();

        assertEquals(kanaler, chanelLinkText, "Text does not match");
        driver.quit();
    }

    @Then("Availability link text should be {string}")
    public void availability_link_text_should_be(String expectedText) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)")));

        WebElement availability = driver.findElement(By.cssSelector("div.sc-87f10045-7:nth-child(2) > p:nth-child(1) > a:nth-child(1) > span:nth-child(2)"));

        String availabilityText = availability.getText();

        assertEquals(expectedText, availabilityText, "Text does not match");
        driver.quit();
    }

    @When("User clicks on availability link")
    public void user_clicks_on_availability_link() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]")));

        WebElement availabilityLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]"));
        availabilityLink.click();
    }

    @Then("Heading should be {string}")
    public void heading_should_be(String quoteText) {
        String headingText = driver.findElement(By.xpath("//h1[text() = 'Så arbetar SVT med tillgänglighet']")).getText();

        assertEquals(quoteText, headingText,"Heading does not match");
        driver.quit();
    }

    @When("User clicks on program link")
    public void user_clicks_on_program_link() throws InterruptedException {
        Thread.sleep(5000);

        WebElement programLink = driver.findElement(By.xpath("//a[text() = 'Program']"));

        programLink.click();
    }

    @Then("Number of categories should be correct")
    public void number_of_categories_should_be_correct() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("sc-a9073dc0-0")));

        List<WebElement> categoryItems = driver.findElements(By.className("sc-a9073dc0-0"));

        assertEquals(17, categoryItems.size(), "The number of categories does not match");
        driver.quit();
    }

    @When("User clicks on chanels link")
    public void user_clicks_on_chanels_link() throws InterruptedException {
        Thread.sleep(5000);

        WebElement chanelLink = driver.findElement(By.xpath("//a[text() = 'Kanaler']"));

        chanelLink.click();
    }

    @Then("Heading text should be {string}")
    public void heading_text_should_be(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-c358b5df-0")));

        WebElement chanelHeading = driver.findElement(By.className("sc-c358b5df-0"));

        String chanelHeadingText = chanelHeading.getText();

        assertEquals(expectedText, chanelHeadingText, "Heading text does not match");
        driver.quit();
    }

    @Then("Link text should be {string}")
    public void link_text_should_be(String expectedLinkText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]")));

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));

        String newsLetterText = newsLetter.getText();

        assertEquals( expectedLinkText, newsLetterText,"The link text does not match");
        driver.quit();
    }

    @When("User clicks on newsletter")
    public void user_clicks_on_newsletter() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]")));

        WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));

        newsLetter.click();
    }

    @Then("Logotype on page should be visible")
    public void logotype_on_page_should_be_visible() {

        boolean logotype = driver.findElement(By.id("logo")).isDisplayed();

        Assertions.assertTrue(logotype, "Logotype is not visible");
        driver.quit();
    }

    @When("User is writing an invalid email adress")
    public void user_is_writing_an_invalid_email_adress() {

        WebElement emailInput = driver.findElement(By.id("email"));

        emailInput.sendKeys("emma");
        emailInput.sendKeys(Keys.ENTER);
    }

    @Then("The error message should be {string}")
    public void the_error_message_should_be(String emailErrorMessage) {

        WebElement errorMessage = driver.findElement(By.cssSelector("#error-messages > p:nth-child(1)"));

        String errorMessageText = errorMessage.getText();

        assertEquals(emailErrorMessage,errorMessageText,"Error message is not correct");
        driver.quit();
    }

    @Then("The terms checkbox should not be selected")
    public void the_terms_checkbox_should_not_be_selected() {

        WebElement terms = driver.findElement(By.id("terms"));

        Assertions.assertFalse(terms.isSelected());
        driver.quit();
    }

    //VG-uppgift

    @When("User is writing a search does not have a match")
    public void user_is_writing_a_search_does_not_have_a_match() throws InterruptedException {

        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys("fdjjl");
        searchField.sendKeys(Keys.ENTER);

    }

    @Then("Should show error message {string}")
    public void should_show_error_message(String errorSearch) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"play_main-content\"]/section/div/p[2]")));

        WebElement searchErrorMessage = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/section/div/p[2]"));

        String errorText = searchErrorMessage.getText();

        assertEquals(errorSearch, errorText, "Error message seems to be wrong");
        driver.quit();
    }

    @When("User writes no value in search field")
    public void user_writes_no_value_in_search_field() throws InterruptedException {

        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys("");
        searchField.sendKeys(Keys.ENTER);

    }

    @Then("Correct error message should be {string}")
    public void correct_error_message_should_be(String expectedText) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"play_main-content\"]/section/div/p[2]")));

        WebElement nonValueError = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/section/div/p[2]"));

        String nonValueErrorText = nonValueError.getText();

        assertEquals(expectedText,nonValueErrorText, "Error message seems to be wrong");
        driver.quit();
    }

    @When("User writes a valid value in search field")
    public void user_writes_a_valid_value_in_search_field() throws InterruptedException {

        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys("Agenda");
        searchField.sendKeys(Keys.ENTER);

    }

    @Then("Search result should be {string}")
    public void search_result_should_be(String expectedSearchResult) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a/div[2]/h2/span/em")));

        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a/div[2]/h2/span/em"));

        String searchResultText = searchResult.getText();

        assertEquals(expectedSearchResult, searchResultText, "Search text does not match");
        driver.quit();
    }

    @When("User clicks on Agenda link")
    public void user_clicks_on_agenda_link() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a/div[2]/h2/span/em")));

        WebElement agendaLink = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a/div[2]/h2/span/em"));

        agendaLink.click();
    }

    @Then("Button should show text {string}")
    public void button_should_show_text(String expectedText) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fzhhQU")));

        WebElement showMoreButton = driver.findElement(By.className("fzhhQU"));

        String buttonText = showMoreButton.getText();

        assertEquals(expectedText,buttonText, "Button text does not seem to match");
        driver.quit();
    }

    @Then("Aria label should be displayed")
    public void aria_label_should_be_displayed() {

        WebElement ariaLabel = driver.findElement(By.xpath("//section[contains (@aria-label, 'Rekommenderat')]"));

        boolean result = ariaLabel.isDisplayed();

        Assertions.assertTrue(result, "Aria label is not displayed");
        driver.quit();
    }

    @Then("Text should be {string}")
    public void text_should_be(String expectedText) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#play_main-content > div > section:nth-child(1) > section > article:nth-child(1) > a > h2 > span")));

        WebElement categoriesSerie = driver.findElement(By.cssSelector("#play_main-content > div > section:nth-child(1) > section > article:nth-child(1) > a > h2 > span"));

        String categoriesSerieText = categoriesSerie.getText();

        assertEquals(expectedText, categoriesSerieText, "Text does not match");
        driver.quit();
    }

    @When("User clicks on category link")
    public void user_clicks_on_category_link() throws InterruptedException {

        Thread.sleep(2000);

        WebElement category = driver.findElement(By.cssSelector("#play_main-content > div > section:nth-child(1) > section > article:nth-child(1) > a > h2 > span"));

        category.click();
    }

    @Then("Correct text should be displayed")
    public void correct_text_should_be_displayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-6b1c5b48-1")));

        WebElement serieText = driver.findElement(By.className("sc-6b1c5b48-1"));

        boolean result = serieText.isDisplayed();

        Assertions.assertTrue(result, "Text is not visible");
        driver.quit();
    }

    @Then("Settings link should be visible")
    public void settings_link_should_be_visible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-5b00349a-5")));

        WebElement settingsLink = driver.findElement(By.className("sc-5b00349a-5"));

        boolean result = settingsLink.isDisplayed();

        Assertions.assertTrue(result, "Settings link is not visible");
        driver.quit();
    }





}

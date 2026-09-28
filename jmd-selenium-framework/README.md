# JMD Service – Selenium Test Automation Framework

Java + Selenium 4 + TestNG + Page Object Model + Allure Reporting, with
automatic screenshot capture on test failure.

Target site: https://jmdservice.com/

## Tech stack
- Java 11
- Selenium 4.21 (Selenium Manager auto-resolves the ChromeDriver/GeckoDriver binary — nothing to download manually)
- TestNG 7.10
- Allure 2.29 (`allure-testng` adapter)
- Maven

## Project layout
Flat, Eclipse-style package folders — one folder per package, no nested
`com/jmd/automation/...` chain:
```
src/main/java/
  base/        package base;       DriverFactory (thread-safe WebDriver), BaseTest (setUp/tearDown)
  utils/       package utils;      ConfigReader, WaitUtils (ALL waits + scroll helpers live here), ScreenshotUtils
  listeners/   package listeners;  TestListener (ITestListener -> screenshot on failure -> Allure attachment)
  pages/       package pages;      BasePage + one page object per page (Home, Training, Blog, About, Contact)

src/test/java/
  tests/       package tests;      HomePageTest, TrainingPageTest, BlogPageTest, AboutPageTest, ContactPageTest

src/test/resources/config.properties   <- URLs, browser, timeouts
testng.xml                              <- suite definition + listeners
```

This is the classic Eclipse "New Java Project" layout: right-click
`src/main/java` → New → Package → `base` / `utils` / `pages` / `listeners`,
and `src/test/java` → New → Package → `tests`. No package nests inside
another package's folder.

## What each test validates
| Page | Test |
|---|---|
| Home | Scrolls to "Popular Courses" and asserts **Advanced Microsoft Office**, **MS Excel & MS Word**, **Power Point & Power BI** are each visible |
| Training | Scrolls to and validates the **"Our Training Philosophy"** heading and its accompanying image |
| Blog | Scrolls to the sidebar and validates the **search field** is visible and enabled |
| About | Finds every **"Read More"** element and asserts each is displayed, enabled, and clickable |
| Contact | Validates the **phone number**, **email**, and **corporate office address** are all present |

> Note: the real course headings on the live site are "Advanced Microsoft
> Office", "MS Excel & MS Word", and "Power Point & Power BI" (combined, not
> 4 separate names) — the tests use the exact live text so locators don't
> silently fail.

## Setup
1. Install JDK 11+ and Maven.
2. Install Google Chrome (default browser in config). Selenium Manager
   downloads the matching driver automatically on first run — no
   WebDriverManager dependency needed.
3. `mvn clean install` (first run will download dependencies).

## Running the tests
```bash
mvn clean test
```
Run with a different browser (chrome/firefox/edge):
```bash
mvn clean test -Dbrowser=firefox
```
Run headless:
```bash
mvn clean test -Dheadless=true
```

## Viewing the Allure report
```bash
mvn allure:serve
```
This builds the report from `target/allure-results` and opens it in your
browser. Any failed test will have its screenshot and page-source attached
directly on the failed step.

Screenshots are also saved to `test-output/screenshots/` regardless of Allure,
named `<testName>_<timestamp>.png`.

## Design notes
- **WaitUtils** (`utils/WaitUtils.java`) is the single utility class holding
  every explicit wait (`waitForVisibility`, `waitForClickable`,
  `waitForPresence`, `waitForPageLoad`) and every scroll operation
  (`scrollToElement`, `scrollByPixels`, `scrollToBottom/Top`,
  `scrollAndVerifyVisible`). Every page object shares this one utility rather
  than calling `WebDriverWait`/`JavascriptExecutor` directly, so
  wait/scroll behavior is tuned in exactly one place.
- **DriverFactory** uses a `ThreadLocal<WebDriver>` so the suite is already
  safe to switch to parallel execution later (just change `parallel="methods"`
  in `testng.xml`) without touching test code.
- **TestListener** implements `ITestListener` and hooks `onTestFailure` to
  pull a screenshot from whatever `WebDriver` is live in that thread and
  attach it to Allure — no changes needed in individual test methods to get
  screenshots on failure.
- Locators favor visible text (`contains(text(), '...')`) and stable
  attributes (image `src`, `href` patterns) over CSS classes, since this is a
  WordPress theme where class names can change with theme updates.

## Extending
- Add a new page: create `pages/XPage.java` extending `BasePage`, add its URL
  to `config.properties` + `ConfigReader`, write `tests/XPageTest.java`
  extending `BaseTest`, add it to `testng.xml`.

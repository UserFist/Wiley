package Wiley.tests;

import Wiley.pages.HomePage;

import java.util.*;

public class MainTest extends BaseTest {
    private static final List<String> NAVIGATION_MENU_EXPECTED = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");
    private static final List<String> MENU_ITEMS_EXPECTED = Arrays.asList("Students", "Authors", "Instructors", "Librarians", "Societies",
            "Conferences", "Booksellers", "Corporations", "Institutions");
    private static final String STUDENTS_LINK_EXPECTED = "http://eu.wiley.com/WileyCDA/Section/id-404702.html";
    private static final List<String> MENU_ON_THE_LEFT_EXPECTED = Arrays.asList("Authors", "Librarians", "Booksellers", "Instructors",
            "Students","Government Employees", "Societies", "Corporate Partners");
    private static final String ALERT_TEXT_IF_ENTRY_NOTHING_EXPECTED = "Please enter email address";
    private static final String ALERT_TEXT_IF_ENTRY_INCORRECTLY = "Invalid email address.";
    private static final String EMPTY_STRING = "";
    private static final String INVALID_EMAIL = "test.test.com";
    private static final String KEY_FOR_SEARCH = "for dummies";
    private static final String STUDENT_HEADER_EXPECTED = "Students";
    private static final String URL_INSTITUTION_EXPECTED = "https://edservices.wiley.com/";

    public void test() {

        HomePage homePage = new HomePage();
        navigateTo("http://eu.wiley.com/WileyCDA/Section/index.html");

        homePage.checkNavigationMenu(NAVIGATION_MENU_EXPECTED)
                .checkResourcesItemsTitle(MENU_ITEMS_EXPECTED)
                .clickStudentLink()
                .checkStudentsLink(STUDENTS_LINK_EXPECTED)
                .checkStudentHeader(STUDENT_HEADER_EXPECTED)
                .checkMenuOnTheLeft(MENU_ON_THE_LEFT_EXPECTED)
                .studentsItemStyleAndClickable()
                .clickHome()
                .checkEmailAddressFieldByEmail(EMPTY_STRING, ALERT_TEXT_IF_ENTRY_NOTHING_EXPECTED)
                .checkEmailAddressFieldByEmail(INVALID_EMAIL, ALERT_TEXT_IF_ENTRY_INCORRECTLY)
                .checkSearchField(KEY_FOR_SEARCH)
                .checkSearchResultListIsNotEmpty()
                .clickAndSetBookTitle()
                .checkHeaderEqualToTheTitle()
                .clickHome()
                .clickInstitutions()
                .switchOnInstitutionTab()
                .checkLinkOnTab(URL_INSTITUTION_EXPECTED);
    }

}




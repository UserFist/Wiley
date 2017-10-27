package Wiley.tests;

import Wiley.pages.HomePage;
import Wiley.pages.InstitutionsPage;
import Wiley.pages.SearchResultPage;

import java.util.Arrays;
import java.util.List;

public class MainTest extends BaseTest {
    private static final List<String> NAVIGATION_MENU_EXPECTED = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");
    private static final List<String> MENU_ITEMS_EXPECTED = Arrays.asList("Students", "Authors", "Instructors", "Librarians", "Societies",
            "Conferences", "Booksellers", "Corporations", "Institutions");
    private static final String STUDENTS_LINK_EXPECTED = "http://eu.wiley.com/WileyCDA/Section/id-404702.html";
    private static final List<String> MENU_ON_THE_LEFT_EXPECTED = Arrays.asList("Authors", "Librarians", "Booksellers", "Instructors",
            "Students",/*"Government Employees",*/ "Societies", "Corporate Partners");
    private static final String ALERT_TEXT_IF_ENTRY_NOTHING_EXPECTED = "Please enter email address";
    private static final String ALERT_TEXT_IF_ENTRY_INCORRECTLY = "Invalid email address.";
    private static final String EMPTY_STRING = "";
    private static final String INVALID_EMAIL = "test.test.com";
    private static final String KEY_FOR_SEARCH = "for dummies";
    private static final String STUDENT_HEADER_EXPECTED = "Students";
    private static final String URL_INSTITUTION_EXPECTED = "https://edservices.wiley.com/";

    public void test() {
        //step 1
        navigateTo("http://eu.wiley.com/WileyCDA/Section/index.html");

        HomePage homePage = new HomePage();
        InstitutionsPage institutions = new InstitutionsPage();
        SearchResultPage searchResultPage = new SearchResultPage();
        homePage.checkNavigationMenu(NAVIGATION_MENU_EXPECTED);
        homePage.checkResourcesItemsTitle(MENU_ITEMS_EXPECTED);
        homePage.clickStudentLink()
                .checker().checkStudentsLink(STUDENTS_LINK_EXPECTED)
                .checkStudentHeader(STUDENT_HEADER_EXPECTED)
                .checkMenuOnTheLeft(MENU_ON_THE_LEFT_EXPECTED)
                .studentsItemStyleAndClickable()
                .clickHome()
                .checkEmailAddressFieldByEmail(EMPTY_STRING, ALERT_TEXT_IF_ENTRY_NOTHING_EXPECTED);
        homePage.checkEmailAddressFieldByEmail(INVALID_EMAIL, ALERT_TEXT_IF_ENTRY_INCORRECTLY);
        homePage.checkSearchField(KEY_FOR_SEARCH)
                .checkSearchResultListIsNotEmpty();
        searchResultPage.clickAndSetBookTitle()
                .checkHeaderEqualToTheTitle()
                .clickHome()
                .clickInstitutions();
        homePage.switchOnTab();
        institutions.checkLinkOnTab(URL_INSTITUTION_EXPECTED);
    }

}




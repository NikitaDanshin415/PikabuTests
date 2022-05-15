package tests;


import org.junit.jupiter.api.Test;
import tools.pageobjects.CommunitiesPage;
import tools.pageobjects.HomePage;

import java.util.Enumeration;
import java.util.Properties;


public class PikabuTests  {
//    public class PikabuTests extends BaseTest {
    HomePage homePage = new HomePage();
    CommunitiesPage communitiesPage = new CommunitiesPage();
    String communityName = "Лига тестировщиков";

    @Test
    void printCreads() {
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = (String)p.get(key);
            System.out.println(key + ": " + value);
        }
    }

//    @Test
//    @DisplayName("Проверка шапки сайта")
//    void headerElementsTest() {
//        homePage
//            .getHeader()
//            .checkHeaderElementsSize()
//            .headerHaveHotItem()
//            .headerHaveBestItem()
//            .headerHaveNewItem()
//            .headerHaveSubsItem()
//            .headerHaveCommunitiesItem()
//            .headerHaveCompaniesItem();
//    }
//
//    @Test
//    @DisplayName("Проверка поиска сообщества")
//    void searchTest() {
//        step("Переходим на страницу 'Сообщества'", () -> {
//            homePage
//                .getHeader()
//                .openCommunities();
//        });
//
//
//        step("Проверяем работу поиска сообщества", () -> {
//            communitiesPage
//                .search(communityName);
//        });
//    }
//
//    @Test
//    @Disabled
//    void currentArticleEmotionTest() {
//
//    }
//
//    @Test
//    @Disabled
//    void articleTest() {
//
//    }
}
package OLD_junitTests;

import drivers.DriverProvider;
import org.junit.*;
import pages.ing.IngPersonalAccountPage;

import java.math.BigDecimal;

public class IngBasicTests {

    @BeforeClass
    public static void init() {
        System.out.println("Starting all from this ING class tests...");
    }

    @Before
    public void initEachTest() {
        System.out.println("Starting particular test from ING testing suite...");
    }

    @Test
    public void ingPersonalAccountBalanceEquals() {
        IngPersonalAccountPage ingPage = new IngPersonalAccountPage();
        ingPage.open();
        Assert.assertEquals(new BigDecimal("2025.00"), ingPage.getPersonalAccountBalance());
    }

    // TODO test na oszczędnosci.
    //       - na początek - czy są równe 12804,62 (mind -> IT raczej nie używa , do notacji miejsc dziesiętnych)
    @Test
    public void ingPersonalAccountSavingsEquals() {
        IngPersonalAccountPage ingPage = new IngPersonalAccountPage();
        ingPage.open();
        Assert.assertEquals(new BigDecimal("12804.62"), ingPage.getPersonalSavingsBalance());
    }


    // TODO test na kart i płatności telefonem
    //       - na początek - czy są równe, no ile tam jest na stronie.
    //       - rozwinięcie - dodać metodę (tam gdzie dodajemy metody potencjalnie re-używane w wielu testach;)) na porównywanie dwóch BigDecimal i jej użyć w .assertTrue(...)

    @Test
    public void ingPersonalInvestmentLocalBalanceEquals() {
        IngPersonalAccountPage ingPage = new IngPersonalAccountPage();
        ingPage.open();
        Assert.assertEquals(new BigDecimal("1850.00"), ingPage.getPersonalInvestmentLocalBalance());
    }

    // TODO test fundusz w USD
    //      - na początek - na wzór tego co jest w PLN, czyli tak jak wszędzie wcześniej
    //      - rozwinięcie - zaimplementować i użyć pages.ing.IngPersonalAccountPage.getPersonalInvestmentBalanceOfGivenCurrency() (komentarz tam)

    @After
    public void after() {
        System.out.println("A ING test finished, closing driver...");
        DriverProvider.flush();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All ING tests finished.");
    }
}

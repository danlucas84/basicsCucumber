package steps.ing;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.ing.IngPersonalAccountPage;

import java.math.BigDecimal;

public class IngSteps {

    private final IngPersonalAccountPage ingPage = new IngPersonalAccountPage();

    @And("User opens Ing Personal Account page")
    public void openIngAccountPage() {
        ingPage.open();
    }

    @And("Personal Monthly Expenditure equals {}")
    public void monthlySpendingEquals(final String expectedValue) {
//        final BigDecimal spendingFromPage = ingPage.getMonthSpending();
//        final BigDecimal spendingExpected = new BigDecimal(expectedValue);
//        Assert.assertEquals(spendingFromPage, spendingExpected);
//        ekwiwalent powyższego w jednej linijce:
        Assert.assertEquals(ingPage.getMonthSpending(), new BigDecimal(expectedValue));
    }

    @And("{} Balance equals {}")
    public void givenAccountBalanceEquals(final String balanceType, final String expectedBalance) {
        // better approach - create an enum for balanceTypes
        final BigDecimal balance;
        switch (balanceType) {
            case "Personal":
                balance = ingPage.getPersonalAccountBalance();
                break;
            case "Savings":
                balance = ingPage.getPersonalSavingsBalance();
                break;
            case "Card":
                balance = ingPage.getPersonalCardBalance();
                break;
            case "Investment":
                balance = ingPage.getPersonalInvestmentLocalBalance();
                break;
            default:
                // we should fail here. this might give false positive if balance on page is actually 00.00, etc.
                System.out.println("Unexpected type");
                balance = new BigDecimal("00.00");
        }
        Assert.assertEquals(new BigDecimal(expectedBalance), balance);
    }
}

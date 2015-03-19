package com.levelmoney.wirebugreduced;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.levelmoney.proto.reducedTest.updated.BudgetResponse;
import com.levelmoney.proto.reducedTest.updated.BudgetResponse.Builder;
import com.levelmoney.proto.reducedTest.updated.Fund;
import com.levelmoney.proto.reducedTest.updated.Transaction;
import com.squareup.wire.Wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    public void testUnknownRepeatedFieldCrash() throws IOException {
        BudgetResponse budget = new Builder()
                .expenses(getExpenses())
                .build();

        byte[] arr = budget.toByteArray();

        com.levelmoney.proto.reducedTest.old.BudgetResponse old =
                new Wire().parseFrom(arr, com.levelmoney.proto.reducedTest.old.BudgetResponse.class);

        // This will crash.
        old.toByteArray();
    }

    // Return a single-item list of Funds.
    private static List<Fund> getExpenses() {
        List<Fund> retval = new ArrayList<>();
        Fund f = new Fund.Builder()
                .seen_transactions_this_month(listOfTransactions())
                .build();
        retval.add(f);
        return retval;
    }

    // Lists longer than 1 will trigger the crash.
    private static List<Transaction> listOfTransactions() {
        List<Transaction> retval = new ArrayList<>();
        for (int j = 0; j < 2; ++j) {
            retval.add(new Transaction.Builder().build());
        }
        return retval;
    }

}
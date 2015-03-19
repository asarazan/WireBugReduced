package com.levelmoney.wirebugreduced;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.levelmoney.proto.reducedTest.updated.Response;
import com.levelmoney.proto.reducedTest.updated.Response.Builder;
import com.levelmoney.proto.reducedTest.updated.DataObject;
import com.squareup.wire.Wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing DataObjectamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    public void testUnknownRepeatedFieldCrash() throws IOException {
        Response budget = new Builder()
                .expenses(getExpenses())
                .build();

        byte[] arr = budget.toByteArray();

        com.levelmoney.proto.reducedTest.old.Response old =
                new Wire().parseFrom(arr, com.levelmoney.proto.reducedTest.old.Response.class);

        // This will crash.
        old.toByteArray();
    }

    // Return a single-item list of DataObjects.
    private static DataObject getExpenses() {
        return new DataObject.Builder()
                .newFields(listOfTransactions())
                .build();
    }

    // Lists longer than 1 will trigger the crash.
    private static List<String> listOfTransactions() {
        List<String> retval = new ArrayList<>();
        for (int j = 0; j < 2; ++j) {
            retval.add(""+j);
        }
        return retval;
    }

}
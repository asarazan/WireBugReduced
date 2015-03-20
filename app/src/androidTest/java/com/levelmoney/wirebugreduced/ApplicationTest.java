package com.levelmoney.wirebugreduced;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.levelmoney.proto.reducedTest.updated.Version1;
import com.levelmoney.proto.reducedTest.updated.Version2;
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
        Version2 data = getData();
        Version1 old = new Wire().parseFrom(data.toByteArray(), Version1.class);

        // This will crash.
        old.toByteArray();
    }

    // Return a single-item list of DataObjects.
    private static Version2 getData() {
        return new Version2.Builder()
                .newFields(listOfStrings())
                .build();
    }

    // Lists longer than 1 will trigger the crash.
    private static List<String> listOfStrings() {
        List<String> retval = new ArrayList<>();
        for (int j = 0; j < 2; ++j) {
            retval.add("");
        }
        return retval;
    }

}
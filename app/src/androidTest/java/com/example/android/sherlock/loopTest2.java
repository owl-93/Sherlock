package com.example.android.sherlock;

/**
 * Created by JazSinghsMacBookPro on 3/12/18.
 */
import com.example.android.sherlock.database.Database;

import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static junit.framework.Assert.assertEquals;

public class loopTest2 {
    @Test
    public void loop_test2() {

        Database db = new Database(getTargetContext());
        int total = db.storeCount();
        assertEquals(12, total);
    }
}

package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private final static String LOG_TAG = ExampleInstrumentedTest.class.getSimpleName();

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.udacity.gradle.builditbigger", appContext.getPackageName());
    }

    @Test
    public void pingServer() {

        final Object syncObject = new Object();

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(syncObject);
        endpointsAsyncTask.execute(new Pair<Context, String>(null, "Test string"));

        Log.d(LOG_TAG, "waiting for server... 10 seconds timeout");

        synchronized (syncObject){
            try {
                syncObject.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String result = endpointsAsyncTask.getTestResult();

        Log.d(LOG_TAG, String.format("waiting done. Result: %s", result == null ? "<null>" : result));

        assertNotNull(result);
    }
}

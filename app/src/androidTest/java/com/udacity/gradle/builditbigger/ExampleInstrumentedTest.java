package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

   @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertTrue(appContext.getPackageName().equals("com.udacity.gradle.builditbigger.free") ||
                appContext.getPackageName().equals("com.udacity.gradle.builditbigger.paid"));
    }

    Context context;

    @Test
    public void testAsyncTask() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null){
                    assertTrue(result.length() > 0);
                }
                countDownLatch.countDown();
            }
        };
        testTask.execute(new Pair<Context, String>(context, "Test string"));
        countDownLatch.await();
    }
}



package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AsyncTaskTest {
    @Test
    public void testAsyncTaskResultIsNotEmpty() throws Exception {
        final AtomicBoolean gotJoke = new AtomicBoolean(false);

        new EndpointAsyncTask(new EndpointAsyncTask.Callback() {
            @Override
            public void onResult(String joke) {
                gotJoke.set(joke != null && !joke.isEmpty());
            }
        }).execute().get();

        assertTrue(gotJoke.get());
    }
}

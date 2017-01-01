package tech.lunr.dumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import tech.lunr.dumber.builder.DumberBuilder;
import tech.lunr.dumber.model.Dummy;

/**
 * Created by IB on 2016. 12. 30..
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @InjectMocks
    private DumberBuilder builder;

    @Test
    public void testDumber() {

        builder.mock(Dummy.class);

    }




}

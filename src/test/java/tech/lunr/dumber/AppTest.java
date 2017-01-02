package tech.lunr.dumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import tech.lunr.dumber.builder.DumberBuilder;
import tech.lunr.dumber.model.Dummy;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @InjectMocks
    private DumberBuilder builder;

    @Test
    public void testDumber() {
        Dummy dummy = (Dummy)builder.mock(Dummy.class);
    }

    @Test
    public void testListDumber() {
        List<Dummy> dummies = builder.mock(Dummy.class, 5);
    }

}

package tech.lunr.dumber.field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import tech.lunr.dumber.model.Dummy;

/**
 * Field util test class
 *
 * @author IB
 */
@RunWith(MockitoJUnitRunner.class)
public class UtilTest {

    @InjectMocks
    private Util<Dummy> util;

    @Test
    public void testFieldScan() throws NoSuchFieldException, IllegalAccessException {
        util.scanFields(Dummy.class);
    }

}

package testing.asserts;

import com.odeyalo.sonata.rhythm.dto.ApiKeyResponse;
import org.assertj.core.api.StringAssert;

public class ApiKeyResponseAssert extends StringAssert {

    public ApiKeyResponseAssert(ApiKeyResponse actual) {
        super(actual.getKeyValue());
    }

    public PrefixAssert prefix() {
        return new PrefixAssert(actual);
    }

    public static class PrefixAssert extends StringAssert {
        public static final String SONATA_PREFIX = "SONATA-";

        public PrefixAssert(String actual) {
            super(actual);
        }

        public PrefixAssert isSonata() {
            return is(SONATA_PREFIX);
        }

        public PrefixAssert is(String expected) {
            startsWith(expected);
            return this;
        }
    }
}

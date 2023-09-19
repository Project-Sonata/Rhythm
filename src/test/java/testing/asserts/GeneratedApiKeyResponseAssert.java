package testing.asserts;

import com.odeyalo.sonata.rhythm.dto.GeneratedApiKeyResponse;
import org.assertj.core.api.AbstractAssert;

public class GeneratedApiKeyResponseAssert extends AbstractAssert<GeneratedApiKeyResponseAssert, GeneratedApiKeyResponse> {

    public GeneratedApiKeyResponseAssert(GeneratedApiKeyResponse actual) {
        super(actual, GeneratedApiKeyResponseAssert.class);
    }

    public static GeneratedApiKeyResponseAssert fromBody(GeneratedApiKeyResponse actual) {
        return new GeneratedApiKeyResponseAssert(actual);
    }

    public ApiKeyResponseAssert apiKey() {
        return new ApiKeyResponseAssert(actual.getApiKey());
    }
}
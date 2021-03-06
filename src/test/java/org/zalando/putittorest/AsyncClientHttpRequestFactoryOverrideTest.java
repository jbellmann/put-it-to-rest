package org.zalando.putittorest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.zalando.putittorest.Mocks.isMock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration
@Component
public final class AsyncClientHttpRequestFactoryOverrideTest {

    @Configuration
    @Import(DefaultTestConfiguration.class)
    public static class TestConfiguration {

        @Bean
        @Qualifier("example")
        public AsyncClientHttpRequestFactory exampleAsyncClientHttpRequestFactory() {
            return mock(AsyncClientHttpRequestFactory.class);
        }

    }

    @Autowired
    @Qualifier("example")
    private AsyncClientHttpRequestFactory unit;

    @Test
    public void shouldOverride() {
        assertThat(unit, isMock());
    }

}

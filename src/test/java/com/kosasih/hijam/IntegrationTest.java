package com.kosasih.hijam;

import com.kosasih.hijam.HiJamApp;
import com.kosasih.hijam.config.AsyncSyncConfiguration;
import com.kosasih.hijam.config.EmbeddedElasticsearch;
import com.kosasih.hijam.config.EmbeddedKafka;
import com.kosasih.hijam.config.EmbeddedSQL;
import com.kosasih.hijam.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { HiJamApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}

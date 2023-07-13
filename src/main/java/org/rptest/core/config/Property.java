package org.rptest.core.config;

import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigFactory;

@UtilityClass
public class Property {
    public static final Configuration COMMON_PROPERTY = ConfigFactory.create(Configuration.class);
}

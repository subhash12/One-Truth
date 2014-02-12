package com.tarshan.onebill.featureservice.health;

import com.yammer.metrics.core.HealthCheck;

public class FeatureServiceHealthCheck extends HealthCheck {
    private final String template;

    public FeatureServiceHealthCheck(String template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        // the following template string is expected: Hello, %s!
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}

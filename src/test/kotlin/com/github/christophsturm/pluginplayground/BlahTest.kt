// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.christophsturm.pluginplayground;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.DefaultLightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import com.intellij.testFramework.fixtures.MavenDependencyUtil;
import org.jetbrains.annotations.NotNull;

public class BlahTest extends LightJavaCodeInsightFixtureTestCase {

    @NotNull
    @Override
    protected LightProjectDescriptor getProjectDescriptor() {
        return new DefaultLightProjectDescriptor() {
            @Override
            public void configureModule(@NotNull Module module, @NotNull ModifiableRootModel model, @NotNull ContentEntry contentEntry) {
                super.configureModule(module, model, contentEntry);
                MavenDependencyUtil.addFromMaven(model, "com.google.code.findbugs:jsr305:3.0.2");
            }
        };
    }

    public void testItWorks() {
    }
}

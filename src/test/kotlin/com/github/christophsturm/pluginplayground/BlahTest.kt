// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.christophsturm.pluginplayground

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.testFramework.LightProjectDescriptor
import com.intellij.testFramework.fixtures.DefaultLightProjectDescriptor
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import com.intellij.testFramework.fixtures.MavenDependencyUtil

class BlahTest : LightJavaCodeInsightFixtureTestCase() {
    override fun getProjectDescriptor(): LightProjectDescriptor {
        return object : DefaultLightProjectDescriptor() {
            override fun configureModule(module: Module, model: ModifiableRootModel, contentEntry: ContentEntry) {
                super.configureModule(module, model, contentEntry)
                MavenDependencyUtil.addFromMaven(model, "com.google.code.findbugs:jsr305:3.0.2")
            }
        }
    }

    fun testItWorks() {}
}
/*
fails with this stacktrace:
java.io.IOException: Cannot find IntelliJ IDEA project files at /Users/christoph/.gradle/caches/modules-2/files-2.1/com.jetbrains.intellij.idea/ideaIC/2021.3.3/5f40ccb79bdc6dd8a8cf06560da915d22badee94/ideaIC-2021.3.3
java.lang.RuntimeException: java.io.IOException: Cannot find IntelliJ IDEA project files at /Users/christoph/.gradle/caches/modules-2/files-2.1/com.jetbrains.intellij.idea/ideaIC/2021.3.3/5f40ccb79bdc6dd8a8cf06560da915d22badee94/ideaIC-2021.3.3
	at com.intellij.testFramework.LightPlatformTestCase.initProject(LightPlatformTestCase.java:216)
	at com.intellij.testFramework.LightPlatformTestCase.lambda$doSetup$2(LightPlatformTestCase.java:274)
	at com.intellij.openapi.application.impl.ApplicationImpl.invokeAndWait(ApplicationImpl.java:437)
	at com.intellij.openapi.application.impl.ApplicationImpl.invokeAndWait(ApplicationImpl.java:455)
	at com.intellij.testFramework.LightPlatformTestCase.doSetup(LightPlatformTestCase.java:265)
	at com.intellij.testFramework.fixtures.impl.LightIdeaTestFixtureImpl.setUp(LightIdeaTestFixtureImpl.java:40)
	at com.intellij.testFramework.fixtures.impl.CodeInsightTestFixtureImpl.lambda$setUp$28(CodeInsightTestFixtureImpl.java:1242)
	at com.intellij.testFramework.EdtTestUtil.runInEdtAndWait(EdtTestUtil.java:33)
	at com.intellij.testFramework.fixtures.impl.CodeInsightTestFixtureImpl.setUp(CodeInsightTestFixtureImpl.java:1241)
	at com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase.setUp(LightJavaCodeInsightFixtureTestCase.java:105)
	at com.intellij.testFramework.UsefulTestCase.invokeSetUp(UsefulTestCase.java:476)
	at com.intellij.testFramework.UsefulTestCase.defaultRunBare(UsefulTestCase.java:468)
	at com.intellij.testFramework.UsefulTestCase.lambda$runBare$12(UsefulTestCase.java:541)
	at com.intellij.testFramework.EdtTestUtil.lambda$runInEdtAndWait$1(EdtTestUtil.java:40)
	at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:303)
	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:770)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:715)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:740)
	at com.intellij.ide.IdeEventQueue.dispatchEvent(IdeEventQueue.java:407)
	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)
Caused by: java.io.IOException: Cannot find IntelliJ IDEA project files at /Users/christoph/.gradle/caches/modules-2/files-2.1/com.jetbrains.intellij.idea/ideaIC/2021.3.3/5f40ccb79bdc6dd8a8cf06560da915d22badee94/ideaIC-2021.3.3
	at org.jetbrains.jps.model.serialization.JpsProjectLoader.loadProject(JpsProjectLoader.java:107)
	at org.jetbrains.jps.model.serialization.impl.JpsSerializationManagerImpl.loadProject(JpsSerializationManagerImpl.java:38)
	at com.intellij.project.IntelliJProjectConfiguration$Companion.loadIntelliJProject(IntelliJProjectConfiguration.kt:90)
	at com.intellij.project.IntelliJProjectConfiguration.<init>(IntelliJProjectConfiguration.kt:34)
	at com.intellij.project.IntelliJProjectConfiguration$Companion$instance$2.invoke(IntelliJProjectConfiguration.kt:48)
	at com.intellij.project.IntelliJProjectConfiguration$Companion$instance$2.invoke(IntelliJProjectConfiguration.kt:47)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at com.intellij.project.IntelliJProjectConfiguration$Companion.getInstance(IntelliJProjectConfiguration.kt)
	at com.intellij.project.IntelliJProjectConfiguration$Companion.getRemoteRepositoryDescriptions(IntelliJProjectConfiguration.kt:52)
	at com.intellij.project.IntelliJProjectConfiguration.getRemoteRepositoryDescriptions(IntelliJProjectConfiguration.kt)
	at com.intellij.testFramework.fixtures.MavenDependencyUtil.getRemoteRepositoryDescriptions(MavenDependencyUtil.java:99)
	at com.intellij.testFramework.fixtures.MavenDependencyUtil.addFromMaven(MavenDependencyUtil.java:70)
	at com.intellij.testFramework.fixtures.MavenDependencyUtil.addFromMaven(MavenDependencyUtil.java:57)
	at com.intellij.testFramework.fixtures.MavenDependencyUtil.addFromMaven(MavenDependencyUtil.java:42)
	at com.intellij.testFramework.fixtures.MavenDependencyUtil.addFromMaven(MavenDependencyUtil.java:31)
	at com.github.christophsturm.pluginplayground.BlahTest$getProjectDescriptor$1.configureModule(BlahTest.kt:50)
	at com.intellij.testFramework.LightProjectDescriptor.lambda$createContentEntry$3(LightProjectDescriptor.java:151)
	at com.intellij.openapi.roots.ModuleRootModificationUtil.lambda$updateModel$9(ModuleRootModificationUtil.java:134)
	at com.intellij.openapi.roots.ModuleRootModificationUtil.modifyModel(ModuleRootModificationUtil.java:142)
	at com.intellij.openapi.roots.ModuleRootModificationUtil.updateModel(ModuleRootModificationUtil.java:133)
	at com.intellij.testFramework.LightProjectDescriptor.createContentEntry(LightProjectDescriptor.java:140)
	at com.intellij.testFramework.LightProjectDescriptor.lambda$setUpProject$0(LightProjectDescriptor.java:45)
	at com.intellij.openapi.application.WriteAction.lambda$run$1(WriteAction.java:86)
	at com.intellij.openapi.application.impl.ApplicationImpl.runWriteActionWithClass(ApplicationImpl.java:935)
	at com.intellij.openapi.application.impl.ApplicationImpl.runWriteAction(ApplicationImpl.java:961)
	at com.intellij.openapi.application.WriteAction.run(WriteAction.java:85)
	at com.intellij.testFramework.LightProjectDescriptor.setUpProject(LightProjectDescriptor.java:39)
	at com.intellij.testFramework.LightPlatformTestCase.initProject(LightPlatformTestCase.java:195)
	... 27 more

 */

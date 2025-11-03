package com.github.nikolajovic99.microgenerator;

import com.github.nikolajovic99.microgenerator.services.MyProjectService;
import com.intellij.ide.highlighter.XmlFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlFile;
import com.intellij.testFramework.TestDataPath;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import com.intellij.util.PsiErrorElementUtil;
import org.jetbrains.annotations.NotNull;

@TestDataPath("$CONTENT_ROOT/src/test/testData")
public final class MyPluginTest extends BasePlatformTestCase {

    public void testXMLFile() {
        PsiFile psiFile = myFixture.configureByText(XmlFileType.INSTANCE, "<foo>bar</foo>");
        XmlFile xmlFile = assertInstanceOf(psiFile, XmlFile.class);

        assertFalse(PsiErrorElementUtil.hasErrors(getProject(), xmlFile.getVirtualFile()));
        assertNotNull(xmlFile.getRootTag());
        if (xmlFile.getRootTag() != null) {
            assertEquals("foo", xmlFile.getRootTag().getName());
            assertEquals("bar", xmlFile.getRootTag().getValue().getText());
        }
    }

    public void testRename() {
        myFixture.testRename("foo.xml", "foo_after.xml", "a2");
    }

    public void testProjectService() {
        Project project = getProject();
        MyProjectService projectService = project.getService(MyProjectService.class);

        assertNotSame(
                projectService.getRandomNumber(),
                projectService.getRandomNumber()
        );
    }

    @Override
    protected @NotNull String getTestDataPath() {
        return "src/test/testData/rename";
    }
}

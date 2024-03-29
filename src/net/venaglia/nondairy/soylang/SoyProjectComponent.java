/*
 * Copyright 2010 - 2013 Ed Venaglia
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.venaglia.nondairy.soylang;

import net.venaglia.nondairy.soylang.cache.SoyCacheUpdater;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.PsiElement;

/**
 * User: ed
 * Date: 1/30/12
 * Time: 7:41 PM
 *
 * Project component register template cache management logic.
 */
@State(
    name="NonDairyConfiguration",
    storages={@Storage(file = "$WORKSPACE_FILE$")}
)
public class SoyProjectComponent extends AbstractProjectComponent implements PersistentStateComponent<Object> {

    @NonNls
    public static final String NON_DAIRY_PROJECT_COMPONENT_NAME = "non-dairy.project-component";

    private final SoyCacheUpdater soyCacheUpdater;

    protected SoyProjectComponent(Project project) {
        super(project);
        soyCacheUpdater = new SoyCacheUpdater(myProject);
    }

    @Override
    public void projectOpened() {
        EditorFactory.getInstance().getEventMulticaster().addDocumentListener(new DocumentAdapter() {
            @Override
            public void documentChanged(DocumentEvent event) {
                Document document = event.getDocument();
                VirtualFile file = FileDocumentManager.getInstance().getFile(document);
                if (file != null) {
                    soyCacheUpdater.updateCache(file);
                }
            }
        });
        VirtualFileManager.getInstance().addVirtualFileListener(new VirtualFileAdapter() {
            @Override
            public void fileCreated(VirtualFileEvent event) {
                soyCacheUpdater.updateCache(event.getFile());
            }

            @Override
            public void fileDeleted(VirtualFileEvent event) {
                soyCacheUpdater.removeFromCache(event.getFile());
            }
        });
    }

    @Override
    public void disposeComponent() {
        soyCacheUpdater.dispose();
    }

    @NotNull
    @Override
    public String getComponentName() {
        return NON_DAIRY_PROJECT_COMPONENT_NAME;
    }

    @Override
    public Object getState() {
        // todo
        return null;
    }

    @Override
    public void loadState(Object state) {
        // todo
    }

    public SoyCacheUpdater getSoyCacheUpdater() {
        return soyCacheUpdater;
    }

    @Nullable
    public static SoyProjectComponent getSoyProjectComponent(@Nullable Project project) {
        Object component = project == null ? null : project.getComponent(NON_DAIRY_PROJECT_COMPONENT_NAME);
        return component instanceof SoyProjectComponent ? (SoyProjectComponent)component : null;
    }

    @Nullable
    public static SoyProjectComponent getSoyProjectComponent(@Nullable PsiElement element) {
        return element == null ? null : getSoyProjectComponent(element.getProject());
    }
}

/**
 * Yobi, Project Hosting SW
 *
 * Copyright 2013 NAVER Corp.
 * http://yobi.io
 *
 * @Author Yi EungJun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package support;

import org.eclipse.jgit.api.errors.GitAPIException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Git {
    public static RevCommit commit(Repository repository, String wcPath, String fileName,
                                   String contents, String commitMessage) throws IOException, GitAPIException {
        org.eclipse.jgit.api.Git git = new org.eclipse.jgit.api.Git(repository);
        BufferedWriter out = new BufferedWriter(new FileWriter(wcPath + "/" + fileName));
        out.write(contents);
        out.flush();
        git.add().addFilepattern(fileName).call();
        return git.commit().setMessage(commitMessage).call();
    }
}

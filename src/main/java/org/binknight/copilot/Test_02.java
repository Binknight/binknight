package org.binknight.copilot;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Test_02 {
    public static void main(String[] args) {
        // 获取git对象
        Git git = getGitObject();
        // use java get github branch
        try {
            List<Ref> call = git.branchList().call();
            Ref ref = call.get(0);
            String name = ref.getName();
            System.out.println(name);
            //获取log 对象
            Iterable<RevCommit> logs = git.log().call();
            // 遍历log对象获取commit对象，然后从commit对象中获取author name并打印
            logs.forEach(log -> {
                System.out.println(log.getAuthorIdent().getName());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 用jgti API获取git对象
    public static Git getGitObject() {
        String dir = "C:\\Users\\Administrator\\IdeaProjects\\binknight";
        Repository repository = null;
        try {
            repository = new FileRepositoryBuilder()
                    .setGitDir(Paths.get(dir, ".git").toFile())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 用java code获取git对象
        Git git = new Git(repository);
        return git;
    }
}

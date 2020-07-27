package uk.co.newcastle.rh.graphmaven.service;

import uk.co.newcastle.rh.graphmaven.domain.nodes.Artifact;

import java.util.List;

public interface ArtifactService {

    List<Artifact> findAllPagination(int pageSize,int depth);

    List<Artifact> findAllZeroDepth();

    Artifact save(Artifact artifact);

    List<Artifact> findByGroupId(String groupId);

    List<Artifact> findArtifactId(String artifactId);

    List<Artifact> findArtifactIdLike(String artifactId);

    List<Artifact> findGroupIdLike(String groupId);

    List<Artifact> findByGav(String gav,int depth);

    //List<Artifact> findAllDependOnCurrent(String gav,int hop, int limit);

    List<Artifact> findAllDependOnCurrent(String gav,int limit);
}

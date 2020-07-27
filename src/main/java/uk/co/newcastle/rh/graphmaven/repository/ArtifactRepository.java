package uk.co.newcastle.rh.graphmaven.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.newcastle.rh.graphmaven.domain.nodes.Artifact;

import java.util.List;


@Repository
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    @Query("MATCH (a:Artifact) WHERE a.groupId = $groupId RETURN a")
    List<Artifact> getAllByGroupId(String groupId);

    @Query("MATCH (a:Artifact) WHERE a.gav = $gav RETURN a")
    List<Artifact> getAllByGav(String gav);

    @Query("MATCH (a:Artifact) WHERE a.artifactId = $artifactId RETURN a")
    List<Artifact> getAllByArtifactId(String artifactId);

    @Query("MATCH (a:Artifact) WHERE a.artifactId CONTAINS $artifactId RETURN a")
    List<Artifact> getAllByArtifactIdContains(String artifactId);

    @Query("MATCH (a:Artifact) WHERE a.groupId CONTAINS $groupId RETURN a")
    List<Artifact> getALlByGroupIdContains(String groupId);

    @Query("MATCH (connected)-[:DEPEND_ON*]->(root:Artifact {gav: $gav})\n" +
            "WHERE root <> connected RETURN distinct connected limit $limit")
    List<Artifact> findAllDependOnCurrent(String gav,int limit);

    List<Artifact> findDependOnByArtifactId(String artifactId, Sort sort);

    @Query("MATCH (a:Artifact {gav:$gav}) return ID(a)")
    Long getIdByGav(String gav);

    /*@Query("MATCH (connected)-[:DEPEND_ON*$hop]->(root:Artifact {gav: $gav})\n" +
            "WHERE root <> connected RETURN distinct connected")
    List<Artifact> findAllDependOnCurrent(String gav,int hop,int limit);*/
}

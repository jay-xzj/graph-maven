package uk.co.newcastle.rh.graphmaven.domain.nodes;

import io.swagger.annotations.ApiModelProperty;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import uk.co.newcastle.rh.graphmaven.domain.Neo4jEntity;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

@NodeEntity
public class Organization extends Neo4jEntity implements Serializable {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String name;

    private String url;

    //organization owns a serials of projects(Artifacts)
    @Relationship(type = "OWN")
    @ApiModelProperty(hidden = true)
    private Set<Artifact> artifacts;

    public void updateFrom(Organization organization){
        this.name = Optional.ofNullable(organization.name).orElse(this.name);
        this.url = Optional.ofNullable(organization.url).orElse(this.url);
    }
}

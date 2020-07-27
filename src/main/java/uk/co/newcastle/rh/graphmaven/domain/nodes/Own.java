package uk.co.newcastle.rh.graphmaven.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import uk.co.newcastle.rh.graphmaven.domain.Neo4jEntity;

import java.io.Serializable;

@Setter
@Getter
@RelationshipEntity(type = "OWN")
public class Own extends Neo4jEntity implements Serializable {

    @JsonIgnore
    @StartNode
    private Organization organization;

    @EndNode
    private Artifact artifact;

}

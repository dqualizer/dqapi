package dqualizer.research.dqapi.models.dst;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class ActorWorkObjectConnection extends Connection{
    @DBRef
    private Actor initiator;
    @DBRef
    private WorkObject target;
}

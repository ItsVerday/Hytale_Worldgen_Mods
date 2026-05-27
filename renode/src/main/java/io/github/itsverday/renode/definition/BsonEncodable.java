package io.github.itsverday.renode.definition;

import org.bson.BsonDocument;
import org.bson.BsonValue;

public abstract class BsonEncodable {
   public abstract BsonValue encode();

    public BsonDocument encodeAsDocument() {
        return encode().asDocument();
    }
}

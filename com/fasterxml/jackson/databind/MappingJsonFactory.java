package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import java.io.IOException;

public class MappingJsonFactory extends JsonFactory {
    private static final long serialVersionUID = -6744103724013275513L;

    public MappingJsonFactory() {
        this(null);
    }

    public MappingJsonFactory(ObjectMapper mapper) {
        super(mapper);
        if (mapper == null) {
            setCodec(new ObjectMapper((JsonFactory) this));
        }
    }

    public MappingJsonFactory(JsonFactory src, ObjectMapper mapper) {
        super(src, mapper);
        if (mapper == null) {
            setCodec(new ObjectMapper((JsonFactory) this));
        }
    }

    public final ObjectMapper getCodec() {
        return (ObjectMapper) this._objectCodec;
    }

    public JsonFactory copy() {
        _checkInvalidCopy(MappingJsonFactory.class);
        return new MappingJsonFactory(this, null);
    }

    public String getFormatName() {
        return JsonFactory.FORMAT_NAME_JSON;
    }

    public MatchStrength hasFormat(InputAccessor acc) throws IOException {
        if (getClass() == MappingJsonFactory.class) {
            return hasJSONFormat(acc);
        }
        return null;
    }
}

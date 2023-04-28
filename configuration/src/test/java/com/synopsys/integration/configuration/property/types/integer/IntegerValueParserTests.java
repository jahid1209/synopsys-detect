package com.synopsys.integration.configuration.property.types.integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.synopsys.integration.configuration.parse.ValueParseException;

public class IntegerValueParserTests {
    private final IntegerValueParser parser = new IntegerValueParser();

    @ParameterizedTest
    @ValueSource(strings = { "unknown", "Nan", "", " 1", "9223372036854775807" })
    public void parseUnknownThrows(String value) {
        Assertions.assertThrows(ValueParseException.class, () -> parser.parse(value));
    }

    @Test
    public void parseInt() throws ValueParseException {
        Assertions.assertEquals( -1, parser.parse("-1"));
        Assertions.assertEquals(1, parser.parse("1"));
        Assertions.assertEquals(Integer.MAX_VALUE, parser.parse("2147483647"));
        Assertions.assertEquals(Integer.MIN_VALUE, parser.parse("-2147483648"));
    }
}
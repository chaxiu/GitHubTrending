package com.meteor.vchat.base.util.moshi

import com.squareup.moshi.*


/**
 * Author: zhutao
 * Desc:
 */

object NullStringAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: String?) {
        writer.value(value)
    }
}
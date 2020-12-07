package com.lyx.demo.infrastructure.util;

import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import java.io.IOException;

/**
 * @author Ryan
 */
public class ProtoJsonUtils {

	public static String toJson(Message sourceMessage) throws IOException {
		return JsonFormat.printer().print(sourceMessage);
	}

	public static Message toProto(Message.Builder targetBuilder, String json) throws IOException {
		JsonFormat.parser().merge(json, targetBuilder);
		return targetBuilder.build();
	}
}

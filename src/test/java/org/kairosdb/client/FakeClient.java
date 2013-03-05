/*
 * Copyright 2013 Proofpoint Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.kairosdb.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FakeClient extends Client
{
	private int responseCode;
	private String responseJson;

	protected FakeClient(String host, int port)
	{
		super(host, port);
	}

	public void setResponseCode(int code)
	{
		this.responseCode = code;
	}

	public void setResponseJson(String json)
	{
		this.responseJson = json;
	}

	@Override
	protected int postData(String json, String url) throws IOException
	{
		return responseCode;
	}

	@Override
	protected int queryData(String url) throws IOException
	{
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	protected InputStream getGetResponseStream() throws IOException
	{
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@SuppressWarnings("StringConcatenationInsideStringBufferAppend")
	@Override
	protected InputStream getPostResponseStream() throws IOException
	{
		return new ByteArrayInputStream(responseJson.getBytes());
	}


}
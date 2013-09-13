/*
 * Copyright (C) Institute of Telematics, Lukas Ruge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ambientdynamix.contextplugins.foaf;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.ambientdynamix.api.application.IContextInfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * The PingContextInfo is a simple extension of the standard IContextInfo Interface. It receives a String and stores this to be retreived.
 * 
 * 
 * @author lukas
 *
 */
public class FoafContextInfo implements IContextInfo
{

	private final String TAG = Constants.TAG;
	String foafcontent="";
	
	public static Parcelable.Creator<FoafContextInfo> CREATOR = new Parcelable.Creator<FoafContextInfo>() 
			{
			public FoafContextInfo createFromParcel(Parcel in) 
			{
				return new FoafContextInfo(in);
			}

			public FoafContextInfo[] newArray(int size) 
			{
				return new FoafContextInfo[size];
			}
		};
		
	FoafContextInfo()
	{
		foafcontent=FoafPluginRuntime.getFoafText();
	}
	
	public FoafContextInfo(Parcel in) 
	{
		foafcontent=in.readString();
	}

	@Override
	public String toString() 
	{
		return this.getClass().getSimpleName();
	}
	
	@Override
	public int describeContents() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) 
	{
		out.writeString(foafcontent);
	}

	@Override
	public String getContextType() 
	{
		return "org.ambientdynamix.contextplugins.context.info.individual.profile";
	}

	@Override
	public String getImplementingClassname() 
	{
		return this.getClass().getName();
	}

	@Override
	public String getStringRepresentation(String format) 
	{
		String result="";
		if (format.equalsIgnoreCase("text/plain"))
		{
			//return id;
		}
		else if (format.equalsIgnoreCase("XML"))
		{
			//return "<ping>"+id+"</ping>";
		}
		else if (format.equalsIgnoreCase("JSON"))
		{
			//return "ping: "+id;
		}
		return null;
	}

	@Override
	public Set<String> getStringRepresentationFormats() 
	{
		Set<String> formats = new HashSet<String>();
		formats.add("text/plain");
		formats.add("XML");
		formats.add("JSON");
		return formats;
	}

}
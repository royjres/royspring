package com.jrs.appraisalconnect.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadResponse {
	private String fileName;
	private String downloadUri;
	private long size;
}
